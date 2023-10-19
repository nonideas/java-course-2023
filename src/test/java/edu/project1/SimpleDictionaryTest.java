package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleDictionaryTest {
    @Test
    @DisplayName("Словарь не нулевой")
    void randomDictionaryNotNull() {
        String[] words = {"cat", "dog", "java", "programming"};
        Dictionary dictionary = new SimpleDictionary(words);
        assertNotNull(dictionary.randomWord());
    }

    @Test
    @DisplayName("randomWord возвращает не null")
    void randomWordReturnNonEmptyString() {
        String[] words = {"cat", "dog", "java", "programming"};
        Dictionary dictionary = new SimpleDictionary(words);
        String word = dictionary.randomWord();
        assertFalse(word.isEmpty());
    }

    @Test
    @DisplayName("Совпадение слова из словаря с заданным")
    void singleWordInDictionary() {
        String[] words = {"hello"};
        Dictionary dictionary = new SimpleDictionary(words);
        String word = dictionary.randomWord();
        assertEquals("hello", word);
    }

    @Test
    @DisplayName("Ошибка при пустом словаре")
    void randomWordFromEmptyDictionary() {
        String[] emptyWords = {};
        Dictionary emptyDictionary = new SimpleDictionary(emptyWords);
        assertThrows(IllegalStateException.class, emptyDictionary::randomWord);
    }
}
