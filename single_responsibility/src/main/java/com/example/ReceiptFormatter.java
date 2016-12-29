package com.example;

import com.example.model.LineItem;
import com.example.model.RestaurantBill;

import java.math.BigDecimal;

public class ReceiptFormatter {

    public static String formatBill(RestaurantBill bill, BillCalculator calculator) {
        String output = "";

        for (LineItem item : bill.getListOfItems()) {
            output += item.getName() + "(" + item.getQuantity() + ") $" + item.getPrice().multiply(new BigDecimal(item.getQuantity())) + "\n";
        }

        BigDecimal tax = calculator.computeTotalWithTax(bill);
        BigDecimal tip = calculator.computeTotalWithTip(bill);
        BigDecimal total = calculator.computeTotalWithTaxAndTip(bill);

        output += "--------------------\n";
        output += "tax:          " + "$" + tax + "\n";
        output += "--------------------\n";
        output += "tip:          " + "$" + tip + "\n";
        output += "--------------------\n";
        output += "total:        " + "$" + total + "\n";
        return output;
    }

}
