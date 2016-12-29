package com.galvanize.dip.car.constructor.injection;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ElectricEngineTest {

    @Test
    public void drainsBatteryOnAcceleration() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Engine engine = new ElectricEngine();

        engine.accelerate();

        assertThat(output.toString(), is("Draining battery ...\n"));
    }
}
