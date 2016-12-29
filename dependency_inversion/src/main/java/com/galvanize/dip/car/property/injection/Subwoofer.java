package com.galvanize.dip.car.property.injection;

public class Subwoofer implements AudioSystem {

    @Override
    public void play() {
        System.out.println("Oomp, oomp, oomp, oomp, oomp, oomp...");
    }
}
