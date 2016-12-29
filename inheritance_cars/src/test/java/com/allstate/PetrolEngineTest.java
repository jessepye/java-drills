package com.allstate;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PetrolEngineTest {
    @Test
    public void constructorShouldSetKnownState() {
        PetrolEngine petrolEngine = new PetrolEngine(
                "Nissen Automotive",
                "17117507973",
                "The petrolEngine",
                "450",
                "10:1",
                new BigDecimal(1700)
        );
        assertEquals(
                "manufacturer: Nissen Automotive, partNumber: 17117507973, description: The petrolEngine, displacement: 450, compressionRatio: 10:1",
                petrolEngine.fullDescription()
        );
        assertFalse(petrolEngine.coolingSystemComponent());
        assertTrue(petrolEngine.engineComponent());
    }
}
