package edu.hw8.task3.passwordHackers;

import edu.hw8.task3.hashDB.ParseHashDB;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public abstract class PasswordHacker {
    protected final Map<String, String> hashDB;
    protected final ConcurrentHashMap<String, String> cracked;
    protected static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public PasswordHacker() {
        this.hashDB = ParseHashDB.loadHash();
        this.cracked = new ConcurrentHashMap<>();
    }

    public PasswordHacker(String path) {
        this.hashDB = ParseHashDB.loadHash(path);
        this.cracked = new ConcurrentHashMap<>();
    }

    public abstract Map<String, String> cracked(int minLen, int maxLen);

    protected Optional<int[]> getNextNumber(int[] currentNumber) {
        int[] nextNumber = currentNumber.clone();
        int i = 0;
        while (i < nextNumber.length && nextNumber[i] >= CHARACTERS.length() - 1) {
            nextNumber[i] = 1;
            i++;
        }
        if (i == nextNumber.length) {
            return Optional.empty();
        }
        nextNumber[i]++;
        return Optional.of(nextNumber);
    }

    protected String getPassword(int[] number) {
        StringBuilder password = new StringBuilder();
        for (int j : number) {
            if (j == 0) {
                break;
            }
            password.append(CHARACTERS.charAt(j));
        }
        return password.toString().trim();
    }

    protected void handlePassword(String password) {
        String hash = md5Hex(password);
        String removedUser = hashDB.remove(hash);
        if (removedUser != null) {
            cracked.put(removedUser, password);
        }
    }

    @SuppressWarnings("MagicNumber")
    private static String md5Hex(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    protected int[] getFirstNumber(int minLen, int maxLen) {
        int[] number = new int[maxLen];
        for (int i = 0; i < minLen; i++) {
            number[i] = 1;
        }
        return number;
    }
}
