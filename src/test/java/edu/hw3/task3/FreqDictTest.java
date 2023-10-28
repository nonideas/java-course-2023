package edu.hw3.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class FreqDictTest {

    @Test
    @DisplayName("Для пустого списка")
    void freqDictWithEmptyList() {
        ArrayList<String> emptyList = new ArrayList<>();
        Map<String, Integer> result = FreqDict.freqDict(emptyList);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Список с одним элементом")
    void freqDictWithSingleElement() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(42);
        Map<Integer, Integer> result = FreqDict.freqDict(list);
        assertEquals(1, result.size());
        assertEquals(1, result.get(42));
    }

    @Test
    @DisplayName("Список с повторяющимися элементами")
    void freqDictWithRepeatedElements() {
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("orange");
        list.add("apple");
        list.add("banana");
        list.add("orange");

        Map<String, Integer> result = FreqDict.freqDict(list);

        assertEquals(3, result.size());
        assertEquals(2, result.get("apple"));
        assertEquals(2, result.get("orange"));
        assertEquals(1, result.get("banana"));
    }
}

