package org.example.task;

public class NumberGuess extends TaskTemplate {
    private static final int MIN_ARRANGE = 1;
    private static final int MAX_ARRANGE = 10;
    private static final String VALID_NUMBER_INPUT = "1~10 사이의 숫자를 입력하세요.";

    @Override
    protected void validate(int number) {
        if (number < MIN_ARRANGE || number > MAX_ARRANGE) {
            throw new IllegalArgumentException(VALID_NUMBER_INPUT);
        }
    }

    @Override
    public String toString() {
        return "================================\n" +
                " 강사가 " + MIN_ARRANGE + "~" + MAX_ARRANGE + " 사이의 숫자를 선택했습니다.\n" +
                " " + MAX_ATTEMPTS + "번 안에 맞춰보세요!\n" +
                "================================";
    }

    @Override
    protected int getMinRange() {
        return MIN_ARRANGE;
    }

    @Override
    protected int getMaxRange() {
        return MAX_ARRANGE;
    }

    @Override
    public void printDescription() {
        System.out.println(this);
    }
}