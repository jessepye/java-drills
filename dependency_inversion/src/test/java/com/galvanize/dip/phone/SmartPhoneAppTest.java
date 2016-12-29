package com.galvanize.dip.phone;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class SmartPhoneAppTest {

    @Test
    public void saveDataToOneStorage() {
        Storage mockStorage = mock(Storage.class);
        SmartPhoneApp app = new SmartPhoneApp(asList(mockStorage));

        app.handleSaveButtonTouched("Test Data");

        then(mockStorage).should().save("Test Data");

        app.handleSaveButtonTouched("More Data");

        then(mockStorage).should().save("More Data");
    }

    @Test
    public void saveDataToMultipleStorages() {
        Storage mockStorage1 = mock(Storage.class);
        Storage mockStorage2 = mock(Storage.class);
        SmartPhoneApp app = new SmartPhoneApp(asList(mockStorage1, mockStorage2));

        app.handleSaveButtonTouched("Test Data");

        then(mockStorage1).should().save("Test Data");
        then(mockStorage2).should().save("Test Data");
    }
}
