package com.galvanize.ocp.pub;

public class ThreeForTwoPromotion implements Promotion {

    @Override
    public double getActualCosts(double price, int quantity) {
        int freeDrinks = quantity / 3;
        return (quantity - freeDrinks) * price;
    }
}
