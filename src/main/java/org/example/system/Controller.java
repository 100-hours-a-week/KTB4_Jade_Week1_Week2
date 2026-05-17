package org.example.system;

import org.example.game.ChamChamCham;
import org.example.game.NumberGuess;
import org.example.game.RockPaperScissors;
import org.example.person.instructor.AiInstructor;
import org.example.person.instructor.CloudInstructor;
import org.example.person.instructor.FullStackInstructor;
import org.example.person.instructor.Instructor;
import org.example.person.student.Student;

public class Controller {
    private final Student student;

    public Controller(String userName) {
        this.student = new Student(userName);
    }

    public void run() {
        boolean isRetry = true;
        while (isRetry) {
            isRetry = playRound();
        }
        student.printFinalResult();
    }

    private Instructor createInstructor() {
        String inputTrack = IoView.selectTrack();
        return switch (inputTrack) {
            case "1" -> new CloudInstructor(new NumberGuess());
            case "2" -> new AiInstructor(new ChamChamCham());
            case "3" -> new FullStackInstructor(new RockPaperScissors());
            default -> throw new IllegalArgumentException(IoView.VALID_TRACK_INPUT);
        };
    }

    private boolean playRound() {
        Instructor instructor = createInstructor();
        instructor.announceTask();
        boolean isPass = instructor.createTask();

        if (isPass) {
            IoView.printPass();
            student.recordPass();
        }
        else {
            IoView.printNonPass();
            student.recordFail();
        }

        return askRetry();
    }

    private boolean askRetry() {
        String inputRetry = IoView.printAskRetry();
        return switch (inputRetry) {
            case "1" -> true;
            case "2" -> false;
            default -> throw new IllegalArgumentException(IoView.VALID_RETRY_INPUT);
        };
    }
}