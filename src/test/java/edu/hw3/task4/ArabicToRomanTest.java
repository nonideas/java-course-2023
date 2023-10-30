package edu.hw3.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArabicToRomanTest {

    @Test
    @DisplayName("Преобразовать 2 в II")
    void testConvertToRomanFor2() {
        assertEquals("II", ArabicToRoman.convertToRoman(2));
    }

    @Test
    @DisplayName("Преобразовать 12 в XII")
    void testConvertToRomanFor12() {
        assertEquals("XII", ArabicToRoman.convertToRoman(12));
    }

    @Test
    @DisplayName("Преобразовать 19 в XIX")
    void testConvertToRomanFor19() {
        assertEquals("XIX", ArabicToRoman.convertToRoman(19));
    }

    @Test
    @DisplayName("Преобразовать 3999 в MMMCMXCIX")
    void testConvertToRomanFor3999() {
        assertEquals("MMMCMXCIX", ArabicToRoman.convertToRoman(3999));
    }

    @Test
    @DisplayName("Для 0")
    void testConvertToRomanForZero() {
        assertThrows(IllegalArgumentException.class, () -> ArabicToRoman.convertToRoman(0));
    }

    @Test
    @DisplayName("Отрицательное число")
    void testConvertToRomanForNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> ArabicToRoman.convertToRoman(-1));
    }

    @Test
    @DisplayName("Число больше 3999")
    void romanForNumberGreaterThan3999() {
        assertThrows(IllegalArgumentException.class, () -> ArabicToRoman.convertToRoman(4000));
    }
}

