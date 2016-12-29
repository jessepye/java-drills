package com.galvanize.dip.car.constructor.injection;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AppIntegrationTest {

    @Test
    public void drivesWithDifferentCars() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        App.main();

        assertThat(output.toString(), is("" +
                "Driving...\n" +
                "Burning diesel ...\n" +
                "Driving...\n" +
                "Burning petrol ...\n" +
                "Driving...\n" +
                "Draining battery ...\n"));
    }
}
