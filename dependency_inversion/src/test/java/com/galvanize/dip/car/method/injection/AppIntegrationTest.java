package com.galvanize.dip.car.method.injection;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppIntegrationTest {

    @Test
    public void drivesWithDifferentAssistants() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        App.main(new String[] {});

        assertThat(output.toString(), is(
                "Driving...\n" +
                "Setting volume to 50%...\n" +
                "Turn left after 200 meters, then turn right...\n" +
                "Driving...\n" +
                "Setting volume to 50%...\n" +
                "Turn left after 200 meters, then turn right...\n" +
                "Setting volume to 0%...\n" +
                "Incoming call...\n" +
                "Driving...\n" +
                "Setting volume to 50%...\n" +
                "Turn left after 200 meters, then turn right...\n" +
                "Setting volume to 0%...\n" +
                "Incoming call...\n" +
                "Setting volume to 20%...\n" +
                "*BING* The current speed limit is 30 mph...\n"));
    }
}
