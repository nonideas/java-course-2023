package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task4Test {
    @Test
    void test1() {
        Assertions.assertTrue(Task4.isStrongPassword("!aboba"));
    }

    @Test
    void test2() {
        Assertions.assertTrue(Task4.isStrongPassword("abo&ba"));
    }

    @Test
    void test3() {
        Assertions.assertTrue(Task4.isStrongPassword("aboba$"));
    }

    @Test
    void test4() {
        Assertions.assertTrue(Task4.isStrongPassword("!abo$@ba|"));
    }

    @Test
    void test5() {
        Assertions.assertFalse(Task4.isStrongPassword("aboba"));
    }
}
