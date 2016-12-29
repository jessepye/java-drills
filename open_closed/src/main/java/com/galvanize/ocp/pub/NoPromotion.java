package com.galvanize.ocp.pub;

public class NoPromotion implements Promotion {

    @Override
    public double getActualCosts(double price, int quantity) {
        return price * quantity;
    }
}
