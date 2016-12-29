package com.galvanize.dip.time;

public class SystemTimeProvider implements TimeProvider {

    @Override
    public long getCurrentTimeInMinutes() {
        return System.currentTimeMillis() / 1000 / 60;
    }
}
