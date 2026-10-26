package com.arthur.orderflow.strategy;

import java.math.BigDecimal;

public interface ShippingStrategy {
    BigDecimal calculate(BigDecimal orderTotal);
}
