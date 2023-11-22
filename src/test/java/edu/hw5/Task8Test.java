package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task8Test {
    @Test
    void testRule1() {
        Assertions.assertTrue(Task8.rule1("1"));
        Assertions.assertFalse(Task8.rule1("10"));
        Assertions.assertTrue(Task8.rule1("110"));
    }

    @Test
    void testRule2() {
        Assertions.assertTrue(Task8.rule2("0"));
        Assertions.assertTrue(Task8.rule2("10"));
        Assertions.assertFalse(Task8.rule2("110"));
        Assertions.assertFalse(Task8.rule2("00"));
    }

    @Test
    void testRule5() {
        Assertions.assertTrue(Task8.rule5("1"));
        Assertions.assertTrue(Task8.rule5("101"));
        Assertions.assertFalse(Task8.rule5("0"));
        Assertions.assertFalse(Task8.rule5("110"));
    }

    @Test
    void testRule7() {
        Assertions.assertTrue(Task8.rule7("1"));
        Assertions.assertTrue(Task8.rule7("101"));
        Assertions.assertTrue(Task8.rule7("00"));
        Assertions.assertFalse(Task8.rule7("11"));
        Assertions.assertFalse(Task8.rule7("0110"));
    }
}
