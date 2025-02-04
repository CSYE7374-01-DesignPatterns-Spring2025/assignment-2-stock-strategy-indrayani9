package edu.neu.csye7374;

import java.util.List;

public class BullPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Stock stock) {
        List<Double> bids = stock.getBids();
        double priceChange = 0;

        if (bids.size() >= 5) {
            int gains = 0, losses = 0;
            for (int i = bids.size() - 5; i < bids.size(); i++) {
                double currentBid = bids.get(i);
                double previousBid = bids.get(i - 1);

                if (currentBid > previousBid) {
                    gains++;
                } else {
                    losses++;
                }
            }

            double rsi = Math.min((gains / (double) (gains + losses)) * 100, 10);
            double bullishMultiplier = 1 + (rsi / 100);
            priceChange = bids.get(bids.size() - 1) * bullishMultiplier;
        } else {
            priceChange = bids.get(bids.size() - 1) * 1.5;
        }

        return Math.max(stock.getPrice() + priceChange, 0);
    }
}
