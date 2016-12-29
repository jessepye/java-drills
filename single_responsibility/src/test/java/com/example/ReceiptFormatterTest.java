package com.example;

import com.example.model.LineItem;
import com.example.model.RestaurantBill;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.example.BillCalculator.TipType.*;

public class ReceiptFormatterTest {
    @Test
    public void testFormat() {
        // Setup
        String expected = "Burger(2) $8\n" +
                "Mac and Cheese(1) $6\n" +
                "Sprite(3) $3\n" +
                "--------------------\n" +
                "tax:          $18.70\n" +
                "--------------------\n" +
                "tip:          $20.06\n" +
                "--------------------\n" +
                "total:        $21.76\n";
        LineItem burger = new LineItem("Burger", 4, 2);
        LineItem macAndCheese = new LineItem("Mac and Cheese", 6, 1);
        LineItem sprite = new LineItem("Sprite", 1, 3);
        List<LineItem> foodItems = Arrays.asList(burger, macAndCheese, sprite);
        RestaurantBill bill = new RestaurantBill(foodItems);
        BillCalculator calculator = new BillCalculator(new BigDecimal("0.10"), new BigDecimal("0.18"), PRE_TAX);

        // Exercise
        String actual = ReceiptFormatter.formatBill(bill, calculator);

        // Assert
        Assert.assertEquals(expected, actual);
    }
}
