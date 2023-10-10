package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task6 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task6() {
    }

    public static int countK(int number) {
        // checkstyle:off MagicNumber
        if (number < 1000 || number > 9999) {
            throw new IllegalArgumentException("Введено некорректное четырехзначное число.");
        }
        if (number == 6174) {
            return 0;
        }

        char[] digits = String.valueOf(number).toCharArray();
        Arrays.sort(digits);

        int ascendingNumber = Integer.parseInt(new String(digits));

        StringBuilder reversed = new StringBuilder(new String(digits)).reverse();
        int descendingNumber = Integer.parseInt(reversed.toString());

        int difference = descendingNumber - ascendingNumber;

        return 1 + countK(difference);
        // checkstyle:on MagicNumber
    }

    public static void main(String[] args) {
        // checkstyle:off MagicNumber
        LOGGER.info(countK(3524));
        LOGGER.info(countK(6621));
        LOGGER.info(countK(6554));
        LOGGER.info(countK(1234));
        // checkstyle:on MagicNumber
    }
}
