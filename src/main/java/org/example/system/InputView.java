package org.example.system;

import java.util.Scanner;

public class InputView {
    private InputView() {}

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputName() {
        return SCANNER.nextLine();
    }

    public static String selectTrack() {
        return SCANNER.nextLine();
    }

    public static String getInput() {
        return SCANNER.nextLine();
    }
}