package com.allstate;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ComponentTest {
    @Test
    public void constructorShouldSetKnownState() {
        Component component = new Component(
                "Nissen Automotive",
                "17117507973",
                "The component",
                new BigDecimal(1700)
        ) {
            @Override
            boolean isExempt() {
                return false;
            }

            @Override
            boolean coolingSystemComponent() {
                return false;
            }

            @Override
            boolean engineComponent() {
                return false;
            }

            @Override
            String fullDescription() {
                return null;
            }
        };
        assertEquals(new BigDecimal("1870.00"), component.subTotal(new BigDecimal("0.10")));
    }

}
