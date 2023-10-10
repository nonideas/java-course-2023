package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateBitsTest {
    @Test
    @DisplayName("Тестирование для сдвига влево")
    void testRotateLeft() {
        assertEquals(1, Task7.rotateLeft(16, 1));
        assertEquals(6, Task7.rotateLeft(17, 2));
        assertEquals(8, Task7.rotateLeft(8, 4));
        assertEquals(0, Task7.rotateLeft(0, 3));
        assertEquals(7, Task7.rotateLeft(7, 0));
        assertEquals(1, Task7.rotateLeft(1, 2));
    }

    @Test
    @DisplayName("Тестирование для сдвига вправо")
    void testRotateRight() {
        assertEquals(4, Task7.rotateRight(8, 1));
        assertEquals(8, Task7.rotateRight(8, 4));
        assertEquals(0, Task7.rotateRight(0, 3));
        assertEquals(7, Task7.rotateRight(7, 0));
        assertEquals(1, Task7.rotateRight(1, 3));
    }
}
