package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task2() {
    }

    public static int countDigits(int number) {
        if (number == 0) {
            return 1;
        }

        if (number == Integer.MIN_VALUE) {
            return 10;
        }

        int count = 0;
        int numAbs = Math.abs(number);

        while (numAbs > 0) {
            numAbs = numAbs / 10;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        LOGGER.info(countDigits(4666));
        LOGGER.info(countDigits(544));
        LOGGER.info(countDigits(0));
    }
}
