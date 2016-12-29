package com.galvanize.dip.time;

public class App {

    public static void main(String[] args) {
        Clock clock = new Clock(new SystemTimeProvider());
        System.out.println(clock.tellTime());
    }
}
