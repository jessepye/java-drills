import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class CashRegisterTest {
    @Test
    public void calcPaymentTotal() {

        // Setup
        int expected1 = 30;
        int expected2 = 40;
        CashRegister cashRegister = new CashRegister();
        Transaction transaction1 = new Transaction(2, new TreeMap<Integer, Integer>() {
            {
                put(5, 4);
                put(10, 1);
            }
        });
        Transaction transaction2 = new Transaction(2, new TreeMap<Integer, Integer>() {
            {
                put(20, 2);
            }
        });

        // Exercise
        int actual1 = cashRegister.calcPaymentTotal(transaction1);
        int actual2 = cashRegister.calcPaymentTotal(transaction2);

        // Assert
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);

        // Teardown
    }

    @Test
    public void calcChange() {

        // Setup
        int expected1 = 10;
        int expected2 = 5;
        CashRegister cashRegister = new CashRegister();
        Transaction transaction1 = new Transaction(2, new HashMap<Integer, Integer>() {
            {
                put(20, 2);
            }
        });
        Transaction transaction2 = new Transaction(3, new HashMap<Integer, Integer>() {
            {
                put(50, 1);
            }
        });

        // Exercise
        int actual1 = cashRegister.calcChange(transaction1);
        int actual2 = cashRegister.calcChange(transaction2);

        // Assert
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);

        // Teardown
    }

    @Test
    public void calcDrawerTotal() {
        int expected1 = 10;
        int expected2 = 50;

        CashRegister cashRegister = new CashRegister();
        cashRegister.setDrawer(new HashMap<Integer, Integer>() {
            {
                put(1, 10);
                put(5, 0);
                put(10, 0);
                put(20, 0);
                put(50, 0);
                put(100, 0);
            }
        });
        int actual1 = cashRegister.calcDrawerTotal();
        Assert.assertEquals(expected1, actual1);

        cashRegister.setDrawer(new HashMap<Integer, Integer>() {
            {
                put(1, 10);
                put(5, 0);
                put(10, 0);
                put(20, 2);
                put(50, 0);
                put(100, 0);
            }
        });
        int actual2 = cashRegister.calcDrawerTotal();
        Assert.assertEquals(expected2, actual2);
    }

    @Test
    public void cantMakeChange() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.setDrawer(new HashMap<Integer, Integer>() {
            {
                put(1, 10);
                put(5, 0);
                put(10, 0);
                put(20, 2);
                put(50, 0);
                put(100, 0);
            }
        });
        Transaction trans = new Transaction(5, new HashMap<Integer, Integer>() {
            {
                put(100, 1);
            }
        });
        boolean actual = cashRegister.canMakeChange(Arrays.asList(trans));
        Assert.assertTrue("can determine if change can be made from payment", actual);
    }

    @Test
    public void canMakeChange() {
        CashRegister cashRegister = new CashRegister();
        cashRegister.setDrawer(new HashMap<Integer, Integer>() {
            {
                put(1, 10);
                put(5, 0);
                put(10, 0);
                put(20, 2);
                put(50, 0);
                put(100, 0);
            }
        });
        Transaction trans = new Transaction(5, new HashMap<Integer, Integer>() {
            {
                put(100, 1);
            }
        });
        boolean actual = cashRegister.canMakeChange(Arrays.asList(trans));
        Assert.assertTrue("can determine if change can be made from payment", actual);
    }
}
