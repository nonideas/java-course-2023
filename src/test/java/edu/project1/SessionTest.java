package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SessionTest {
    @Test
    @DisplayName("Инициализация Session")
    void correctInitialization() {
        Session session = new Session("hello");
        assertEquals("*****", new String(session.getUserAnswer()));
        assertEquals(5, session.getMaxAttempts());
        assertEquals(0, session.getAttempts());
    }

    @Test
    @DisplayName("Проверка SuccessfulGuess")
    void correctGuess() {
        Session session = new Session("hello");
        GuessResult result = session.guess('o');
        assertEquals("****o", new String(session.getUserAnswer()));
        assertTrue(result instanceof GuessResult.SuccessfulGuess);
        assertEquals("Hit!", result.message());
    }

    @Test
    @DisplayName("Проверка FailedGuess")
    void incorrectGuess() {
        Session session = new Session("hello");
        GuessResult result = session.guess('x');
        assertEquals("*****", new String(session.getUserAnswer()));
        assertTrue(result instanceof GuessResult.FailedGuess);
        assertEquals("Missed, mistake 1 out of 5.", result.message());
    }

    @Test
    @DisplayName("Проверка Win")
    void winGame() {
        Session session = new Session("hello");
        session.guess('h');
        session.guess('e');
        session.guess('l');
        GuessResult result = session.guess('o');
        assertEquals("hello", new String(session.getUserAnswer()));
        assertTrue(result instanceof GuessResult.Win);
        assertEquals("Hit!", result.message());
    }

    @Test
    @DisplayName("Проверка Defeat")
    void defeatGame() {
        Session session = new Session("hello");
        session.guess('x');
        session.guess('y');
        session.guess('z');
        session.guess('a');
        session.guess('b');
        GuessResult result = session.guess('c');
        assertEquals("*****", new String(session.getUserAnswer()));
        assertTrue(result instanceof GuessResult.Defeat);
        assertEquals("Missed, mistake 5 out of 5.", result.message());
    }

    @Test
    @DisplayName("Проверка giveUp")
    void giveUpGame() {
        Session session = new Session("hello");
        GuessResult result = session.giveUp();
        assertEquals("*****", new String(session.getUserAnswer()));
        assertTrue(result instanceof GuessResult.Defeat);
        assertEquals("Missed, mistake 5 out of 5.", result.message());
    }
}
