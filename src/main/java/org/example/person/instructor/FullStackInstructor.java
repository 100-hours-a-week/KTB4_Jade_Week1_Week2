package org.example.person.instructor;

import org.example.game.TaskStrategy;

public class FullStackInstructor extends Instructor {
    private static final String NAME = "KEVIN";

    public FullStackInstructor(TaskStrategy taskStrategy) {
        super(NAME, taskStrategy);
    }
}