package edu.hw2.task3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConnectionTest {

    @Test
    @DisplayName("StableConnection выполняется без ошибок")
    void stableConnectionShouldExecuteCommand() {
        Connection connection = new StableConnection();
        connection.execute("ls");
        // No exception should be thrown
    }

    @Test
    @DisplayName("DefaultConnectionManager возвращает StableConnection или FaultyConnection")
    void defaultConnectionManagerShouldReturnStableOrFaultyConnection() {
        ConnectionManager manager = new DefaultConnectionManager();
        Connection connection = manager.getConnection();
        assertTrue(connection instanceof StableConnection || connection instanceof FaultyConnection);
    }

    @Test
    @DisplayName("FaultyConnectionManager возвращает FaultyConnection")
    void faultyConnectionManagerShouldAlwaysReturnFaultyConnection() {
        ConnectionManager manager = new FaultyConnectionManager();
        for (int i = 0; i < 10; i++) {
            Connection connection = manager.getConnection();
            assertTrue(connection instanceof FaultyConnection);
        }
    }

    @Test
    @DisplayName("DefaultConnectionManager при большом количестве попыток выполняется без ошибок")
    void tryExecuteShouldSucceedForStableConnection() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new DefaultConnectionManager(), 10);
        assertDoesNotThrow(() -> executor.tryExecute("ls"));
    }

    @Test
    @DisplayName("Передаю невалидную высоту")
    void tryExecuteShouldRetryFor0MaxAttempts() {
        PopularCommandExecutor executor = new PopularCommandExecutor(new FaultyConnectionManager(), 0);
        assertThrows(ConnectionException.class, () -> executor.tryExecute("ls"));
    }
}

