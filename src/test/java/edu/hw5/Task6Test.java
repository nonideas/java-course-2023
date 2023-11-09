package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task6Test {
    @Test
    void test1() {
        Assertions.assertTrue(Task6.isSubsequence("bob", "aboba"));
    }

    @Test
    void test2() {
        Assertions.assertFalse(Task6.isSubsequence("biba", "aboba"));
    }

    @Test
    void test3() {
        Assertions.assertTrue(Task6.isSubsequence("aboba", "aboba"));
    }

    @Test
    void test4() {
        Assertions.assertTrue(Task6.isSubsequence("", "aboba"));
    }

    @Test
    void test5() {
        Assertions.assertFalse(Task6.isSubsequence("!", "aboba"));
    }
}
