package edu.neu.csye7374;

import java.util.List;

public class Demo {

    public static void demo() {
        StockFactory ibmFactory = new IBMStockFactory();
        StockFactory gmFactory = new GMStockFactory();

        Stock ibmStock = ibmFactory.createStock("IBM", 150.0, "IBM Corp Stock");
        Stock gmStock = gmFactory.createStock("GM", 75.0, "General Motors Stock");
        System.out.println("================================Before strategy=======================================");
        System.out.println("Regular Factory IBMStock: " + ibmStock);
        System.out.println("Regular Factory GMStock: " + gmStock);

        ibmStock.setPricingStrategy(new BullPricingStrategy());
        ibmStock.updatePrice(List.of(101.0, 102.0, 103.0, 104.0, 105.0, 106.0, 105.5));
        System.out.println(
                "================================After Bull strategy=======================================");
        System.out.println(ibmStock);

        ibmStock.setPricingStrategy(new BearPricingStrategy());
        ibmStock.updatePrice(List.of(10.0, 15.0, 20.0, 25.0, 30.0, 30.0, 30.00));
        System.out.println(
                "================================After Bear strategy=======================================");
        System.out.println(ibmStock);

        gmStock.setPricingStrategy(new BearPricingStrategy());
        gmStock.updatePrice(List.of(50.0, 40.0, 30.0, 20.0, 10.0, 5.0, 2.0));
        System.out.println("===============================After Bear strategy===============================");
        System.out.println(gmStock);

        gmStock.setPricingStrategy(new BullPricingStrategy());
        gmStock.updatePrice(List.of(1.0, 2.0, 5.0, 10.0, 20.0, 30.0, 40.0));
        System.out.println("===============================After Bull strategy===============================");
        System.out.println(gmStock);

    }

}
