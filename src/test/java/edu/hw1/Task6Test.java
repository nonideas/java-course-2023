package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task6Test {
    @Test
    @DisplayName("Тестирование для четырехзначного нормального числа")
    void testCountKFourDigitNumber() {
        assertEquals(3, Task6.countK(3524));
        assertEquals(3, Task6.countK(1234));
        assertEquals(5, Task6.countK(6621));
        assertEquals(4, Task6.countK(6554));
    }

    @Test
    @DisplayName("Тестирование для числа 6174")
    void testCountKWith6174() {
        assertEquals(0, Task6.countK(6174));
    }

    @Test
    @DisplayName("Тестирование с числом менее четырех знаков")
    void testCountKWithLessThanFourDigits() {
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(123));
    }

    @Test
    @DisplayName("Тестирование с числом более четырех знаков")
    void testCountKWithMoreThanFourDigits() {
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(12345));
    }

    @Test
    @DisplayName("Тестирование с неправильным четырехзначным числом")
    void testCountKIllegalFourDigits() {
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(1111));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(1121));
        assertThrows(IllegalArgumentException.class, () -> Task6.countK(1110));
    }
}

