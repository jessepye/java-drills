package com.galvanize.dip.car.property.injection;

public class Car {

    private AudioSystem audioSystem;

    public void drive() {
        System.out.println("Driving...");
        if (audioSystem != null) {
            audioSystem.play();
        }
    }

    public void setAudioSystem(AudioSystem audioSystem) {
        this.audioSystem = audioSystem;
    }
}
