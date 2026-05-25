package org.example.task.race;

import org.example.system.io.InputOutputView;
import org.example.system.io.OutputView;
import org.example.system.util.ValidateUtil;
import org.example.task.TaskStrategy;

import java.util.ArrayList;
import java.util.List;

public class Race implements TaskStrategy {
    private final List<Runner> runners;
    private final RaceResult raceResult;
    private static final int MIN_ARRANGE = 1;
    private static final int MAX_ARRANGE = 3;
    private static final String VALID_PREDICTION_INPUT = "1, 2, 3 중 하나를 입력하세요.";

    public Race(List<String> runnersName) {
        this.raceResult = new RaceResult();
        this.runners = runnersName.stream()
                .map(name -> new Runner(name, raceResult))
                .toList();
    }

    @Override
    public boolean run() {
        String predict = getPredict();
        racing();
        printRanking();
        return raceResult.matchWinner(predict);
    }

    private void racing() {
        OutputView.printStartRacing();
        List<Thread> threads = createThreads();
        waitForFinish(threads);
    }

    private List<Thread> createThreads() {
        List<Thread> runnersThreads = new ArrayList<>();

        for (Runner runner : runners) {
            Thread thread = new Thread(runner);
            runnersThreads.add(thread);
            thread.start();
        }

        return runnersThreads;
    }

    private void waitForFinish(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void printRanking() {
        raceResult.printRanking();
    }

    private String getPredict() {
        while (true) {
            try {
                String input = InputOutputView.inputRacePredict();
                int number = ValidateUtil.validateNumeric(input);
                validatePredict(number);
                return input;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void validatePredict(int number) {
        if (number < MIN_ARRANGE || number > MAX_ARRANGE) {
            throw new IllegalArgumentException(VALID_PREDICTION_INPUT);
        }
    }

    @Override
    public String toString() {
        return "================================\n" +
                " 카테부 트랙 달리기 경주! 1등 트랙을 예측하세요! (숫자 입력)\n" +
                " (1.Cloud / 2.AI / 3.FullStack)\n" +
                "================================";
    }

    @Override
    public void printDescription() {
        System.out.println(this);
    }
}
