package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Task7 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task7() {
    }

    public static int rotateLeft(int n, int shift) {
        int largerPower = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
        int shiftValue = shift % largerPower;
        int partLeft = (n << shiftValue) & ((int) Math.pow(2, largerPower) - 1);
        int partRight = (n >>> (largerPower - shiftValue)) & ((int) Math.pow(2, largerPower) - 1);
        return partLeft | partRight;
    }

    @SuppressWarnings("MagicNumber")
    public static int rotateRight(int n, int shift) {
        int largerPower = (int) Math.floor(Math.log(n) / Math.log(2)) + 1;
        int shiftValue = shift % largerPower;
        int partLeft = (n >>> shiftValue) & ((int) Math.pow(2, largerPower) - 1);
        int partRight = (n << (largerPower - shiftValue)) & ((int) Math.pow(2, largerPower) - 1);
        return partLeft | partRight;
    }
}
