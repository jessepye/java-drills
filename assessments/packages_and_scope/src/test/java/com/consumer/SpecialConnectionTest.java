package com.consumer;

import com.database.driver.Connection;
import com.database.driver.ConnectionPool;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SpecialConnectionTest {
    @Test
    public void poolShouldNotLeak() throws Exception {
        int count;
        SpecialPool pool = new SpecialPool(5);
        try(Connection connection = pool.getConnection()) {
            count = connection.runQuery("select count(*) from users");
        }
        assertTrue("SpecialConnection does it's own thing", count == 10);
    }
}
