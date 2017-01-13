package com.consumer;

import com.database.driver.Connection;
import com.database.driver.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpecialConnection extends Connection {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class);

    SpecialConnection(ConnectionPool pool) {
        super(pool);
    }

    public int runQuery(String sql) {
        LOGGER.info("Ran query: {}", sql);
        return 10;
    }

}
