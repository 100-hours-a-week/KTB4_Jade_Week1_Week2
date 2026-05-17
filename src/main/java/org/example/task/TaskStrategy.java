package org.example.task;

public interface TaskStrategy {
    boolean run();
    boolean evaluate(String input);

    default void printDescription() {
        System.out.println(this);
    }
}