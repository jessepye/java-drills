package com.galvanize.ocp.pub;

public class HappyHourPromotion implements Promotion {

    @Override
    public double getActualCosts(double price, int quantity) {
        return price * quantity / 2.0;
    }
}
