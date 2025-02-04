package edu.neu.csye7374;

import java.util.List;

public class BearPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(Stock stock) {
        List<Double> bids = stock.getBids();
        double declineFactor = 1.0;

        if (bids.size() >= 5) {
            double latestBid = bids.get(bids.size() - 1);
            double previousBid = bids.get(bids.size() - 2);
            double earlierBid = bids.get(bids.size() - 3);

            if (latestBid < previousBid && previousBid < earlierBid) {
                declineFactor = 2.0;
            }
        }

        double priceChange = -bids.get(bids.size() - 1) * declineFactor;
        return Math.max(stock.getPrice() + priceChange, 0);
    }
}
