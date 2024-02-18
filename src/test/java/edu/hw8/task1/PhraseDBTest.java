package edu.hw8.task1;

import edu.hw8.task1.server.phraseDB.PhraseDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhraseDBTest {
    PhraseDB phraseDB = new PhraseDB();

    @Test
    void testPhraseNotInDB() {
        Assertions.assertEquals("No such phrase", phraseDB.getPhrase("неуч"));
    }

    @Test
    void testPhraseInDB() {
        Assertions.assertEquals("Чем ниже интеллект, тем громче оскорбления", phraseDB.getPhrase("интеллект"));
    }
}
