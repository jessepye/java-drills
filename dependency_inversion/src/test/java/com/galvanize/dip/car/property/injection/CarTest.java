package com.galvanize.dip.car.property.injection;

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

        Car car = new Car();

        car.drive();

        assertThat(output.toString(), is("Driving...\n"));
    }

    @Test
    public void usesAudioSystemWhileDriving() {
        AudioSystem mockAudioSystem = mock(AudioSystem.class);

        Car car  = new Car();
        car.setAudioSystem(mockAudioSystem);

        car.drive();

        then(mockAudioSystem).should().play();
    }

    @Test
    public void usesDifferentAudioSystemAfterChangingIt() {
        AudioSystem mockAudioSystem1 = mock(AudioSystem.class);
        AudioSystem mockAudioSystem2 = mock(AudioSystem.class);

        Car car  = new Car();

        car.setAudioSystem(mockAudioSystem1);
        car.drive();

        then(mockAudioSystem1).should().play();
        then(mockAudioSystem2).shouldHaveZeroInteractions();

        car.setAudioSystem(mockAudioSystem2);
        car.drive();

        then(mockAudioSystem1).shouldHaveNoMoreInteractions();
        then(mockAudioSystem2).should().play();
    }
}
