package com.galvanize;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Transaction {
    private int ticketPrice = 15;
    private int quantity;
    private Map<Integer, Integer> payment;

    public Transaction(int quantity, Map<Integer, Integer> payment) {
        this.quantity = quantity > 0 ? quantity : 1;
        this.payment = new HashMap<>(payment);
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Map<Integer, Integer> getPayment() {
        return Collections.unmodifiableMap(payment);
    }

    public int getFee() {
        return ticketPrice * quantity;
    }

    public int getTenderedAmount() {
        int tendered = 0;
        for(Map.Entry<Integer,Integer> entry : payment.entrySet()) {
            tendered += entry.getKey() * entry.getValue();
        }
        return tendered;
    }
}

