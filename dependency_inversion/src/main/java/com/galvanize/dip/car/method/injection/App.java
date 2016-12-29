package com.galvanize.dip.car.method.injection;

public class App {

    public static void main(String[] args) {

        Car car = new Car();

        Assistant navigation = new TurnByTurnNavigation();
        navigation.connect(car);
        car.drive();

        Assistant handsFree = new HandsFreeKit();
        handsFree.connect(car);
        car.drive();

        Assistant speedLimit = new SpeedLimit();
        speedLimit.connect(car);
        car.drive();
    }
}
