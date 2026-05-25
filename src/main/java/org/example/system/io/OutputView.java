package org.example.system.io;

public class OutputView {
    private OutputView() {}

    public static void printInit() {
        System.out.println(Message.INTRODUCE);
    }

    public static void printNameView() {
        System.out.print(Message.NAME_VIEW);
    }

    public static void printTrackView() {
        System.out.print(Message.TRACK_VIEW);
    }

    public static void printCorrect() {
        System.out.println(Message.CORRECT_TASK_ANSWER);
    }

    public static void printWrong() {
        System.out.println(Message.WRONG_TASK_ANSWER);
    }

    public static void printPass() {
        System.out.println(Message.PASS_VIEW);
    }

    public static void printNonPass() {
        System.out.println(Message.NON_PASS_VIEW);
    }

    public static void printError(String message) {
        System.out.println(message);
    }

    public static void printAskRetry() {
        System.out.print(Message.ASK_RETRY_VIEW);
    }

    public static void printAttemptsCount(int attempts) {
        System.out.print("[" + attempts + "번째 시도] 입력하세요: ");
    }

    public static void printPredictView() {
        System.out.print(Message.PREDICT_VIEW);
    }

    public static void printStartRacing() {
        System.out.println(Message.START_RACING);
    }
}