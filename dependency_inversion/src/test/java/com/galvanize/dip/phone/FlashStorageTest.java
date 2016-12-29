package com.galvanize.dip.phone;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FlashStorageTest {

    OutputStream savedData;

    @Before
    public void setUp() {
        savedData = new ByteArrayOutputStream();
        System.setOut(new PrintStream(savedData));
    }

    @Test
    public void savesData() {
        Storage storage = new FlashStorage();

        storage.save("Test Data");

        assertThat(savedData.toString(), is("Saving data to flash storage: Test Data\n"));
    }

    @Test
    public void savesDifferentData() {
        Storage storage = new FlashStorage();

        storage.save("More Data");

        assertThat(savedData.toString(), is("Saving data to flash storage: More Data\n"));
    }
}
