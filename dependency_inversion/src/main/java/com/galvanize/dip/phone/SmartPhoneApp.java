package com.galvanize.dip.phone;

import java.util.List;

class SmartPhoneApp {

    private List<Storage> storages;

    SmartPhoneApp(List<Storage> storages) {
        this.storages = storages;
    }

    void handleSaveButtonTouched(String textFieldContent) {
        storages.forEach(storage -> storage.save(textFieldContent));
    }
}
