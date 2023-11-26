package edu.hw7.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MonteCarloMono extends MonteCarlo {
    @Override
    double calculatePi(int totalCount) {
        int circleCount = pointsInCircle(totalCount);
        return 4 * ((double) circleCount / totalCount);
    }
}
