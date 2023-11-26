package edu.hw7.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelIncrementer {
    private ParallelIncrementer() {
    }

    public static int increment(int number, int threadsCount) {
        AtomicInteger atomicNumber = new AtomicInteger(number);
        List<Thread> threadList = new ArrayList<>(threadsCount);
        for (int i = 0; i < threadsCount; i++) {
            threadList.add(new Thread(atomicNumber::incrementAndGet));
            threadList.getLast().start();
        }

        for (var thread : threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return atomicNumber.get();
    }
}
