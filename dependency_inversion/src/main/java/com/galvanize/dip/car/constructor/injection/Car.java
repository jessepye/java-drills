package com.galvanize.dip.car.constructor.injection;

import static java.util.Objects.requireNonNull;

public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = requireNonNull(engine);
    }

    public void drive() {
        System.out.println("Driving...");
        engine.accelerate();
    }
}
