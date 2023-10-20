package edu.project1;

public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        String[] words = {"cat", "dog", "java", "python"};
        Dictionary dictionary = new SimpleDictionary(words);
        ConsoleHangman consoleHangman = new ConsoleHangman(dictionary);
        consoleHangman.run();
    }
}
