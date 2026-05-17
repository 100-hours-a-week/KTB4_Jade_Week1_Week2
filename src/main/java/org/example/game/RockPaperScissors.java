package org.example.game;

import org.example.system.IoView;
import org.example.system.RandomNumberUtil;

public class RockPaperScissors implements TaskStrategy {
    private static final int MAX_ATTEMPTS = 3;
    private static final String VALID_RPS_INPUT = "1, 2, 3 중 하나를 입력하세요.";
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
            throw new IllegalArgumentException(VALID_RPS_INPUT);
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
                " 강사가 가위/바위/보 중 하나를 선택했습니다.\n" +
                " " + MAX_ATTEMPTS + "번 안에 맞춰보세요!\n" +
                " (1.가위 / 2.바위 / 3.보)\n" +
                "================================";
    }
}