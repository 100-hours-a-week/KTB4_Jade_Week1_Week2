package org.example.task;

import org.example.system.io.InputView;
import org.example.system.io.Message;
import org.example.system.io.OutputView;
import org.example.system.util.RandomNumberUtil;

public abstract class TaskTemplate implements TaskStrategy {
    protected static final int MIN_ATTEMPTS = 1;
    protected static final int MAX_ATTEMPTS = 3;
    protected int answer;

    @Override
    public final boolean run() {
        answer = makeAnswer(getMinRange(), getMaxRange());
        for (int i = MIN_ATTEMPTS; i <= MAX_ATTEMPTS; i++) {
            if (tryTask(i)) return true;
        }
        return false;
    }

    private int makeAnswer(int minRange, int maxRange) {
        return RandomNumberUtil.generate(minRange, maxRange);
    }

    private boolean tryTask(int attempt) {
        OutputView.printAttemptsCount(attempt);
        return evaluate(InputView.getInput());
    }

    public final boolean evaluate(String input) {
        int number = validateNumeric(input);  // 변환
        validate(number);
        if (Integer.parseInt(input) == answer) {
            OutputView.printCorrect();
            return true;
        }
        OutputView.printWrong() ;
        return false;
    }

    private int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.VALID_NUMERIC_INPUT);
        }
    }


    protected abstract void validate(int number);
    protected abstract int getMinRange();
    protected abstract int getMaxRange();
}
