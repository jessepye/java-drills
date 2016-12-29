package com.galvanize.dip.car.method.injection;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class HandsFreeKitTest {

    @Test
    public void announcesIncomingCall() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Assistant assistant = new HandsFreeKit();
        assistant.connect(mock(Assistable.class));

        assistant.assist();

        assertThat(output.toString(), is("Incoming call...\n"));
    }

    @Test
    public void setAssistableVolumeToZero() {
        Assistant assistant = new HandsFreeKit();

        Assistable assistable = mock(Assistable.class);
        assistant.connect(assistable);

        assistant.assist();

        then(assistable).should().setVolume(0);
    }

    @Test
    public void addsItselfOnConnect() {
        Assistant assistant = new HandsFreeKit();
        Assistable assistable = mock(Assistable.class);

        assistant.connect(assistable);

        then(assistable).should().addAssistant(assistant);
    }
}
