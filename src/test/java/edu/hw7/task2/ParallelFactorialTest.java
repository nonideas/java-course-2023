package edu.hw7.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ParallelFactorialTest {
    @Test
    void factorialZero() {
        var res = ParallelFactorial.factorial(0);
        Assertions.assertEquals(1, res);
    }

    @Test
    void factorialOne() {
        var res = ParallelFactorial.factorial(1);
        Assertions.assertEquals(1, res);
    }

    @Test
    void factorialTwo() {
        var res = ParallelFactorial.factorial(2);
        Assertions.assertEquals(2, res);
    }

    @Test
    void factorialTree() {
        var res = ParallelFactorial.factorial(3);
        Assertions.assertEquals(6, res);
    }

    @Test
    void factorialTen() {
        var res = ParallelFactorial.factorial(10);
        Assertions.assertEquals(3628800, res);
    }
}
