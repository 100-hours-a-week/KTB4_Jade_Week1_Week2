package org.example.task.guess;

import org.example.system.io.InputView;
import org.example.system.io.OutputView;
import org.example.system.util.RandomNumberUtil;
import org.example.system.util.ValidateUtil;
import org.example.task.TaskStrategy;

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
        while (true) {
            try {
                OutputView.printAttemptsCount(attempt);
                return evaluate(InputView.getInput());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    public final boolean evaluate(String input) {
        int number = ValidateUtil.validateNumeric(input);
        validate(number);
        if (Integer.parseInt(input) == answer) {
            OutputView.printCorrect();
            return true;
        }
        OutputView.printWrong();
        return false;
    }

    protected abstract void validate(int number);
    protected abstract int getMinRange();
    protected abstract int getMaxRange();
}
