package com.galvanize;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class DieselEngineTest {
    @Test
    public void constructorShouldSetKnownState() {
        DieselEngine dieselEngine = new DieselEngine(
                "Nissen Automotive",
                "17117507973",
                "The dieselEngine",
                "450",
                "10:1",
                new BigDecimal(1500)
        );
        assertEquals(
                "manufacturer: Nissen Automotive, partNumber: 17117507973, description: The dieselEngine, displacement: 450, compressionRatio: 10:1",
                dieselEngine.fullDescription()
        );
        assertFalse(dieselEngine.coolingSystemComponent());
        assertTrue(dieselEngine.engineComponent());
    }
}
