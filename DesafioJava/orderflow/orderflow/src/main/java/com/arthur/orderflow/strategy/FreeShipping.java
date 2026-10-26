package com.arthur.orderflow.strategy;

import java.math.BigDecimal;

public class FreeShipping implements ShippingStrategy {

    @Override
    public BigDecimal calculate(BigDecimal orderTotal) {
        return BigDecimal.ZERO;
    }

}