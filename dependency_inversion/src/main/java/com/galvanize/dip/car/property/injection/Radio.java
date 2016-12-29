package com.galvanize.dip.car.property.injection;

public class Radio implements AudioSystem {

    @Override
    public void play() {
        System.out.println("And now the weather. Today we have to expect a lot of rain...");
    }
}
