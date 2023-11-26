package edu.hw7.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MonteCarloAsync extends MonteCarlo {
    int threadCount;

    public MonteCarloAsync(int threadCount) {
        this.threadCount = threadCount;
    }

    @Override
    @SuppressWarnings("MagicNumber")
    double calculatePi(int totalCount) {
        List<Thread> threads = new ArrayList<>();
        AtomicInteger circleCount = new AtomicInteger();
        int pointsPerThread = totalCount / threadCount;

        for (int i = 0; i < threadCount; i++) {
            threads.add(
                new Thread(() ->
                    circleCount.addAndGet(pointsInCircle(pointsPerThread))
                )
            );
            threads.getLast().start();
        }

        threads.forEach(thread -> {
                try {
                    thread.join();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        );
        return 4 * ((double) circleCount.get() / totalCount);
    }
}
