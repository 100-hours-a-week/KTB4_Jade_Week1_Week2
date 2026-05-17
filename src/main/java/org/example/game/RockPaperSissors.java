package org.example.game;


public class RockPaperSissors implements TaskStrategy {

    @Override
    public boolean run() {
        return false;
    }

    @Override
    public void printDescription() {
        System.out.println(this);
    }
}