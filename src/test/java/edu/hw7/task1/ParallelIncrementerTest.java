package edu.hw7.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParallelIncrementerTest {
    @Test
    void zeroThreads() {
        var res = ParallelIncrementer.increment(5, 0);
        Assertions.assertEquals(5, res);
    }

    @Test
    void oneThreads() {
        var res = ParallelIncrementer.increment(5, 1);
        Assertions.assertEquals(6, res);
    }

    @Test
    void twoThreads() {
        var res = ParallelIncrementer.increment(5, 2);
        Assertions.assertEquals(7, res);
    }

    @Test
    void manyThreads() {
        var res = ParallelIncrementer.increment(5, 100);
        Assertions.assertEquals(105, res);
    }
}
