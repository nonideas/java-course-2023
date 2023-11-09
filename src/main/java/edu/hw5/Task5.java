package edu.hw5;

public class Task5 {
    private Task5() {
    }

    public static boolean isRightCarNumber(String carNumber) {
        return carNumber.matches("^[А-Я][0-9]{3}[А-Я]{2}[0-9]{3}$");
    }
}
