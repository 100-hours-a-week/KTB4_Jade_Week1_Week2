package org.example;

import org.example.system.Controller;
import org.example.system.IoView;

public class Main {
    public static void main(String[] args) {
        IoView.printInit();
        String userName = IoView.inputName();
        Controller controller = new Controller(userName);

        controller.run();
    }
}