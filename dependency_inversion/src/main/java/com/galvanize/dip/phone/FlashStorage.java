package com.galvanize.dip.phone;

class FlashStorage implements Storage {

    public void save(String data) {
        System.out.println("Saving data to flash storage: " + data);
    }
}
