package com.galvanize.dip.car.method.injection;

import java.util.ArrayList;
import java.util.List;

public class Car implements Assistable {

    private List<Assistant> assistants = new ArrayList<>();

    public void drive() {
        System.out.println("Driving...");
        assistants.forEach(Assistant::assist);
    }

    @Override
    public void addAssistant(Assistant assistant) {
        assistants.add(assistant);
    }

    @Override
    public void setVolume(int percent) {
        System.out.println("Setting volume to " + percent + "%...");
    }
}
