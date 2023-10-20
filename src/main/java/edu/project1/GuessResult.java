package edu.project1;

import org.jetbrains.annotations.NotNull;

sealed interface GuessResult {
    char[] state();

    @NotNull String message();

    record Defeat(char[] state, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Missed, mistake " + maxAttempts + " out of " + maxAttempts + ".";
        }
    }

    record Win(char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Hit!";
        }
    }

    record SuccessfulGuess(char[] state) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Hit!";
        }
    }

    record FailedGuess(char[] state, int attempt, int maxAttempts) implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Missed, mistake " + attempt + " out of " + maxAttempts + ".";
        }
    }
}
