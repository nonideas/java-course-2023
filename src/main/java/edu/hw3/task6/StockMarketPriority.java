package edu.hw3.task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StockMarketPriority implements StockMarket {
    private final PriorityQueue<Stock> stocks;

    public StockMarketPriority() {
        stocks = new PriorityQueue<>(Comparator.comparingDouble(Stock::price));
    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.poll();
    }
}
