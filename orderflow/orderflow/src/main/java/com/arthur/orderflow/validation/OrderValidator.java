
package com.arthur.orderflow.validation;

import com.arthur.orderflow.model.Order;

public interface OrderValidator {

    void validate(Order order);
}
