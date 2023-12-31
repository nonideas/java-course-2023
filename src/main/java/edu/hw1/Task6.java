package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task6 {
    private final static int KAPREKAR_CONSTANT = 6174;
    private final static Logger LOGGER = LogManager.getLogger();

    private Task6() {
    }

    @SuppressWarnings("MagicNumber")
    public static int countK(int number) {
        if (number < 1000 || number > 9999) {
            throw new IllegalArgumentException("Введено некорректное четырехзначное число.");
        }
        if (number == KAPREKAR_CONSTANT) {
            return 0;
        }

        char[] digits = String.valueOf(number).toCharArray();
        Arrays.sort(digits);

        int ascendingNumber = Integer.parseInt(new String(digits));

        StringBuilder reversed = new StringBuilder(new String(digits)).reverse();
        int descendingNumber = Integer.parseInt(reversed.toString());

        int difference = descendingNumber - ascendingNumber;

        return 1 + countK(difference);
    }
}
