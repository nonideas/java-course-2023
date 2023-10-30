package edu.hw3.task4;

public class ArabicToRoman {
    private static final int MIN_ARABIC_NUMBER = 1;
    private static final int MAX_ARABIC_NUMBER = 3999;
    private static final int[] ARABIC_VALUES = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    private static final String[] ROMAN_NUMERALS = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    private ArabicToRoman() {
    }

    public static String convertToRoman(int num) {
        int curNum = num;

        if (curNum < MIN_ARABIC_NUMBER || curNum > MAX_ARABIC_NUMBER) {
            throw new IllegalArgumentException("Число должно быть в пределах от 1 до 3999");
        }

        StringBuilder romanNumber = new StringBuilder();

        int i = 0;
        while (curNum > 0) {
            if (curNum >= ARABIC_VALUES[i]) {
                romanNumber.append(ROMAN_NUMERALS[i]);
                curNum -= ARABIC_VALUES[i];
                continue;
            }
            i++;
        }
        return romanNumber.toString();
    }
}
