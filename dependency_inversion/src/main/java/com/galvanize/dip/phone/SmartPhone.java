package com.galvanize.dip.phone;

import static java.util.Arrays.asList;

class SmartPhone {

    private static final String CONNECTION = "3G";

    public static void main(String... args) {
        Storage flash = new FlashStorage();
        Storage cloud = new CloudStorage(new Receiver());
        SmartPhoneApp smartPhoneApp = new SmartPhoneApp(asList(flash, cloud));

        // ...
        // User types "Hello World!" into text field
        String textFieldContent = "Hello World!";
        // User touches save button
        // ...

        smartPhoneApp.handleSaveButtonTouched(textFieldContent);
    }

    static class Receiver implements Connectable {
        @Override
        public boolean hasConnection() {
            return CONNECTION != null;
        }
    }
}
