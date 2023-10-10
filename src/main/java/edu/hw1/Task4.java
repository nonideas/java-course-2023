package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public final class Task4 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task4() {
    }

    public static String fixString(@NotNull String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length - 1; i += 2) {
            char temp = charArray[i];
            charArray[i] = charArray[i + 1];
            charArray[i + 1] = temp;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        LOGGER.info(fixString("hTsii  s aimex dpus rtni.g"));
        LOGGER.info(fixString("badce"));
    }
}
