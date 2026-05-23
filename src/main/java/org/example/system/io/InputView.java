package org.example.system.io;

import java.util.Scanner;

public class InputView {
    private InputView() {}

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getInput() {
        return SCANNER.nextLine();
    }
}