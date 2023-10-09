package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public final class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {
    }

    public static int minutesToSeconds(@NotNull String time) {
        String[] min_sec = time.split(":");
        int minutes = Integer.parseInt(min_sec[0]);
        int seconds = Integer.parseInt(min_sec[1]);

        if (seconds < 0 || seconds >= 60 || minutes < 0) {
            return -1;
        }
        return minutes * 60 + seconds;
    }

    public static void main(String[] args) {
        LOGGER.info(minutesToSeconds("01:00"));
        LOGGER.info(minutesToSeconds("13:56"));
        LOGGER.info(minutesToSeconds("10:60"));
        LOGGER.info(minutesToSeconds("999:59"));
    }
}
