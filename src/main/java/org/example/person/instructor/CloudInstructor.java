package org.example.person.instructor;

import org.example.task.TaskStrategy;

public class CloudInstructor extends Instructor {
    private static final String NAME = "CHARLIE";

    public CloudInstructor(TaskStrategy taskStrategy) {
        super(NAME, taskStrategy);
    }
}