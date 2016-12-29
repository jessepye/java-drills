package com.galvanize.ocp.pub;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ThreeForTwoPromotionTest {

    Promotion promotion = new ThreeForTwoPromotion();

    @Test
    public void costsForOneDrink() {
        assertThat(promotion.getActualCosts(1.0, 1), is(1.0));
        assertThat(promotion.getActualCosts(4.0, 1), is(4.0));
    }

    @Test
    public void costsForMultipleDrinks() {
        assertThat(promotion.getActualCosts(1.0, 2), is(2.0));
    }

    @Test
    public void costsForCancelledDrink() {
        assertThat(promotion.getActualCosts(1.0, 0), is(0.0));
    }

    @Test
    public void costsForFreeCancelledDrink() {
        assertThat(promotion.getActualCosts(0.0, 0), is(0.0));
    }

    @Test
    public void costsForFreeDrink() {
        assertThat(promotion.getActualCosts(0.0, 1), is(0.0));
    }

    @Test
    public void costsForThreeDrinks() {
        assertThat(promotion.getActualCosts(1.0, 3), is(2.0));
    }

    @Test
    public void costsForMultiplesOfThreeDrinks() {
        assertThat(promotion.getActualCosts(1.0, 6), is(4.0));
    }

    @Test
    public void costsForMultipleDrinksGreaterThanThree() {
        assertThat(promotion.getActualCosts(1.0, 4), is(3.0));
        assertThat(promotion.getActualCosts(1.0, 10), is(7.0));
    }
}
