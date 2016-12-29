package com.galvanize.dip.car.method.injection;

public class TurnByTurnNavigation extends Assistant {

    @Override
    public void assist() {
        assistable.setVolume(50);
        System.out.println("Turn left after 200 meters, then turn right...");
    }
}
