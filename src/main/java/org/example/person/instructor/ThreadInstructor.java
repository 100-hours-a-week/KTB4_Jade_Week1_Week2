package org.example.person.instructor;

import org.example.task.TaskStrategy;

public class ThreadInstructor extends Instructor {
    private static final String NAME = "SPECIAL_INSTRUCTOR";

    public ThreadInstructor(TaskStrategy taskStrategy) {
        super(NAME, taskStrategy);
    }
}
