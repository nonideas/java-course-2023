package edu.hw3.task3;

import java.util.ArrayList;
import java.util.HashMap;

public class FreqDict {

    private FreqDict() {
    }

    public static <T> HashMap<T, Integer> freqDict(ArrayList<T> objects) {
        HashMap<T, Integer> freqDictHashMap = new HashMap<>();
        for (var object : objects) {
            freqDictHashMap.merge(object, 1, Integer::sum);
        }
        return freqDictHashMap;
    }
}
