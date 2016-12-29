package com.example.model;

import com.example.model.LineItem;

import java.util.Collections;
import java.util.List;

public class RestaurantBill {
    private List<LineItem> listOfItems;

    public RestaurantBill(List<LineItem> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public List<LineItem> getListOfItems() {
        return Collections.unmodifiableList(listOfItems);
    }
}
