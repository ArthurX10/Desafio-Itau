
package com.arthur.orderflow.validation;

import com.arthur.orderflow.model.Order;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ShippingTypeValidator implements OrderValidator {

    private static final Set<String> VALID_SHIPPING_TYPES =
            Set.of("ECONOMY", "EXPRESS", "FREE");

    @Override
    public void validate(Order order) {
        String shippingType = order.getShippingType();

        if (shippingType == null
                || !VALID_SHIPPING_TYPES.contains(
                        shippingType.toUpperCase())) {
            throw new IllegalArgumentException(
                    "Tipo de frete inválido. Use ECONOMY, EXPRESS ou FREE.");
        }
    }
}
