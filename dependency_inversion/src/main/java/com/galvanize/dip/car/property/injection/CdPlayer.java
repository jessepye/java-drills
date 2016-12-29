package com.galvanize.dip.car.property.injection;

public class CdPlayer implements AudioSystem {

    @Override
    public void play() {
        System.out.println("All you need is love, love. Love is all you need...");
    }
}