
package com.arthur.orderflow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.arthur.orderflow.strategy.EconomyShipping;
import com.arthur.orderflow.strategy.ExpressShipping;
import com.arthur.orderflow.strategy.FreeShipping;
import com.arthur.orderflow.strategy.ShippingCalculator;

class ShippingCalculatorTest {

    private final ShippingCalculator calculator =
            new ShippingCalculator();

    @Test
    void shouldCalculateEconomyShipping() {
        BigDecimal result = calculator.calculate(
                new BigDecimal("200.00"),
                new EconomyShipping()
        );

        assertEquals(0, result.compareTo(new BigDecimal("10.00")));
    }

    @Test
    void shouldCalculateExpressShipping() {
        BigDecimal result = calculator.calculate(
                new BigDecimal("200.00"),
                new ExpressShipping()
        );

        assertEquals(0, result.compareTo(new BigDecimal("20.00")));
    }

    @Test
    void shouldCalculateFreeShipping() {
        BigDecimal result = calculator.calculate(
                new BigDecimal("200.00"),
                new FreeShipping()
        );

        assertEquals(0, result.compareTo(BigDecimal.ZERO));
    }
}
