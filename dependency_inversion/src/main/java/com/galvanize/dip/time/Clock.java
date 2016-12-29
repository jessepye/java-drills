package com.galvanize.dip.time;

class Clock {

    private TimeProvider timeProvider;

    Clock(TimeProvider timeProvider) {

        this.timeProvider = timeProvider;
    }

    String tellTime() {
        long timeInMinutes = timeProvider.getCurrentTimeInMinutes() % (24 * 60);
        return String.format("%02d:%02d", timeInMinutes / 60, timeInMinutes % 60);
    }
}
