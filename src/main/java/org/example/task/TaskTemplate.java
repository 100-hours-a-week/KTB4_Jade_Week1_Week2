package org.example.task;

import org.example.system.IoView;
import org.example.system.RandomNumberUtil;

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

    public final boolean evaluate(String input) {
        validate(input);
        if (Integer.parseInt(input) == answer) {
            IoView.printCorrect();
            return true;
        }
        IoView.printWrong() ;
        return false;
    }

    protected abstract void validate(String input);
    protected abstract int getMinRange();
    protected abstract int getMaxRange();
    protected abstract boolean tryTask(int attempts);
}
