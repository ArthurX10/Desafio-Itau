
package com.arthur.orderflow.validation;

import com.arthur.orderflow.model.Order;
import org.springframework.stereotype.Component;

@Component
public class CustomerNameValidator implements OrderValidator {

    @Override
    public void validate(Order order) {
        if (order.getCustomerName() == null
                || order.getCustomerName().isBlank()) {
            throw new IllegalArgumentException(
                    "O nome do cliente é obrigatório.");
        }
    }
}
