package edu.hw6.task6;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PortPrinter {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String TABLE_FORMAT = "%12s%10s%16s";
    private static final String PROTOCOL_STRING = "protocol";
    private static final String PORT_STRING = "port";
    private static final String SERVICE_STRING = "service";

    private PortPrinter() {
    }

    public static void printPorts(List<PortInfo> ports) {
        LOGGER.info(
            String.format(
                TABLE_FORMAT,
                PROTOCOL_STRING,
                PORT_STRING,
                SERVICE_STRING
            )
        );

        ports.forEach(portInfo ->
            LOGGER.info(
                String.format(
                    TABLE_FORMAT,
                    portInfo.protocol(),
                    portInfo.port(),
                    portInfo.service()
                )
            )
        );
    }
}
