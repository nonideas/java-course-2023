package edu.hw7.task4;

import java.util.Random;

public abstract class MonteCarlo {
    abstract double calculatePi(int totalCount);

    protected int pointsInCircle(int totalCount) {
        int circleCount = 0;
        Random rnd = new Random();
        double x;
        double y;
        for (int i = 0; i < totalCount; i++) {
            x = rnd.nextDouble();
            y = rnd.nextDouble();
            if (x * x + y * y < 1) {
                circleCount++;
            }
        }
        return circleCount;
    }
}
