package com.consumer;

import com.database.driver.Connection;
import com.database.driver.ConnectionPool;

public class SpecialPool extends ConnectionPool {

    public SpecialPool(int count) {
        super(count);
    }

    @Override
    protected Connection createConnection() {
        return new SpecialConnection(this);
    }

}
