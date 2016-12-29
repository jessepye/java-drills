package com.galvanize.dip.car.constructor.injection;

public class ElectricEngine implements Engine {

    @Override
    public void accelerate() {
        System.out.println("Draining battery ...");
    }
}
