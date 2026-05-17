package org.example.game;

public class ChamChamCham implements TaskStrategy {

    @Override
    public boolean run() {
        return false;
    }

    @Override
    public void printDescription() {
        System.out.println(this);
    }
}