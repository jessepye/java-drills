package com.galvanize.dip.car.constructor.injection;

public class DieselEngine implements Engine {

    @Override
    public void accelerate() {
        System.out.println("Burning diesel ...");
    }
}
