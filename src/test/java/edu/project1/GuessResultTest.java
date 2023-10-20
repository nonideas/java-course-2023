package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuessResultTest {
    @Test
    @DisplayName("Поражение")
    void defeatMessage() {
        GuessResult defeat = new GuessResult.Defeat(new char[] {'*', '*', '*', '*'}, 4);
        assertEquals("Missed, mistake 4 out of 4.", defeat.message());
    }

    @Test
    @DisplayName("Победа")
    void winMessage() {
        GuessResult win = new GuessResult.Win(new char[] {'h', 'i'});
        assertEquals("Hit!", win.message());
    }

    @Test
    @DisplayName("Попадание")
    void successfulGuessMessage() {
        GuessResult successfulGuess = new GuessResult.SuccessfulGuess(new char[] {'h', 'i'});
        assertEquals("Hit!", successfulGuess.message());
    }

    @Test
    @DisplayName("Промах")
    void failedGuessMessage() {
        GuessResult failedGuess = new GuessResult.FailedGuess(new char[] {'*', '*', '*', '*'}, 2, 5);
        assertEquals("Missed, mistake 2 out of 5.", failedGuess.message());
    }

    @Test
    @DisplayName("Состояние при победе")
    void stateWin() {
        char[] state = {'h', 'e', 'l', 'l', 'o'};
        GuessResult win = new GuessResult.Win(state);
        assertArrayEquals(state, win.state());
    }

    @Test
    @DisplayName("Состояние при поражении")
    void stateDefeat() {
        char[] state = {'h', 'e', 'l', 'l', 'o'};
        GuessResult defeat = new GuessResult.Defeat(state, 5);
        assertArrayEquals(state, defeat.state());
    }

    @Test
    @DisplayName("Состояние при SuccessfulGuess")
    void stateSuccessfulGuess() {
        char[] state = {'h', 'e', 'l', 'l', 'o'};
        GuessResult successfulGuess = new GuessResult.SuccessfulGuess(state);
        assertArrayEquals(state, successfulGuess.state());
    }

    @Test
    @DisplayName("Состояние при FailedGuess")
    void stateFailedGuess() {
        char[] state = {'h', 'e', 'l', 'l', 'o'};
        GuessResult failedGuess = new GuessResult.FailedGuess(state, 2, 5);
        assertArrayEquals(state, failedGuess.state());
    }
}
