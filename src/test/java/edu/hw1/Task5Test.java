package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class Task5Test {
    @Test
    @DisplayName("Тестирование для числа с четным количеством цифр и палиндромного потомка")
    void testEvenLengthNumberWithPalindromeDescendant() {
        assertTrue(Task5.isPalindromeDescendant(11211230));
    }

    @Test
    @DisplayName("Тестирование для числа с четным количеством цифр и не палиндромного потомка")
    void testEvenLengthNumberWithNonPalindromeDescendant() {
        assertFalse(Task5.isPalindromeDescendant(12345678));
    }

    @Test
    @DisplayName("Тестирование для числа с четным количеством цифр и самого палиндрома")
    void testEvenLengthNumberWithPalindromeItself() {
        assertTrue(Task5.isPalindromeDescendant(1221));
    }

    @Test
    @DisplayName("Тестирование для числа с одной цифрой")
    void testSingleDigitNumber() {
        assertFalse(Task5.isPalindromeDescendant(1));
    }

    @Test
    @DisplayName("Тестирование для числа с нечетным количеством цифр")
    void testOddLengthNumber() {
        assertFalse(Task5.isPalindromeDescendant(12345));
    }

    @Test
    @DisplayName("Тестирование для отрицательного числа")
    void testNegativeNumber() {
        assertFalse(Task5.isPalindromeDescendant(-1221));
    }
}

