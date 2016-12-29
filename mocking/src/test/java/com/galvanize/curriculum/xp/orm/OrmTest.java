package com.galvanize.curriculum.xp.orm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrmTest {

    @Test
    public void utilizesDriverToSaveObject() {
        MockDriver mockDriver = new MockDriver();
        Orm orm = new Orm(mockDriver);

        orm.save("A Test String");

        assertThat(mockDriver.saveCalls.size(), is(1));
        assertThat(mockDriver.saveCalls.get(0), is("A Test String"));

        orm.save(new int[] { 1, 2, 3});

        assertThat(mockDriver.saveCalls.size(), is(2));
        assertThat(mockDriver.saveCalls.get(1), is(new int[] { 1, 2, 3}));
    }

    @Test
    public void utilizesDriverToGetObject() {
        MockDriver mockDriver = new MockDriver();
        mockDriver.getWillReturn = "Fake Return Value";
        Orm orm = new Orm(mockDriver);

        Object retrievedValue = orm.get(42);

        assertThat(mockDriver.getCalls.size(), is(1));
        assertThat(mockDriver.getCalls.get(0), is(42));
        assertThat(retrievedValue, is("Fake Return Value"));

        Object anotherValue = orm.get(99);

        assertThat(mockDriver.getCalls.size(), is(2));
        assertThat(mockDriver.getCalls.get(1), is(99));
        assertThat(anotherValue, is("Fake Return Value"));
    }
}
