package org.example.system;

import java.util.Scanner;

public class IoView {
    private static final String PRINT_INTRODUCE = "================================\n" +
            " 카테부 캠퍼스에 오신 걸 환영합니다!\n" +
            "================================";
    private static final String PRINT_NAME_VIEW = "이름을 입력하세요: ";
    private static final String PRINT_TRACK_VIEW = "원하는 트랙의 번호를 입력하세요. (1.Cloud / 2.AI / 3.FullStack): ";
    private static final String PRINT_PASS_VIEW = "================================\n" +
            " 수료증 획득 🎓\n" +
            "================================";
    private static final String PRINT_ASK_RETRY_VIEW = "포기하지 마십시오. 재도전하시겠습니까? (1.예 / 2.아니오): ";

    public static final String VALID_TRACK_INPUT = "1, 2, 3 중 하나를 입력하세요.";
    public static final String VALID_RETRY_INPUT = "1 또는 2를 입력하세요.";
    public static final String CORRECT_TASK_ANSWER = "정답입니다!!";
    public static final String WRONG_TASK_ANSWER = "땡! 틀렸습니다!!";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void printInit() {
        System.out.println(PRINT_INTRODUCE);
    }

    public static String inputName() {
        System.out.print(PRINT_NAME_VIEW);
        return SCANNER.nextLine();
    }

    public static String selectTrack() {
        System.out.print(PRINT_TRACK_VIEW);
        return SCANNER.nextLine();
    }

    public static void printCorrect() {
        System.out.printf(CORRECT_TASK_ANSWER);
    }

    public static void printWrong() {
        System.out.printf(WRONG_TASK_ANSWER);
    }

    public static void printPass() {
        System.out.println(PRINT_PASS_VIEW);
    }

    public static String printAskRetry() {
        System.out.print(PRINT_ASK_RETRY_VIEW);
        return SCANNER.nextLine();
    }

    public static String getInput() {
        return SCANNER.nextLine();
    }

    public static void printAttemptsCount(int attempts) {
        System.out.print("[" + attempts + "번째 시도] 입력하세요: ");
    }
}