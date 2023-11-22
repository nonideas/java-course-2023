package edu.hw5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task7Test {
    @Test
    void testThirdSymbolZero() {
        Assertions.assertTrue(Task7.thirdSymbolZero("110"));
        Assertions.assertTrue(Task7.thirdSymbolZero("1001"));
        Assertions.assertFalse(Task7.thirdSymbolZero("11"));
        Assertions.assertFalse(Task7.thirdSymbolZero("1110"));
    }

    @Test
    void testSameStartEnd() {
        Assertions.assertFalse(Task7.sameStartEnd("1110"));
        Assertions.assertTrue(Task7.sameStartEnd("1011"));
        Assertions.assertTrue(Task7.sameStartEnd("0110"));
    }

    @Test
    void testLengthInRange13() {
        Assertions.assertTrue(Task7.lengthInRange13("0"));
        Assertions.assertTrue(Task7.lengthInRange13("01"));
        Assertions.assertTrue(Task7.lengthInRange13("011"));
        Assertions.assertFalse(Task7.lengthInRange13("0111"));
        Assertions.assertFalse(Task7.lengthInRange13(""));
    }
}
