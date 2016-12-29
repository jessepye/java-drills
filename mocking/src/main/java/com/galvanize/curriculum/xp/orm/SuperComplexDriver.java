package com.galvanize.curriculum.xp.orm;

import java.util.HashMap;
import java.util.Map;

public class SuperComplexDriver implements Driver {

    Map<Integer, Object> saved = new HashMap<>();

    public void save(Object obj) {
        System.out.println("Saving object: " + obj);
        for (int i = 0; i < 1000000; i++) {
            System.out.println("That's a super complex long running asynchronous operation. Don't use in unit tests!");
        }

        saved.put(obj.hashCode(), obj);
    }

    public Object get(int id) {
        System.out.println("Retrieving object with id: " + id);
        for (int i = 0; i < 1000000; i++) {
            System.out.println("That's a super complex long running asynchronous operation. Don't use in unit tests!");
        }

        return saved.get(id);
    }
}
