package edu.hw8.task1.server.phraseDB;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PhraseDB {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String DEFAULT_FILE_PATH = "./src/main/java/edu/hw8/task1/server/phraseDB/phrases.txt";
    private final Map<String, List<String>> phrasesByWord = new HashMap<>();

    public PhraseDB(String filePath) {
        loadPhrases(filePath);
    }

    public PhraseDB() {
        this(DEFAULT_FILE_PATH);
    }

    private void loadPhrases(String filePath) {
        try (Scanner scanner = new Scanner(new FileInputStream(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] phrase = line.split("::");
                List<String> phraseList = new ArrayList<>();
                if (phrasesByWord.containsKey(phrase[0])) {
                    phraseList = phrasesByWord.get(phrase[0]);
                }
                phraseList.add(phrase[1]);
                phrasesByWord.put(phrase[0], phraseList);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String getPhrase(String word) {
        if (!phrasesByWord.containsKey(word.toLowerCase())) {
            LOGGER.info("No phrase");
            return "No such phrase";
        }
        List<String> phrases = phrasesByWord.get(word.toLowerCase());
        String phrase = phrases.get(ThreadLocalRandom.current().nextInt(0, phrases.size()));
        LOGGER.info("found phrase: {}", phrase);

        return phrase;
    }
}
