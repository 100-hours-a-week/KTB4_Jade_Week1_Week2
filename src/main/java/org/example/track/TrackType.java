package org.example.track;

import org.example.person.instructor.AiInstructor;
import org.example.person.instructor.CloudInstructor;
import org.example.person.instructor.FullStackInstructor;
import org.example.person.instructor.Instructor;
import org.example.task.ChamChamCham;
import org.example.task.NumberGuess;
import org.example.task.RockPaperScissors;

import static org.example.system.io.Message.VALID_TRACK_TYPE;

public enum TrackType {
    CLOUD("1"),
    AI("2"),
    FULLSTACK("3");

    private final String code;

    TrackType(String code) {
        this.code = code;
    }

    public static TrackType from(String inputCode) {
        for (TrackType trackType : values()) {
            if(trackType.code.equals(inputCode))
                return trackType;
        }
        throw new IllegalArgumentException(VALID_TRACK_TYPE);
    }

    public Instructor createInstructor() {
        return switch (this) {
            case CLOUD -> new CloudInstructor(new NumberGuess());
            case AI -> new AiInstructor(new ChamChamCham());
            case FULLSTACK -> new FullStackInstructor(new RockPaperScissors());
        };
    }
}
