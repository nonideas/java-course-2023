package edu.hw5;

public class Task8 {
    private Task8() {
    }

    public static boolean rule1(String bits) {
        return bits.matches("^[01]([01]{2})*");
    }

    public static boolean rule2(String bits) {
        return bits.matches("^(0([01]{2})*|1[01]([01]{2})*)");
    }

    public static boolean rule5(String bits) {
        return bits.matches("^(1[01])*1?$");
    }

    public static boolean rule7(String bits) {
        return bits.matches("^(?!.*11)[01]+$");
    }
}
