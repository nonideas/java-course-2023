package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task5 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task5() {
    }

    @SuppressWarnings("MagicNumber")
    public static boolean isPalindromeDescendant(int number) {
        if (isPalindrome(number)) {
            return true;
        } else {
            int descendant = findDescendant(number);
            return (descendant >= 10) && isPalindromeDescendant(descendant);
        }
    }

    @SuppressWarnings("MagicNumber")
    private static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    @SuppressWarnings("MagicNumber")
    private static int findDescendant(int number) {
        String str = String.valueOf(number);
        if (str.length() % 2 != 0) {
            return -1;
        }
        int descendant = 0;

        for (int i = 0; i < str.length() - 1; i += 2) {
            int digit1 = Character.getNumericValue(str.charAt(i));
            int digit2 = Character.getNumericValue(str.charAt(i + 1));
            descendant = descendant * 10 + (digit1 + digit2);
        }

        return descendant;
    }
}
