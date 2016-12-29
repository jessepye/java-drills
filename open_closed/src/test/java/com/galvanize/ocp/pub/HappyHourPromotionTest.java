package com.galvanize.ocp.pub;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HappyHourPromotionTest {

    Promotion promotion = new HappyHourPromotion();

    @Test
    public void costsForOneDrink() {
        assertThat(promotion.getActualCosts(1.0, 1), is(0.5));
        assertThat(promotion.getActualCosts(3.4, 1), is(1.7));
    }

    @Test
    public void costsForMultipleDrink() {
        assertThat(promotion.getActualCosts(1.0, 3), is(1.5));
    }

    @Test
    public void costsForFreeDrink() {
        assertThat(promotion.getActualCosts(0.0, 1), is(0.0));
    }

    @Test
    public void costsForCancelledDrink() {
        assertThat(promotion.getActualCosts(1.0, 0), is(0.0));
    }

    @Test
    public void costsForFreeCancelledDrink() {
        assertThat(promotion.getActualCosts(0.0, 0), is(0.0));
    }
}
