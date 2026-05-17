package org.example.system;

import java.util.Random;

public class RandomNumberUtil {
    public static int generate(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}