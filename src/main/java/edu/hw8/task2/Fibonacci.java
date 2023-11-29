package edu.hw8.task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Fibonacci {
    private static final Logger LOGGER = LogManager.getLogger();
    private Fibonacci() {
    }

    public static void calculate(int fibNumber, int threads) {
        try (ThreadPool threadPool = FixedThreadPool.create(threads)) {
            threadPool.start();
            for (int n = 1; n <= fibNumber; n++) {
                int finalN = n;
                threadPool.execute(() ->
                    LOGGER.info("For n = {} : {}", finalN, fibonacci(finalN)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
