package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    @DisplayName("Тестирование с четным количеством символов")
    void testFixStringWithEvenLengthString() {
        assertEquals("214365", Task4.fixString("123456"));
    }

    @Test
    @DisplayName("Тестирование с нечетным количеством символов")
    void testFixStringWithOddLengthString() {
        assertEquals("2143657", Task4.fixString("1234567"));
    }

    @Test
    @DisplayName("Тестирование с перемешанными символами и пробелами")
    void testFixStringWithMixedUpString() {
        assertEquals("This is a mixed up string.", Task4.fixString("hTsii  s aimex dpus rtni.g"));
    }

    @Test
    @DisplayName("Тестирование с пустой строкой")
    void testFixStringWithEmptyString() {
        assertEquals("", Task4.fixString(""));
    }

    @Test
    @DisplayName("Тестирование с одним символом")
    void testFixStringWithSingleCharacterString() {
        assertEquals("a", Task4.fixString("a"));
    }
}
