package com.galvanize;

import java.math.BigDecimal;

class PetrolEngine extends Engine {

    PetrolEngine(String manufacturer, String partNumber, String description, String displacement, String compressionRatio, BigDecimal price) {
        super(manufacturer, partNumber, description, displacement, compressionRatio, price);
    }

}
