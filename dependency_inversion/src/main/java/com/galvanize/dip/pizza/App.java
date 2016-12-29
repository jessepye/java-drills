package com.galvanize.dip.pizza;

public class App {

    public static void main(String... args) {

        PizzaStore pizzaStore = new PizzaStore();

        pizzaStore.createPizza(Type.CHEESE);
        pizzaStore.createPizza(Type.CLAM);
        pizzaStore.createPizza(Type.PEPPERONI);
        pizzaStore.createPizza(Type.VEGGIE);
    }
}
