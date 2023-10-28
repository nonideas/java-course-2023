package edu.hw3.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FreqDict {

    private FreqDict() {
    }

    public static <T> Map<T, Integer> freqDict(ArrayList<T> objects) {
        Map<T, Integer> freqDictHashMap = new HashMap<>();
        for (var object : objects) {
            freqDictHashMap.merge(object, 1, Integer::sum);
        }
        return freqDictHashMap;
    }
}
