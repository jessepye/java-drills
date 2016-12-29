package com.galvanize;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class RadiatorTest {
    @Test
    public void constructorShouldSetKnownState() {
        Radiator radiator = new Radiator(
                "Nissen Automotive",
                "17117507972",
                "The full-aluminum radiators from Nissens are produced on the basis of the latest and most advanced technologies, including fully automatic manufacturing and assembly lines",
                "250 Pa",
                new BigDecimal(500)
        );
        assertEquals(
                "manufacturer: Nissen Automotive, " +
                        "partNumber: 17117507972, " +
                        "description: The full-aluminum radiators from Nissens are produced on the basis of the latest and most advanced technologies, " +
                        "including fully automatic manufacturing and assembly lines, " +
                        "coolantPressure: 250 Pa",
                radiator.fullDescription()
        );
        assertTrue(radiator.coolingSystemComponent());
        assertFalse(radiator.engineComponent());
    }
}
