package org.example.person.instructor;

import org.example.task.TaskStrategy;
import org.example.person.Person;

public abstract class Instructor extends Person {
    protected TaskStrategy taskStrategy;

    public Instructor(String name, TaskStrategy taskStrategy) {
        super(name);
        this.taskStrategy = taskStrategy;
    }

    public void announceTask() {
        System.out.println("\n"+getName() + "가 과제를 제출합니다!");
        taskStrategy.printDescription();
    }

    public boolean createTask() {
        return taskStrategy.run();
    }
}