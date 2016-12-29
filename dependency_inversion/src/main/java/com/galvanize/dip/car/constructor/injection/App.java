package com.galvanize.dip.car.constructor.injection;

public class App {

    public static void main(String... args) {

        Car jeep = new Car(new DieselEngine());
        jeep.drive();

        Car ford = new Car(new PetrolEngine());
        ford.drive();

        Car tesla = new Car(new ElectricEngine());
        tesla.drive();
    }
}
