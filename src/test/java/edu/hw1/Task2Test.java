package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    @Test
    @DisplayName("Тестирование для положительного числа")
    void testCountDigitsWithPositiveNumber() {
        int result = Task2.countDigits(4666);

        assertEquals(4, result);
    }

    @Test
    @DisplayName("Тестирование для числа 0")
    void testCountDigitsWithZero() {
        int result = Task2.countDigits(0);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("Тестирование для отрицательного числа")
    void testCountDigitsWithNegativeNumber() {
        int result = Task2.countDigits(-12345);

        assertEquals(5, result);
    }

    @Test
    @DisplayName("Тестирование для максимального положительного числа")
    void testCountDigitsWithMaxPositiveNumber() {
        int result = Task2.countDigits(Integer.MAX_VALUE);

        assertEquals(10, result);
    }

    @Test
    @DisplayName("Тестирование для максимального отрицательного числа")
    void testCountDigitsWithMinNegativeNumber() {
        int result = Task2.countDigits(Integer.MIN_VALUE);

        assertEquals(10, result);
    }
}
