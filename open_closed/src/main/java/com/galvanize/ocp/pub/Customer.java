package com.galvanize.ocp.pub;

import java.util.ArrayList;
import java.util.List;

class Customer {

	private List<Double> drinks = new ArrayList<>();
	private Promotion promotion = new NoPromotion();

	void orderDrinks(final double price, final int quantity) {

		drinks.add(promotion.getActualCosts(price, quantity));
	}

	double getTotalDue() {
		return drinks.stream().mapToDouble(Double::doubleValue).sum();
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
}
