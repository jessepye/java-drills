package com.galvanize;

import java.util.*;

public class CashRegister {

    private SortedMap<Integer, Integer> drawer = new TreeMap<Integer, Integer>() {
        {
            put(1, 20);
            put(5, 5);
            put(10, 5);
            put(20, 5);
            put(50, 5);
            put(100, 2);
        }
    };

    public CashRegister() {
    }

    public boolean canMakeChange(List<Transaction> transactions) {

        List<Integer> denoms = new ArrayList<>(drawer.keySet());
        denoms.sort(Integer::compare);

        Map<Integer, Integer> drawer = new TreeMap<>(this.drawer);
        for(Transaction transaction : transactions) {
            int tendered = transaction.getTenderedAmount();
            int fee = transaction.getFee();
            int change = tendered - fee;
            if(change < 0) {
                throw new RuntimeException("Insufficient payment!");
            }
            for(int i = denoms.size() - 1; i >= 0; i--) {
                int denomination = denoms.get(i);
                int desired = (int)Math.floor(change / denomination);
                int available = drawer.get(denomination);
                int dispensed = Math.min(desired, available);
                int remaining = available - dispensed;
                change -= dispensed * denomination;
                drawer.put(denomination, remaining);
            }
            if(change != 0) {
                return false;
            }
        }

        return true;
    }

    public int calcPaymentTotal(Transaction transaction) {
        int total = 0;

        if (transaction.getPayment() == null) {
            return total;
        }

        for (Map.Entry<Integer, Integer> entry : transaction.getPayment().entrySet()) {
            int denomination = entry.getKey();
            int qty = entry.getValue();
            drawer.put(denomination, drawer.get(denomination) + qty);
            total += denomination * qty;
        }

        return total;
    }

    public int calcChange(Transaction transaction) {
        int total = calcPaymentTotal(transaction);
        int change = total - transaction.getFee();

        return change;
    }

    public int calcDrawerTotal() {
        int total = 0;

        for(Map.Entry<Integer, Integer> entry : drawer.entrySet()) {
            int denom = entry.getKey();
            int qty = entry.getValue();
            total += denom * qty;
        }

        return total;
    }

    public void setDrawer(Map<Integer, Integer> drawer) {
        this.drawer = new TreeMap<>(drawer);
    }
}

