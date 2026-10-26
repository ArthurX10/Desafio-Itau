package com.arthur.orderflow.strategy;

import java.math.BigDecimal;


public class EconomyShipping implements ShippingStrategy {
    
    @Override
    public BigDecimal calculate(BigDecimal ordertotal){
        return ordertotal.multiply(new BigDecimal("0.05"));
    }
}
