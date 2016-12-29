package com.galvanize.dip.phone;

class CloudStorage implements Storage {

    private final Connectable connectable;

    CloudStorage(Connectable connectable) {
        this.connectable = connectable;
    }

    public void save(String data) {
        if (connectable.hasConnection()) {
            System.out.println("Saving data to cloud: " + data);
        }
    }
}
