package edu.hw8.task3.passwordHackers;

import java.util.Map;

public class PasswordHackerMono extends PasswordHacker {
    public PasswordHackerMono() {
    }

    public PasswordHackerMono(String path) {
        super(path);
    }

    public Map<String, String> cracked(int minLen, int maxLen) {
        var currentNumber = getFirstNumber(minLen, maxLen);
        currentNumber[0]--;
        var nextNumber = getNextNumber(currentNumber);

        while (nextNumber.isPresent()) {
            currentNumber = nextNumber.get();

            String password = getPassword(currentNumber);
            handlePassword(password);
            if (hashDB.isEmpty()) {
                break;
            }

            nextNumber = getNextNumber(currentNumber);
        }

        return cracked;
    }
}
