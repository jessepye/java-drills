package com.galvanize.dip.car.property.injection;

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

        App.main();

        assertThat(output.toString(), is(
                "Driving...\n" +
                "And now the weather. Today we have to expect a lot of rain...\n" +
                "Driving...\n" +
                "All you need is love, love. Love is all you need...\n" +
                "Driving...\n" +
                "Oomp, oomp, oomp, oomp, oomp, oomp...\n"));
    }
}
