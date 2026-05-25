package org.example.system.io;

public class InputOutputView {
    private InputOutputView() {}

    public static void printInit() {
        OutputView.printInit();
    }

    public static String inputName() {
        OutputView.printNameView();
        return InputView.getInput();
    }

    public static String selectTrack() {
        OutputView.printTrackView();
        return InputView.getInput();
    }

    public static String askRetry() {
        OutputView.printAskRetry();
        return InputView.getInput();
    }

    public static String inputRacePredict() {
        OutputView.printPredictView();
        return InputView.getInput();
    }

}