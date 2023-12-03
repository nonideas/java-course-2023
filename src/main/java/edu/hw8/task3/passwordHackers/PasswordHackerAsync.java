package edu.hw8.task3.passwordHackers;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class PasswordHackerAsync extends PasswordHacker {
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final int countThreads = 4;

    public PasswordHackerAsync() {
    }

    public PasswordHackerAsync(String path) {
        super(path);
    }

    public Map<String, String> cracked(int minLen, int maxLen) {

        ExecutorService threadPool = Executors.newFixedThreadPool(countThreads);
        running.set(true);

        var firstNumber = getFirstNumber(minLen, maxLen);

        for (int fistDigit = 1; fistDigit < CHARACTERS.length() && running.get(); fistDigit++) {
            int finalFistDigit = fistDigit;
            threadPool.execute(() -> threadPoolTask(finalFistDigit, firstNumber));
        }

        threadPool.close();
        running.set(false);
        return cracked;
    }

    private void threadPoolTask(int firstDigit, int[] firstNumber) {
        var currentNumber = firstNumber.clone();
        currentNumber[0] = firstDigit;

        var nextNumber = Optional.of(currentNumber);

        while (nextNumber.isPresent() && running.get()) {
            currentNumber = nextNumber.get();
            String password = getPassword(currentNumber);
            handlePassword(password);
            if (hashDB.isEmpty()) {
                running.set(false);
            }
            nextNumber = getNextNumber(currentNumber);
        }
    }
}
