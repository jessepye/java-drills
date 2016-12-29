package com.galvanize.dip.time;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClockTest {

    @Test
    public void tellsTime() {
        FixedTimeProvider timeProvider = new FixedTimeProvider();
        Clock clock = new Clock(timeProvider);

        timeProvider.fixedTimeInMinutes = 0;
        assertThat(clock.tellTime(), is("00:00"));

        timeProvider.fixedTimeInMinutes = 1;
        assertThat(clock.tellTime(), is("00:01"));

        timeProvider.fixedTimeInMinutes = 12 * 60;
        assertThat(clock.tellTime(), is("12:00"));

        timeProvider.fixedTimeInMinutes = 13 * 60 + 46;
        assertThat(clock.tellTime(), is("13:46"));
    }

    public class FixedTimeProvider implements TimeProvider {

        public long fixedTimeInMinutes;

        @Override
        public long getCurrentTimeInMinutes() {
            return fixedTimeInMinutes;
        }
    }
}
