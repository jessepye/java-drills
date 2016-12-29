package com.allstate;

import java.math.BigDecimal;

class Radiator extends Component {
    private String coolantPressure;

    Radiator(String manufacturer, String partNumber, String description, String coolantPressure, BigDecimal price) {
        super(manufacturer, partNumber, description, price);
        this.coolantPressure = coolantPressure;
    }

    @Override
    boolean isExempt() {
        return true;
    }

    @Override
    String fullDescription() {

        return "manufacturer: " +
                manufacturer +
                ", partNumber: " +
                partNumber +
                ", description: " +
                description +
                ", coolantPressure: " +
                coolantPressure;
    }

    @Override
    boolean coolingSystemComponent() {
        return true;
    }

    @Override
    boolean engineComponent() {
        return false;
    }
}
