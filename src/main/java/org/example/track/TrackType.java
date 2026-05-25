package org.example.track;

import org.example.person.instructor.*;
import org.example.task.guess.ChamChamCham;
import org.example.task.guess.NumberGuess;
import org.example.task.guess.RockPaperScissors;
import org.example.task.race.Race;

import java.util.Arrays;
import java.util.List;

import static org.example.system.io.Message.VALID_TRACK_TYPE;

public enum TrackType {
    CLOUD("1", "Cloud"),
    AI("2", "AI"),
    FULLSTACK("3", "FullStack"),
    THREAD("4", "Thread");

    private final String code;
    private final String name;

    TrackType(String code, String name) {
        this.code = code;
        this.name = name;
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
            case THREAD -> new ThreadInstructor(new Race(getTrackNames()));
        };
    }

    private static List<String> getTrackNames() {
        return Arrays.stream(values())
                .filter(t -> t != THREAD)
                .map(t -> t.name)
                .toList();
    }

    public String getName() {
        return name;
    }
}
