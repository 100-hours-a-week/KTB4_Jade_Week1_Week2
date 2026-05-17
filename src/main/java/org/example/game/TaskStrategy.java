package org.example.game;

public interface TaskStrategy {
    boolean run();
    boolean evaluate(String input);

    default void printDescription() {
        System.out.println(this);
    }
}