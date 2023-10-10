package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public final class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {
    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(@NotNull String time) {
        String[] minSec = time.split(":");
        int minutes = Integer.parseInt(minSec[0]);
        int seconds = Integer.parseInt(minSec[1]);

        if (seconds < 0 || seconds >= 60 || minutes < 0) {
            return -1;
        }
        if (minutes > 35791394 || minutes == 35791394 && seconds > 7) {
            return -1;
        }
        return minutes * 60 + seconds;
    }

    @SuppressWarnings({"MagicNumber", "checkstyle:UncommentedMain"})
    public static void main(String[] args) {
        LOGGER.info(minutesToSeconds("01:00"));
        LOGGER.info(minutesToSeconds("13:56"));
        LOGGER.info(minutesToSeconds("10:60"));
        LOGGER.info(minutesToSeconds("999:59"));
        LOGGER.info(minutesToSeconds("35791394:07"));
    }
}
