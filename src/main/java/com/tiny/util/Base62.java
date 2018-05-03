package com.tiny.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Base62 {

    private static final String codeStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static Character getChar(int num) {
        return codeStr.charAt(num);
    }

    public static Optional<String> getShortCode(int num) {
        if (num < 0) return Optional.empty();

        if (num == 0) return Optional.of(getChar(0).toString());

        StringBuilder code = new StringBuilder();
        while (num > 0) {
            code.append(getChar(num % 62));
            num = num / 62;
        }
        return Optional.of(code.toString());
    }
}