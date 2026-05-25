package org.example;

import org.example.system.io.InputOutputView;

public class Main {
    public static void main(String[] args) {
        InputOutputView.printInit();
        new Controller(InputOutputView.inputName()).run();
    }
}