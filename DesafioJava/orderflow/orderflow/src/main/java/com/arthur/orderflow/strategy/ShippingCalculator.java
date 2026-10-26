
package com.arthur.orderflow.strategy;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class ShippingCalculator {

    public BigDecimal calculate(
            BigDecimal orderTotal,
            ShippingStrategy strategy) {

        return strategy.calculate(orderTotal);
    }
}
