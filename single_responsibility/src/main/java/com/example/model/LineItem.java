package com.example.model;

import com.example.model.Item;

import java.math.BigDecimal;

public class LineItem {
    private Item item;
    private int quantity;

    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public LineItem(String name, int price, int quantity) {
        this.item = new Item(name, price);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return item.getName();
    }

    public BigDecimal getPrice() {
        return item.getPrice();
    }

}
