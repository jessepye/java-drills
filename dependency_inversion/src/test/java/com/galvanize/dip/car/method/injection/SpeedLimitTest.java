package com.galvanize.dip.car.method.injection;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class SpeedLimitTest {

    @Test
    public void announcesSpeedLimitViolation() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Assistant assistant = new SpeedLimit();
        assistant.connect(mock(Assistable.class));

        assistant.assist();

        assertThat(output.toString(), is("*BING* The current speed limit is 30 mph...\n"));
    }

    @Test
    public void setAssistableVolumeToTwenty() {
        Assistant assistant = new SpeedLimit();

        Assistable assistable = mock(Assistable.class);
        assistant.connect(assistable);

        assistant.assist();

        then(assistable).should().setVolume(20);
    }

    @Test
    public void addsItselfOnConnect() {
        Assistant assistant = new SpeedLimit();
        Assistable assistable = mock(Assistable.class);

        assistant.connect(assistable);

        then(assistable).should().addAssistant(assistant);
    }
}
