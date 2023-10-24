package edu.hw3.task2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClusterizerTest {
    @Test
    @DisplayName("скобки в скобках")
    void scrapesInScrapes() {
        String exampleString = "((()))";
        String clasterizedString = Clusterizer.clusterize(exampleString).toString();
        Assertions.assertEquals("[((()))]", clasterizedString);
    }

    @Test
    @DisplayName("правильная комбинация скобок")
    void goodScrapes() {
        String exampleString = "((())())(()(()()))";
        String clasterizedString = Clusterizer.clusterize(exampleString).toString();
        Assertions.assertEquals("[((())()), (()(()()))]", clasterizedString);
    }

    @Test
    @DisplayName("неправильный порядок")
    void reversScrapes() {
        String exampleString = ")(";
        String clasterizedString = Clusterizer.clusterize(exampleString).toString();
        Assertions.assertEquals("[]", clasterizedString);
    }

    @Test
    @DisplayName("пустая строка")
    void emptyString() {
        String exampleString = "";
        String clasterizedString = Clusterizer.clusterize(exampleString).toString();
        Assertions.assertEquals("[]", clasterizedString);
    }

    @Test
    @DisplayName("нет одной скобки")
    void testWrongString() {
        String wrongInput = "((())";
        String clasterizedString = Clusterizer.clusterize(wrongInput).toString();
        Assertions.assertEquals("[]", clasterizedString);
    }

    @Test
    @DisplayName("нет скобок")
    void nonScrape() {
        String wrongInput = "aboba";
        String clasterizedString = Clusterizer.clusterize(wrongInput).toString();
        Assertions.assertEquals("[]", clasterizedString);
    }
}
