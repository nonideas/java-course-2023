package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task3 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task3() {
    }

    @SuppressWarnings({"MagicNumber", "checkstyle:UncommentedMain"})
    public static boolean isNestable(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return false;
        }
        if (array1.length == 0 || array2.length == 0) {
            return false;
        }

        int minArray1 = findMin(array1);
        int maxArray1 = findMax(array1);
        int minArray2 = findMin(array2);
        int maxArray2 = findMax(array2);

        return minArray1 > minArray2 && maxArray1 < maxArray2;
    }

    private static int findMin(int[] array) {
        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    private static int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        LOGGER.info(isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        LOGGER.info(isNestable(new int[] {3, 1}, new int[] {4, 0}));
        LOGGER.info(isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
        LOGGER.info(isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
    }
}
