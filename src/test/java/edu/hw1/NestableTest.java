package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NestableTest {
    @Test
    @DisplayName("Тестирование для вложенных массивов")
    void nestableArrays() {
        boolean result1 = Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6});
        assertTrue(result1);

        boolean result2 = Task3.isNestable(new int[] {3, 1}, new int[] {4, 0});
        assertTrue(result2);
    }

    @Test
    @DisplayName("Тестирование для не вложенных массивов")
    void nonNestableArrays() {
        boolean result1 = Task3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9});
        assertFalse(result1);

        boolean result2 = Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3});
        assertFalse(result2);
    }

    @Test
    @DisplayName("Тестирование для null")
    void nullArrays() {
        boolean result1 = Task3.isNestable(null, null);
        assertFalse(result1);

        boolean result2 = Task3.isNestable(null, new int[] {2, 3});
        assertFalse(result2);

        boolean result3 = Task3.isNestable(new int[] {1, 2, 3, 4}, null);
        assertFalse(result3);
    }

    @Test
    @DisplayName("Тестирование для пустых массивов")
    void emptyArrays() {
        boolean result = Task3.isNestable(new int[] {}, new int[] {});
        assertFalse(result);
    }
}

