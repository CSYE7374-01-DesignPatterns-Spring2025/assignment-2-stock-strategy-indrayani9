package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    protected String name;
    protected double price;
    protected String description;
    private PricingStrategy pricingStrategy;
     protected List<Double> bids = new ArrayList<>();

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    public List<Double> getBids(){
        return bids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void updatePrice(List<Double> bids) {
            this.bids.addAll(bids);
            this.price = pricingStrategy.calculatePrice(this);
    }

    @Override
    public String toString() {
        return "Stock name = " + name +
               ", Stock price = " + price +
               ", Stock description = " + description +
               ", Current strategy: " + (pricingStrategy != null ? pricingStrategy.getClass().getSimpleName() : "None");
    }
}
