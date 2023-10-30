package edu.hw3.task6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StockMarketPriorityTest {

    @Test
    void testNonStock() {
        StockMarketPriority stockMarket = new StockMarketPriority();

        assertNull(stockMarket.mostValuableStock());
    }
    @Test
    void testOneStock() {
        StockMarketPriority stockMarket = new StockMarketPriority();

        stockMarket.add(new Stock(1));

        assertEquals(new Stock(1), stockMarket.mostValuableStock());
    }

    @Test
    void testSomeStocks() {
        StockMarketPriority stockMarket = new StockMarketPriority();

        stockMarket.add(new Stock(1));
        stockMarket.add(new Stock(2));
        stockMarket.add(new Stock(-1));

        assertEquals(new Stock(-1), stockMarket.mostValuableStock());
    }

    @Test
    void testMostValuableStockAfterRemove() {
        StockMarketPriority stockMarket = new StockMarketPriority();

        stockMarket.add(new Stock(1));
        stockMarket.add(new Stock(2));
        stockMarket.add(new Stock(-1));

        Stock stockToDelete = new Stock(-1);
        stockMarket.remove(stockToDelete);

        assertEquals(new Stock(1), stockMarket.mostValuableStock());
    }
}
