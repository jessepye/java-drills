package com.galvanize.dip.car.method.injection;

public class HandsFreeKit extends Assistant {

    @Override
    public void assist() {
        assistable.setVolume(0);
        System.out.println("Incoming call...");
    }
}
