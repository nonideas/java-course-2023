package edu.hw5;

public class Task7 {
    private Task7() {
    }

    public static boolean thirdSymbolZero(String bits) {
        return bits.matches("^[01]{2}0[01]*");
    }

    public static boolean sameStartEnd(String bits) {
        return bits.matches("^(0|1).*\\1$");
    }

    public static boolean lengthInRange13(String bits) {
        return bits.matches("[01]{1,3}");
    }
}
