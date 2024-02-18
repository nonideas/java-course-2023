package edu.hw8.task1;

import edu.hw8.task1.server.Server;
import java.io.IOException;

public class ServerTest {
    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.run();
    }
}
