package edu.hw5;

public class Task6 {
    private Task6() {
    }

    public static boolean isSubsequence(String subString, String string) {
        return string.matches("^.*" + subString + ".*$");
    }
}
