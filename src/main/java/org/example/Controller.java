package org.example;

import org.example.system.io.InputOutputView;
import org.example.system.io.Message;
import org.example.system.io.OutputView;
import org.example.person.instructor.Instructor;
import org.example.person.student.Student;
import org.example.track.TrackType;

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
        while (true) {
            try {
                String inputTrack = InputOutputView.selectTrack();
                return TrackType.from(inputTrack).createInstructor();
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private boolean playRound() {
        Instructor instructor = createInstructor();
        instructor.announceTask();
        boolean isPass = instructor.createTask();
        student.recordScore(isPass);

        if (isPass) OutputView.printPass();
        else OutputView.printNonPass();

        return askRetry();
    }

    private boolean askRetry() {
        while (true) {
            try {
                return parseRetry(InputOutputView.askRetry());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private boolean parseRetry(String input) {
        return switch (input) {
            case "1" -> true;
            case "2" -> false;
            default -> throw new IllegalArgumentException(Message.VALID_RETRY_INPUT);
        };
    }
}