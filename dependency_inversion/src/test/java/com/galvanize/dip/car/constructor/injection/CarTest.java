package com.galvanize.dip.car.constructor.injection;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class CarTest {

    @Test
    public void drives() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Car car = new Car(() -> {});

        car.drive();

        assertThat(output.toString(), is("Driving...\n"));
    }

    @Test
    public void acceleratesEngine() {
        Engine mockEngine = mock(Engine.class);
        Car car = new Car(mockEngine);

        car.drive();

        then(mockEngine).should().accelerate();
    }
}
