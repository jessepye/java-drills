package com.galvanize.dip.phone;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CloudStorageTest {

    OutputStream savedData;

    @Before
    public void setUp() {
        savedData = new ByteArrayOutputStream();
        System.setOut(new PrintStream(savedData));
    }

    @Test
    public void savesData() {
        Storage storage = new CloudStorage(() -> true);

        storage.save("Test Data");

        assertThat(savedData.toString(), is("Saving data to cloud: Test Data\n"));
    }

    @Test
    public void savesDifferentData() {
        Storage storage = new CloudStorage(() -> true);

        storage.save("More Data");

        assertThat(savedData.toString(), is("Saving data to cloud: More Data\n"));
    }

    @Test
    public void doesNotSaveDataIfNotConnected() {
        Storage storage = new CloudStorage(() -> false);

        storage.save("More Data");

        assertThat(savedData.toString(), is(""));
    }
}
