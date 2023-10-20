package edu.project1;

import java.util.Scanner;

class ConsoleHangman {
    private final Dictionary dictionary;

    ConsoleHangman(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void run() {
        String word = dictionary.randomWord().toLowerCase();
        Session session = new Session(word);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Guess a letter:");
            String guess = scanner.nextLine().toLowerCase();

            GuessResult result = tryGuess(session, guess);

            if (result == null) {
                System.out.println("Write one letter!!!");
                continue;
            }

            printState(result);

            if (result instanceof GuessResult.Defeat) {
                System.out.println("You lost!");
                break;
            } else if (result instanceof GuessResult.Win) {
                System.out.println("You won!");
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
        System.out.println(guessResult.message());
        System.out.println("The word: " + new String(guessResult.state()));
    }
}

