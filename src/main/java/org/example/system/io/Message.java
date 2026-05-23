package org.example.system.io;

public final class Message {
    private Message() {}

    public static final String INTRODUCE = "================================\n" +
            " 카테부 캠퍼스에 오신 걸 환영합니다!\n" +
            "================================";
    public static final String NAME_VIEW = "이름을 입력하세요: ";
    public static final String TRACK_VIEW = "원하는 트랙의 번호를 입력하세요. (1.Cloud / 2.AI / 3.FullStack): ";
    public static final String PASS_VIEW = "================================\n" +
            " 수료증 획득 🎓\n" +
            "================================";
    public static final String NON_PASS_VIEW = "================================\n" +
            " 수료 실패 😢\n" +
            "================================";
    public static final String ASK_RETRY_VIEW = "\n재도전하시겠습니까? (1.예 / 2.아니오): ";
    public static final String VALID_TRACK_INPUT = "1, 2, 3 중 하나를 입력하세요.";
    public static final String VALID_RETRY_INPUT = "1 또는 2를 입력하세요.";
    public static final String CORRECT_TASK_ANSWER = "정답입니다!!";
    public static final String WRONG_TASK_ANSWER = "땡! 틀렸습니다!!\n";
    public static final String VALID_NUMERIC_INPUT = "숫자를 입력하세요.";
}