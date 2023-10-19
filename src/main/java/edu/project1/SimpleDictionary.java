package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

public class SimpleDictionary implements Dictionary {
    final private String[] words;

    public SimpleDictionary(String[] words) {
        this.words = words;
    }

    @Override
    @NotNull
    public String randomWord() {
        if (words.length == 0) {
            throw new IllegalStateException("Dictionary is empty");
        }
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        return words[randomIndex];
    }
}


