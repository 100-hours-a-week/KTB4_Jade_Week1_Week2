package org.example.system;

import org.example.person.instructor.AiInstructor;
import org.example.person.instructor.CloudInstructor;
import org.example.person.instructor.FullStackInstructor;
import org.example.person.instructor.Instructor;
import org.example.person.student.Student;

public class Controller {
    private final String userName;

    public Controller(String userName) {
        this.userName = userName;
    }

    public void run() {
        boolean isRetry = true;
        while (isRetry) {
            isRetry = playRound();
        }
    }

    public Instructor createInstructor() {
        String inputTrack = IoView.selectTrack();
        return switch (inputTrack) {
            case "1" -> new CloudInstructor();
            case "2" -> new AiInstructor();
            case "3" -> new FullStackInstructor();
            default -> throw new IllegalArgumentException(IoView.VALID_TRACK_INPUT);
        };
    }

    public boolean playRound() {
        Student student = new Student(userName);
        Instructor instructor = createInstructor();
        boolean isPass = instructor.task();
        return handleRetryByResult(isPass);
    }

    public boolean handleRetryByResult(boolean isPass) {
        if(isPass) {
            IoView.printPass();
            return false;
        }
        return askRetry();
    }

    public boolean askRetry() {
        String inputRetry = IoView.printAskRetry();
        return switch (inputRetry) {
            case "1" -> true;
            case "2" -> false;
            default -> throw new IllegalArgumentException(IoView.VALID_RETRY_INPUT);
        };
    }
}
