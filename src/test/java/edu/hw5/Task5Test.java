package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task5Test {
    @Test
    void test1() {
        Assertions.assertTrue(Task5.isRightCarNumber("А123ВЕ777"));
    }

    @Test
    void test2() {
        Assertions.assertTrue(Task5.isRightCarNumber("О777ОО177"));
    }

    @Test
    void test3() {
        Assertions.assertFalse(Task5.isRightCarNumber("123АВЕ777"));
    }

    @Test
    void test4() {
        Assertions.assertFalse(Task5.isRightCarNumber("А123ВГ77"));
    }

    @Test
    void test5() {
        Assertions.assertFalse(Task5.isRightCarNumber("А123ВЕ7777"));
    }
}
