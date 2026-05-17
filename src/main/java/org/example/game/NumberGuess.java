package org.example.game;

import org.example.system.IoView;
import org.example.system.RandomNumberUtil;

public class NumberGuess implements TaskStrategy {
    private static final int MAX_ATTEMPTS = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 10;
    private static final String VALID_NUMBER_INPUT = "1~10 사이의 숫자를 입력하세요.";
    private String answer;

    @Override
    public boolean run() {
        answer = String.valueOf(RandomNumberUtil.generate(MIN_NUMBER, MAX_NUMBER));
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
        int number = Integer.parseInt(input);
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(VALID_NUMBER_INPUT);
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
                " 강사가 " + MIN_NUMBER + "~" + MAX_NUMBER + " 사이의 숫자를 선택했습니다.\n" +
                " " + MAX_ATTEMPTS + "번 안에 맞춰보세요!\n" +
                "================================";
    }
}