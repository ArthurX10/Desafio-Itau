package com.arthur.orderflow.validation;

import com.arthur.orderflow.model.Order;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component 
public class OrderTotalValidator implements OrderValidator {

    @Override
    public void validate(Order order){
        if(order.getTotal() == null
        || order.getTotal().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException(
                "O valor total do pedido deve ser maior que zero.");
        }
    }
    
}
