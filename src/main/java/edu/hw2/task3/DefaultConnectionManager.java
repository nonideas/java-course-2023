package edu.hw2.task3;

public class DefaultConnectionManager implements ConnectionManager {
    static private final double FAULT_PROBABILITY = 0.5;

    @Override
    public Connection getConnection() {
        if (Math.random() < FAULT_PROBABILITY) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
