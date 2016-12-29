package com.example;

import com.example.model.LineItem;
import com.example.model.RestaurantBill;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.example.BillCalculator.TipType.*;

public class BillCalculatorTest {

    @Test
    public void testTax() {
        // Setup
        BigDecimal expected = new BigDecimal("18.70");
        RestaurantBill bill = createBill();
        BillCalculator calculator = new BillCalculator(new BigDecimal("0.10"), new BigDecimal("0.18"), PRE_TAX);

        // Exercise
        BigDecimal actual = calculator.computeTotalWithTax(bill);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testTip() {
        // Setup
        BigDecimal expected = new BigDecimal("20.06");
        RestaurantBill bill = createBill();
        BillCalculator calculator = new BillCalculator(new BigDecimal("0.10"), new BigDecimal("0.18"), PRE_TAX);

        // Exercise
        BigDecimal actual = calculator.computeTotalWithTip(bill);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPreTaxTotal() {
        // Setup
        BigDecimal expected = new BigDecimal("21.76");
        RestaurantBill bill = createBill();
        BillCalculator calculator = new BillCalculator(new BigDecimal("0.10"), new BigDecimal("0.18"), PRE_TAX);

        // Exercise
        BigDecimal actual = calculator.computeTotalWithTaxAndTip(bill);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPostTaxTotal() {
        // Setup
        BigDecimal expected = new BigDecimal("22.07");
        RestaurantBill bill = createBill();
        BillCalculator calculator = new BillCalculator(new BigDecimal("0.10"), new BigDecimal("0.18"), POST_TAX);

        // Exercise
        BigDecimal actual = calculator.computeTotalWithTaxAndTip(bill);

        // Assert
        Assert.assertEquals(expected, actual);
    }

    private RestaurantBill createBill() {
        LineItem burger = new LineItem("Burger", 4, 2);
        LineItem macAndCheese = new LineItem("Mac and Cheese", 6, 1);
        LineItem sprite = new LineItem("Sprite", 1, 3);
        List<LineItem> foodItems = Arrays.asList(burger, macAndCheese, sprite);
        RestaurantBill bill = new RestaurantBill(foodItems);
        return bill;
    }
}
