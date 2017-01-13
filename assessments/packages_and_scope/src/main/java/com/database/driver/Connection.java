package com.database.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Connection implements AutoCloseable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class);
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

    private final int id;
    private ConnectionPool pool;

    protected Connection(ConnectionPool pool) {
        id = ID_GENERATOR.incrementAndGet();
        this.pool = pool;
    }

    public int getId() {
        return id;
    }

    public int runQuery(String sql) {
        LOGGER.info("Ran query: {}", sql);
        return 5;
    }

    @Override
    public final void close() throws Exception {
        pool.release(this);
    }
}
