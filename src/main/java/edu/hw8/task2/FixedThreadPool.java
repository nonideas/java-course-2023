package edu.hw8.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FixedThreadPool implements ThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final List<Thread> threads;
    private boolean isRunning;

    public FixedThreadPool(int threadsNumber) {
        this.taskQueue = new LinkedBlockingQueue<>();
        this.threads = new ArrayList<>();
        for (int i = 0; i < threadsNumber; i++) {
            threads.add(new Worker());
        }
        this.isRunning = true;
    }

    public static FixedThreadPool create(int threadsNumber) {
        return new FixedThreadPool(threadsNumber);
    }

    @Override
    public void start() {
        threads.forEach(Thread::start);
    }

    @Override
    public void execute(Runnable runnable) {
        if (isRunning) {
            taskQueue.add(runnable);
        }
    }

    @Override
    public void close() throws Exception {
        isRunning = false;
        for (Thread thread : threads) {
            thread.interrupt();
            thread.join();
        }
    }

    private class Worker extends Thread {
        @Override
        public void run() {
            while (isRunning || !taskQueue.isEmpty()) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException ignored) {
                }
            }
        }
    }
}
