package edu.hw7.task2;

import java.util.stream.IntStream;

public class ParallelFactorial {
    private ParallelFactorial() {
    }

    public static int factorial(int n) {
        return IntStream
            .range(1, n + 1)
            .parallel()
            .reduce(1, Math::multiplyExact);
    }
}
