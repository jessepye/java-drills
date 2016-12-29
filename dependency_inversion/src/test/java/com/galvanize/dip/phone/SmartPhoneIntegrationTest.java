package com.galvanize.dip.phone;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SmartPhoneIntegrationTest {

    @Test
    public void savesTextFieldInputToCloudAndFlashStorage() {
        OutputStream savedData = new ByteArrayOutputStream();
        System.setOut(new PrintStream(savedData));

        SmartPhone.main();

        assertThat(savedData.toString(), is("Saving data to flash storage: Hello World!\nSaving data to cloud: Hello World!\n"));
    }
}
