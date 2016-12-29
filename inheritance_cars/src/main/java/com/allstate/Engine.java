package com.allstate;

import java.math.BigDecimal;

abstract class Engine extends Component {
    private String displacement, compressionRatio;

    Engine(String manufacturer, String partNumber, String description, String displacement, String compressionRatio, BigDecimal price) {
        super(manufacturer, partNumber, description, price);
        this.displacement = displacement;
        this.compressionRatio = compressionRatio;
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
                ", displacement: " +
                displacement +
                ", compressionRatio: " +
                compressionRatio
                ;
    }

    @Override
    boolean coolingSystemComponent() {
        return false;
    }

    @Override
    boolean engineComponent() {
        return true;
    }

}
