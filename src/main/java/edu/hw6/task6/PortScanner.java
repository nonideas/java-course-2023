package edu.hw6.task6;

import edu.hw6.task1.DiskMap;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class PortScanner {

    public static DiskMap commonPorts = new DiskMap("./src/main/java/edu/hw6/task6/commonPorts.txt");
    private static final int MIN_PORT = 0;
    private static final int MAX_PORT = 49151;

    private PortScanner() {
    }

    public static List<PortInfo> getOccupiedPorts() {

        List<PortInfo> occupiedPorts = new ArrayList<>();

        for (int port = MIN_PORT; port <= MAX_PORT; port++) {
            try {
                var serverSocket = new ServerSocket(port);
                serverSocket.close();

            } catch (Exception ex) {
                occupiedPorts.add(getPortInfo(port, "TCP"));
            }

            try {
                var datagramSocket = new DatagramSocket(port);
                datagramSocket.close();

            } catch (Exception ex) {
                occupiedPorts.add(getPortInfo(port, "UDP"));
            }
        }

        return occupiedPorts;

    }

    private static PortInfo getPortInfo(int port, String protocol) {
        String service = commonPorts.get("Port " + port);
        if (service == null) {
            service = "";
        }
        return new PortInfo(protocol, port, service);
    }

}
