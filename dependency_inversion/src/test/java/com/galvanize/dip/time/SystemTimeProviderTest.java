package com.galvanize.dip.time;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class SystemTimeProviderTest {

    @Test
    public void providesCurrentSystemTime() {
        TimeProvider timeProvider = new SystemTimeProvider();
        assertThat(timeProvider.getCurrentTimeInMinutes(), equalTo(System.currentTimeMillis() / 1000 / 60));
    }
}
