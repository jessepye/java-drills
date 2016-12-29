package com.example;

import com.example.model.LineItem;
import com.example.model.RestaurantBill;

import java.math.BigDecimal;

public class BillCalculator {

    private final BigDecimal taxRate;
    private final BigDecimal tipRate;
    private final TipType tipType;

    public enum TipType {
        PRE_TAX, POST_TAX
    }

    public BillCalculator(BigDecimal taxRate, BigDecimal tipRate, TipType tipType) {
        this.taxRate = taxRate;
        this.tipRate = tipRate;
        this.tipType = tipType;
    }

    BigDecimal computeSubTotal(RestaurantBill bill) {
        BigDecimal total = new BigDecimal(0);
        for (LineItem item : bill.getListOfItems()) {
            total = total.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return total;
    }

    BigDecimal computeTax(RestaurantBill bill) {
        BigDecimal subTotal = computeSubTotal(bill);
        BigDecimal tax = subTotal.multiply(taxRate).setScale(2, BigDecimal.ROUND_HALF_UP);
        return tax;
    }

    BigDecimal computeTotalWithTax(RestaurantBill bill) {
        BigDecimal subTotal = computeSubTotal(bill);
        return subTotal.add(subTotal.multiply(taxRate));
    }

    BigDecimal computeTotalWithTip(RestaurantBill bill) {
        BigDecimal subTotal = computeSubTotal(bill);
        return subTotal.add(subTotal.multiply(tipRate));
    }

    BigDecimal computeTotalWithTaxAndTip(RestaurantBill bill) {
        BigDecimal subTotal = computeSubTotal(bill);
        BigDecimal tax = computeTax(bill);
        BigDecimal total = subTotal.add(tax);

        BigDecimal tip = new BigDecimal(0);
        if(TipType.PRE_TAX.equals(tipType)) {
            tip = subTotal.multiply(tipRate).setScale(2, BigDecimal.ROUND_HALF_UP);
        } else {
            tip = total.multiply(tipRate).setScale(2, BigDecimal.ROUND_HALF_UP);
        }
        total = total.add(tip);
        return total;
    }

}
