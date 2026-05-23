package org.example.task;

import org.example.system.IoView;

public class ChamChamCham extends TaskTemplate {
    private static final int MIN_ARRANGE = 1;
    private static final int MAX_ARRANGE = 3;
    private static final String VALID_DIRECTION_INPUT = "1, 2, 3 중 하나를 입력하세요.";

    @Override
    protected boolean tryTask(int attempt) {
        IoView.printAttemptsCount(attempt);
        return evaluate(IoView.getInput());
    }

    @Override
    protected void validate(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            throw new IllegalArgumentException(VALID_DIRECTION_INPUT);
        }
    }

    @Override
    public String toString() {
        return "================================\n" +
                " " + MAX_ATTEMPTS + "번 안에 공격을 예측하면 통과!\n" +
                " (1.왼쪽 / 2.정면 / 3.오른쪽)\n" +
                "================================";
    }

    @Override
    protected int getMinRange() { return MIN_ARRANGE; }

    @Override
    protected int getMaxRange() { return MAX_ARRANGE; }

    @Override
    public void printDescription() {
        System.out.println(this);
    }
}