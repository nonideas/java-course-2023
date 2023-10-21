package edu.project1;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("MultipleStringLiterals")
sealed interface GuessResult {
    char[] state();

    @NotNull String message();

    String gameOver();

    record Defeat(char[] state, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Missed, mistake " + maxAttempts + " out of " + maxAttempts + ".";
        }

        @Override
        public String gameOver() {
            return "You lost!";
        }
    }

    record Win(char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Hit!";
        }

        @Override
        public String gameOver() {
            return "You won!";
        }
    }

    record SuccessfulGuess(char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Hit!";
        }

        @Override
        public String gameOver() {
            return null;
        }
    }

    record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Missed, mistake " + attempt + " out of " + maxAttempts + ".";
        }

        @Override
        public String gameOver() {
            return null;
        }
    }
}
