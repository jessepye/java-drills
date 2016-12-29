package com.example;

public class MutableEmployeeList extends ImmutableEmployeeList {
    SapAdapter adapter;

    MutableEmployeeList(SapAdapter adapter) {
        super(adapter.employees);
        this.adapter = adapter;
    }

    public void clear() {
        adapter.fireEveryone();
    }
}
