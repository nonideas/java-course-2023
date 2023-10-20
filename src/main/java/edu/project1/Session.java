package edu.project1;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    Session(String answer) {
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        Arrays.fill(userAnswer, '*');
        this.maxAttempts = answer.length();
        this.attempts = 0;
    }

    private boolean isHit(char guess) {
        boolean hit = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                hit = true;
            }
        }
        return hit;
    }

    @NotNull GuessResult giveUp() {
        return new GuessResult.Defeat(userAnswer, maxAttempts);
    }

    @NotNull GuessResult guess(char guess) {
        boolean hit = isHit(guess);

        if (Arrays.equals(userAnswer, answer.toCharArray())) {
            return new GuessResult.Win(userAnswer);
        }

        if (hit) {
            return new GuessResult.SuccessfulGuess(userAnswer);
        } else if (attempts >= maxAttempts - 1) {
            return new GuessResult.Defeat(userAnswer, maxAttempts);
        } else {
            attempts++;
            return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts);
        }
    }

    public char[] getUserAnswer() {
        return userAnswer;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public String getAnswer() {
        return answer;
    }
}

