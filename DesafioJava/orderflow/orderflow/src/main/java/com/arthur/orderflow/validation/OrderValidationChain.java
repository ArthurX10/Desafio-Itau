package com.arthur.orderflow.validation;

import com.arthur.orderflow.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderValidationChain {

    private final List<OrderValidator> validators;

    public OrderValidationChain(List<OrderValidator> validators){
        this.validators = validators;
    }

    public void validate(Order order){
        for(OrderValidator validator : validators){
            validator.validate(order);
        }
    }


}

