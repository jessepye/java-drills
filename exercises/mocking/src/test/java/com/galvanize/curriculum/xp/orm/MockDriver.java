package com.galvanize.curriculum.xp.orm;

import com.galvanize.curriculum.xp.orm.Driver;

import java.util.ArrayList;
import java.util.List;

class MockDriver implements Driver {

    List<Object> saveCalls = new ArrayList<>();
    public void save(Object obj) {
        saveCalls.add(obj);
    }

    List<Integer> getCalls = new ArrayList<>();
    Object getWillReturn = null;
    public Object get(int id) {
        getCalls.add(id);
        return getWillReturn;
    }
}
