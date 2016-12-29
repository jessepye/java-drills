package com.allstate;

import java.math.BigDecimal;

abstract class Component {

    String manufacturer, partNumber, description;
    BigDecimal price;

    Component(String manufacturer, String partNumber, String description, BigDecimal price) {
        this.manufacturer = manufacturer;
        this.partNumber = partNumber;
        this.description = description;
        this.price = price;
    }

    BigDecimal subTotal(BigDecimal taxRate) {
        return isExempt() ? price : price.add(price.multiply(taxRate));
    }

    abstract boolean isExempt();

    abstract boolean coolingSystemComponent();

    abstract boolean engineComponent();

    abstract String fullDescription();


}
