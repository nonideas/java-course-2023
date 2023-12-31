package edu.hw2.task3;

public class FaultyConnection implements Connection {
    private static final double FAULT_PROBABILITY = 0.3;

    @Override
    public void execute(String command) throws ConnectionException {
        // Implement the execute method for faulty connection
        if (Math.random() < FAULT_PROBABILITY) {
            throw new ConnectionException("Failed to execute command");
        }
    }

    @Override
    public void close() {
        // Implement the close method for faulty connection
    }
}
