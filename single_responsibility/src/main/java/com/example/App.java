package com.example;

import com.example.model.LineItem;
import com.example.model.RestaurantBill;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.example.BillCalculator.TipType.*;

public class App {
    public static void main(String[] args) {
        // example of usage:
        LineItem burger = new LineItem("Burger", 4, 2);
        LineItem macAndCheese = new LineItem("Mac and Cheese", 6, 1);
        LineItem sprite = new LineItem("Sprite", 1, 3);

        List<LineItem> foodItems = Arrays.asList(burger, macAndCheese, sprite);
        RestaurantBill bill = new RestaurantBill(foodItems);
        BillCalculator calculator = new BillCalculator(new BigDecimal("0.10"), new BigDecimal("0.18"), PRE_TAX);
        String result = ReceiptFormatter.formatBill(bill, calculator);
        System.out.println(result);
    }
}
