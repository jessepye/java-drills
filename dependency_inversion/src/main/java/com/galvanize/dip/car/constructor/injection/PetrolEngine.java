package com.galvanize.dip.car.constructor.injection;

public class PetrolEngine implements Engine {

    @Override
    public void accelerate() {
        System.out.println("Burning petrol ...");
    }
}
