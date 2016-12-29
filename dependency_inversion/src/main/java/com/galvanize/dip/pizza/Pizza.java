package com.galvanize.dip.pizza;

import java.util.ArrayList;
import java.util.List;

abstract class Pizza {

    protected String name;
    protected String dough;
    protected String sauce;
    protected List<String> toppings = new ArrayList<>();
    protected String cheese;

    void prepare() {
        System.out.println("Preparing pizza: " + name);
        System.out.println("Tossing dough: " + dough);
        System.out.println("Adding sauce: " + sauce);
        toppings.forEach(topping -> System.out.println("Adding topping: " + topping));
        System.out.println("Adding cheese: " + cheese);
    }

    void back() {
        System.out.println("Baking for 25 minutes at 350");
    }

    void cut() {
        System.out.println("Cutting the pizza in diagonal slices");
    }

    void box() {
        System.out.println("Placing pizza in official PizzaStore box");
    }
}
