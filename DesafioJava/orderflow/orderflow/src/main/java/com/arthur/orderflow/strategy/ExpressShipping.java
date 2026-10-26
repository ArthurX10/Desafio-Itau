package com.arthur.orderflow.strategy;

import java.math.BigDecimal;

public class ExpressShipping implements ShippingStrategy{

    @Override 
    public BigDecimal calculate(BigDecimal orderTotal){
        return orderTotal.multiply(new BigDecimal("0.10"));
    }
    
}
