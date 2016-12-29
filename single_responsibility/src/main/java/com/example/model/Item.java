package com.example.model;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal price;

    public Item(String name, int price) {
        this(name, new BigDecimal(price));
    }

    public Item(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
