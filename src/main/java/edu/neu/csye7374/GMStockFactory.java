package edu.neu.csye7374;

public class GMStockFactory implements StockFactory {
    @Override
    public Stock createStock(String name, double price, String description) {
        return new GMStock(name, price, description);
    }
}
