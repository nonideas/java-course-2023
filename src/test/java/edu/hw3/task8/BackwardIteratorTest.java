package edu.hw3.task8;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class BackwardIteratorTest {
    @Test
    void testHasNext() {
        List<Integer> numbers = Arrays.asList(1, 2);
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(numbers);
        assertTrue(backwardIterator.hasNext());
        assertEquals(2, backwardIterator.next());
        assertEquals(1, backwardIterator.next());
        assertFalse(backwardIterator.hasNext());
    }

    @Test
    void testNextThrowsException() {
        List<Integer> numbers = Arrays.asList(1, 2);
        BackwardIterator<Integer> backwardIterator = new BackwardIterator<>(numbers);

        backwardIterator.next();
        backwardIterator.next();

        assertThrows(NoSuchElementException.class, backwardIterator::next);
    }
}
