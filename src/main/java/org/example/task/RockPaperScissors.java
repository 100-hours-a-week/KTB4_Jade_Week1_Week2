package org.example.task;

import org.example.system.IoView;

public class RockPaperScissors extends TaskTemplate {
    private static final int MIN_ARRANGE = 1;
    private static final int MAX_ARRANGE = 3;
    private static final String VALID_RPS_INPUT = "1, 2, 3 중 하나를 입력하세요.";

    @Override
    protected boolean tryTask(int attempt) {
        IoView.printAttemptsCount(attempt);
        return evaluate(IoView.getInput());
    }

    @Override
    protected void validate(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            throw new IllegalArgumentException(VALID_RPS_INPUT);
        }
    }

    @Override
    public String toString() {
        return "================================\n" +
                " 강사가 가위/바위/보 중 하나를 선택했습니다.\n" +
                " " + MAX_ATTEMPTS + "번 안에 맞춰보세요!\n" +
                " (1.가위 / 2.바위 / 3.보)\n" +
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