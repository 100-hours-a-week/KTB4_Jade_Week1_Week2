package org.example.task;

import org.example.system.IoView;
import org.example.system.RandomNumberUtil;

public class ChamChamCham implements TaskStrategy {
    private static final int MAX_ATTEMPTS = 3;
    private static final String VALID_DIRECTION_INPUT = "1, 2, 3 중 하나를 입력하세요.";
    private String answer;

    @Override
    public boolean run() {
        answer = String.valueOf(RandomNumberUtil.generate(1, 3));
        for (int i = 1; i <= MAX_ATTEMPTS; i++) {
            if (tryTask(i)) return true;
        }
        return false;
    }

    private boolean tryTask(int attempt) {
        IoView.printAttemptsCount(attempt);
        return evaluate(IoView.getInput());
    }

    @Override
    public boolean evaluate(String input) {
        if (!input.equals("1") && !input.equals("2") && !input.equals("3")) {
            throw new IllegalArgumentException(VALID_DIRECTION_INPUT);
        }
        if (input.equals(answer)) {
            IoView.printCorrect();
            return true;
        }
        IoView.printWrong();
        return false;
    }

    @Override
    public String toString() {
        return "================================\n" +
                " " + MAX_ATTEMPTS + "번 안에 공격을 예측하면 통과!\n" +
                " (1.왼쪽 / 2.정면 / 3.오른쪽)\n" +
                "================================";
    }
}