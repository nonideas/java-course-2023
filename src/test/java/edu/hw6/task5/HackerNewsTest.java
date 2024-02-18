package edu.hw6.task5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HackerNewsTest {
    @Test
    void getNewsName_should_returnNewsName_byGivenId() {
        String title = HackerNews.news(37570037);
        Assertions.assertEquals("JDK 21 Release Notes", title);
    }

    @Test
    void testHackerNewsTopStories() {
        long[] topStories = HackerNews.hackerNewsTopStories();
        Assertions.assertTrue(topStories.length > 0);
    }
}
