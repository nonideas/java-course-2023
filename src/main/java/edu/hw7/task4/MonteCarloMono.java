package edu.hw7.task4;

public class MonteCarloMono extends MonteCarlo {
    @Override
    @SuppressWarnings("MagicNumber")
    double calculatePi(int totalCount) {
        int circleCount = pointsInCircle(totalCount);
        return 4 * ((double) circleCount / totalCount);
    }
}
