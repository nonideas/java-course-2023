package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ConsoleHangman {
    private final static Logger LOGGER = LogManager.getLogger();
    private final Dictionary dictionary;

    ConsoleHangman(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void run() {
        String word = dictionary.randomWord().toLowerCase();
        Session session = new Session(word);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            LOGGER.info("Guess a letter:");
            String guess = scanner.nextLine().toLowerCase();

            GuessResult result = tryGuess(session, guess);

            if (result == null) {
                LOGGER.info("Write one letter!!!");
                continue;
            }

            printState(result);

            if (result instanceof GuessResult.Defeat) {
                LOGGER.info("You lost!");
                break;
            } else if (result instanceof GuessResult.Win) {
                LOGGER.info("You won!");
                break;
            }
        }
    }

    private GuessResult tryGuess(Session session, String input) {
        if (input.equals("exit")) {
            return session.giveUp();
        }
        if (input.length() > 1) {
            return null;
        }
        char letter = input.charAt(0);
        return session.guess(letter);
    }

    private void printState(GuessResult guessResult) {
        LOGGER.info(guessResult.message());
        LOGGER.info("The word: " + new String(guessResult.state()));
    }
}

