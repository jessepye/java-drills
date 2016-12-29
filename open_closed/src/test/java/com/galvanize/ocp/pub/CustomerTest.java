package com.galvanize.ocp.pub;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CustomerTest {

    @Test
    public void orderNoDrinks() {
        Customer customer = new Customer();
        assertThat(customer.getTotalDue(), is(0.0));
    }

    @Test
    public void orderOneDrink() {
        Customer customer = new Customer();
        customer.setPromotion(new NoPromotion());
        customer.orderDrinks(1.0, 1);
        assertThat(customer.getTotalDue(), is(1.0));
    }

    @Test
    public void ordersMultipleTimes() {
        Customer customer = new Customer();
        customer.orderDrinks(1.0, 1);
        customer.orderDrinks(1.0, 1);
        assertThat(customer.getTotalDue(), is(2.0));
    }

    @Test
    public void orderOneDrinkDuringHappyHour() {
        Customer customer = new Customer();
        customer.setPromotion(new HappyHourPromotion());
        customer.orderDrinks(1.0, 1);
        assertThat(customer.getTotalDue(), is(0.5));
    }

    @Test
    public void ordersWithQuantityZero() {
        Customer customer = new Customer();
        customer.orderDrinks(1.0, 0);
        assertThat(customer.getTotalDue(), is(0.0));
    }

    @Test
    public void ordersMultipleRoundsDuringHappyHour() {
        Customer customer = new Customer();
        customer.setPromotion(new HappyHourPromotion());
        customer.orderDrinks(1.0, 1);
        customer.orderDrinks(1.0, 1);
        assertThat(customer.getTotalDue(), is(1.0));
    }

    @Test
    public void ordersWithoutPrice() {
        Customer customer = new Customer();
        customer.orderDrinks(0.0, 1);
        assertThat(customer.getTotalDue(), is(0.0));
    }

    @Test
    public void orderWithoutPriceDuringHappyHour() {
        Customer customer = new Customer();
        customer.setPromotion(new HappyHourPromotion());
        customer.orderDrinks(0.0, 1);
        assertThat(customer.getTotalDue(), is(0.0));
    }

    @Test
    public void orderMultipleDrinks() {
        Customer customer = new Customer();
        customer.orderDrinks(1.0, 3);
        assertThat(customer.getTotalDue(), is(3.0));
    }

    @Test
    public void orderExpensiveDrink() {
        Customer customer = new Customer();
        customer.orderDrinks(3.3, 1);
        assertThat(customer.getTotalDue(), is(3.3));
    }

    @Test
    public void orderDrinksBeforeAndDuringHappyHour() {
        Customer customer = new Customer();
        customer.orderDrinks(1.0, 1);
        customer.setPromotion(new HappyHourPromotion());
        customer.orderDrinks(1.0, 1);
        assertThat(customer.getTotalDue(), is(1.5));
    }

    @Test
    public void orderDrinksWithThreeForTwoPromotion() {
        Customer customer = new Customer();
        customer.orderDrinks(1.0, 1);
        customer.setPromotion(new ThreeForTwoPromotion());
        customer.orderDrinks(1.0, 3);
        assertThat(customer.getTotalDue(), is(1.0 * 1 + 1.0 * 2));
    }

    @Test
    public void christmasParty() {
        Customer customer = new Customer();
        customer.orderDrinks(6.5, 2);
        customer.setPromotion(new ThreeForTwoPromotion());
        customer.orderDrinks(1.5, 4);
        customer.setPromotion(new HappyHourPromotion());
        customer.orderDrinks(4.5, 3);
        customer.orderDrinks(10.0, 2);
        assertThat(customer.getTotalDue(), is(6.5 * 2 +
                (1.5 * 3) +
                (4.5 * 3 / 2) +
                (10.0 * 2 / 2)));
    }
}
