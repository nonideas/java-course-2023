package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() throws ConnectionException {
        try {
            tryExecute("apt update && apt update -y");
        } catch (ConnectionException e) {
            throw new ConnectionException(e);
        }
    }

    public void installPackages() throws ConnectionException {
        try {
            tryExecute("apt install && apt install -y");
        } catch (ConnectionException e) {
            throw new ConnectionException(e);
        }
    }

    void tryExecute(String command) throws ConnectionException {
        int attempts = 0;
        Exception lastException = null;
        while (attempts < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return;
            } catch (Exception e) {
                lastException = e;
                attempts++;
            }
        }
        throw new ConnectionException("Failed to execute command after " + maxAttempts + " attempts", lastException);
    }
}

