package com.galvanize.dip.car.property.injection;

public class App {

    public static void main(String... args) {

        Car car = new Car();
        car.setAudioSystem(new Radio());
        car.drive();

        car.setAudioSystem(new CdPlayer());
        car.drive();

        car.setAudioSystem(new Subwoofer());
        car.drive();
    }
}
