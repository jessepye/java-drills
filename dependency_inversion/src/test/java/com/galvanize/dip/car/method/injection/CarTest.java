package com.galvanize.dip.car.method.injection;

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
    public void setsVolume() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Car car = new Car();

        car.setVolume(75);

        assertThat(output.toString(), is("Setting volume to 75%...\n"));
    }

    @Test
    public void drives() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Car car = new Car();

        car.drive();

        assertThat(output.toString(), is("Driving...\n"));
    }

    @Test
    public void usesAddedAssistant() {
        Assistant mockAssistant = mock(Assistant.class);

        Car car = new Car();
        car.addAssistant(mockAssistant);

        car.drive();

        then(mockAssistant).should().assist();
    }

    @Test
    public void usesMultipleAddedAssistants() {
        Assistant mockAssistant1 = mock(Assistant.class);
        Assistant mockAssistant2 = mock(Assistant.class);

        Car car = new Car();
        car.addAssistant(mockAssistant1);
        car.addAssistant(mockAssistant2);

        car.drive();

        then(mockAssistant1).should().assist();
        then(mockAssistant2).should().assist();
    }
}
