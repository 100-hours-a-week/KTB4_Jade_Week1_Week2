package org.example.person.instructor;

import org.example.task.TaskStrategy;

public class AiInstructor extends Instructor {
    private static final String NAME = "ALEX";

    public AiInstructor(TaskStrategy taskStrategy) {
        super(NAME, taskStrategy);
    }
}