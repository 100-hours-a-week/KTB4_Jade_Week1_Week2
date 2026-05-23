package org.example.system;

public class IoController {
    private IoController() {}

    public static void printInit() {
        OutputView.printInit();
    }

    public static String inputName() {
        OutputView.printNameView();
        return InputView.inputName();
    }

    public static String selectTrack() {
        OutputView.printTrackView();
        return InputView.selectTrack();
    }

    public static String askRetry() {
        OutputView.printAskRetry();
        return InputView.getInput();
    }

    public static void printCorrect() {
        OutputView.printCorrect();
    }

    public static void printWrong() {
        OutputView.printWrong();
    }

    public static void printPass() {
        OutputView.printPass();
    }

    public static void printNonPass() {
        OutputView.printNonPass();
    }

    public static void printAttemptsCount(int attempts) {
        OutputView.printAttemptsCount(attempts);
    }

    public static String getInput() {
        return InputView.getInput();
    }
}