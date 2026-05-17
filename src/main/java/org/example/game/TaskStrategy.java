package org.example.game;

public interface TaskStrategy {
    boolean run();
    void printDescription();
    boolean evaluate(String input);
}