package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task1 {
    public static final int MAX_MINUTES = 35791393;
    public static final int MAX_SECONDS = 59;
    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {
    }

    @SuppressWarnings("MagicNumber")
    public static int minutesToSeconds(String time) {
        if (time == null || !time.matches("\\d{1,10}:\\d{2}")) {
            return -1;
        }
        String[] minSec = time.split(":");
        int minutes = Integer.parseInt(minSec[0]);
        int seconds = Integer.parseInt(minSec[1]);

        if (seconds > MAX_SECONDS || minutes > MAX_MINUTES) {
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
