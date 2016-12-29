package com.galvanize.ocp.pub;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class NoPromotionTest {

    Promotion promotion = new NoPromotion();

    @Test
    public void costsForOneDrink() {
        assertThat(promotion.getActualCosts(1.0, 1), is(1.0));
        assertThat(promotion.getActualCosts(2.3, 1), is(2.3));
    }

    @Test
    public void costsForMultipleDrinks() {
        assertThat(promotion.getActualCosts(1.0, 3), is(3.0));
    }

    @Test
    public void costsForFreeDrink() {
        assertThat(promotion.getActualCosts(0.0, 1), is(0.0));
    }

    @Test
    public void costsForCancelledOrder() {
        assertThat(promotion.getActualCosts(1.0, 0), is(0.0));
    }

    @Test
    public void costsForCancelledFreeDrink() {
        assertThat(promotion.getActualCosts(0.0, 0), is(0.0));
    }
}
