package com.database.driver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionPool {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectionPool.class);

    private final Stack<Connection> availableConnections = new Stack<>();
    private final Stack<Connection> leasedConnections = new Stack<>();

    public ConnectionPool(int count) {
        for(int i = 0; i < count; i++) {
            availableConnections.add(createConnection());
        }
        LOGGER.info("Created {} connections", count);
    }

    protected Connection createConnection() {
        return new Connection(this);
    }

    public final synchronized int getLeasedCount() {
        return leasedConnections.size();
    }

    synchronized final public Connection getConnection() {
        Connection connection = availableConnections.pop();
        if(connection == null) {
            throw new RuntimeException("Pool exhausted!");
        }
        LOGGER.info("Leased connection {}", connection.getId());
        leasedConnections.push(connection);
        return connection;
    }

    synchronized final void release(Connection connection) {
        if(!leasedConnections.contains(connection)) {
            throw new RuntimeException("Connection not leased!");
        }
        LOGGER.info("Returned connection {}", connection.getId());
        leasedConnections.remove(connection);
        availableConnections.add(connection);
    }
}
