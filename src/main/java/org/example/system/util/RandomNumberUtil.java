package org.example.system.util;

import java.util.Random;

public final class RandomNumberUtil {
    private static final Random RANDOM = new Random();

    private RandomNumberUtil() {}

    public static int generate(int min, int max) {
        return RANDOM.nextInt(max - min + 1) + min;
    }
}