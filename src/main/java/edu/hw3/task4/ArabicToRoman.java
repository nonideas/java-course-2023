package edu.hw3.task4;

public class ArabicToRoman {
    private ArabicToRoman() {
    }

    @SuppressWarnings("MagicNumber")
    public static String convertToRoman(int num) {
        int curNum = num;

        if (curNum < 1 || curNum > 3999) {
            throw new IllegalArgumentException("Число должно быть в пределах от 1 до 3999");
        }

        int[] arabicValues = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };
        String[] romanNumerals = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };

        StringBuilder romanNumber = new StringBuilder();

        int i = 0;
        while (curNum > 0) {
            if (curNum >= arabicValues[i]) {
                romanNumber.append(romanNumerals[i]);
                curNum -= arabicValues[i];
                continue;
            }
            i++;
        }
        return romanNumber.toString();
    }
}
