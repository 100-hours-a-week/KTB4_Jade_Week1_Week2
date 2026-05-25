package org.example.system.util;

import org.example.system.io.Message;

public final class ValidateUtil {
    private ValidateUtil() {};

    static public int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.VALID_NUMERIC_INPUT);
        }
    }

}
