package com.galvanize.dip.car.property.injection;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SubwooferTest {

    @Test
    public void plays() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        AudioSystem audioSystem = new Subwoofer();

        audioSystem.play();

        assertThat(output.toString(), is("Oomp, oomp, oomp, oomp, oomp, oomp...\n"));
    }
}
