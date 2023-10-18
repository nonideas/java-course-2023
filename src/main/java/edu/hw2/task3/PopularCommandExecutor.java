package edu.hw2.task3;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    public void installPackages() {
        tryExecute("apt install && apt install -y");
    }

    void tryExecute(String command) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                return; // Command executed successfully, exit the loop
            } catch (Exception e) {
                // Handle the exception if needed
                attempts++;
            }
        }
        throw new ConnectionException(new RuntimeException(
            "Failed to execute command after " + maxAttempts + " attempts"));
    }
}

