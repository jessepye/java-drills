package com.galvanize.dip.car.method.injection;

public class SpeedLimit extends Assistant {

    @Override
    public void assist() {
        assistable.setVolume(20);
        System.out.println("*BING* The current speed limit is 30 mph...");
    }
}
