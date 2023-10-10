package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task7 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        int largerPower = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
        shift = shift % largerPower;
        int partLeft = (n << shift) & ((int) Math.pow(2, largerPower) - 1);
        int partRight = (n >>> (largerPower - shift)) & ((int) Math.pow(2, largerPower) - 1);
        return partLeft | partRight;
    }

    public static int rotateRight(int n, int shift) {
        int largerPower = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
        shift = shift % largerPower;
        int partLeft = (n >>> shift) & ((int) Math.pow(2, largerPower) - 1);
        int partRight = (n << (largerPower - shift)) & ((int) Math.pow(2, largerPower) - 1);
        return partLeft | partRight;
    }

    public static void main(String[] args) {
        LOGGER.info(rotateRight(8, 1));
        LOGGER.info(rotateLeft(16, 1));
        LOGGER.info(rotateLeft(17, 2));
    }
}
