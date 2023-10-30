package edu.hw3.task7;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.TreeMap;

public class NullTreeMapComparatorTest {
    @Test
    void testNullContains() {
        TreeMap<String, String> treeMap = new TreeMap<>(new NullTreeMapComparator<>());
        treeMap.put(null, "nullData");

        Assertions.assertTrue(treeMap.containsKey(null));
        Assertions.assertEquals("nullData", treeMap.get(null));
    }
}
