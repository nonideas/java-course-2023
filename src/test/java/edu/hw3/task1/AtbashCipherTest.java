package edu.hw3.task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AtbashCipherTest {

    @Test
    @DisplayName("Пустая строка")
    void testAtbashWithEmptyString() {
        String result = AtbashCipher.atbash("");
        assertEquals("", result);
    }

    @Test
    @DisplayName("Без букв")
    void testAtbashWithNonLatinCharacters() {
        String input = "123!@#";
        String result = AtbashCipher.atbash(input);
        assertEquals(input, result);
    }

    @Test
    @DisplayName("Все маленькие буквы")
    void testAtbashWithLowerCase() {
        String input = "abcdefghijklmnopqrstuvwxyz";
        String expectedOutput = "zyxwvutsrqponmlkjihgfedcba";
        String result = AtbashCipher.atbash(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    @DisplayName("Все большие буквы")
    void testAtbashWithUpperCase() {
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String expectedOutput = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        String result = AtbashCipher.atbash(input);
        assertEquals(expectedOutput, result);
    }

    @Test
    @DisplayName("Привет Мир")
    void testAtbashWithMixedCase() {
        String input = "Hello World!";
        String expectedOutput = "Svool Dliow!";
        String result = AtbashCipher.atbash(input);
        assertEquals(expectedOutput, result);
    }
}

