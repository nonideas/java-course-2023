package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task1 {
    public static final int MAX_MINUTES = 35791393;
    public static final int SECONDS_IN_MINUTE = 60;
    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {
    }

    public static int minutesToSeconds(String time) {
        if (time == null || !time.matches("\\d{1,10}:\\d{2}")) {
            return -1;
        }
        String[] minSec = time.split(":");
        int minutes = Integer.parseInt(minSec[0]);
        int seconds = Integer.parseInt(minSec[1]);

        if (seconds >= SECONDS_IN_MINUTE || minutes > MAX_MINUTES) {
            return -1;
        }
        return minutes * SECONDS_IN_MINUTE + seconds;
    }
}
