package org.example;

import org.example.system.Controller;
import org.example.system.io.IoController;

public class Main {
    public static void main(String[] args) {
        IoController.printInit();
        new Controller(IoController.inputName()).run();
    }
}