package com.galvanize.dip.car.method.injection;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class TurnByTurnNavigationTest {

    @Test
    public void announcesInstruction() {
        OutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        Assistant assistant = new TurnByTurnNavigation();
        assistant.connect(mock(Assistable.class));

        assistant.assist();

        assertThat(output.toString(), is("Turn left after 200 meters, then turn right...\n"));
    }

    @Test
    public void setAssistableVolumeToFifty() {
        Assistant assistant = new TurnByTurnNavigation();

        Assistable assistable = mock(Assistable.class);
        assistant.connect(assistable);

        assistant.assist();

        then(assistable).should().setVolume(50);
    }

    @Test
    public void addsItselfOnConnect() {
        Assistant assistant = new TurnByTurnNavigation();
        Assistable assistable = mock(Assistable.class);

        assistant.connect(assistable);

        then(assistable).should().addAssistant(assistant);
    }
}
