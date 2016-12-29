package com.example;

import java.util.List;

public class ImmutableEmployeeList<T> {

    List<T> backingList;

    ImmutableEmployeeList(List<T> backingList) {
        this.backingList = backingList;
    }

    public int size() {
        return backingList.size();
    }

    public T get(int index) {
        return backingList.get(index);
    }

}
