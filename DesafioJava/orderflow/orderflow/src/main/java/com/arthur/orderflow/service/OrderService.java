
package com.arthur.orderflow.service;

import com.arthur.orderflow.model.Order;
import com.arthur.orderflow.repository.OrderRepository;
import com.arthur.orderflow.strategy.EconomyShipping;
import com.arthur.orderflow.strategy.ExpressShipping;
import com.arthur.orderflow.strategy.FreeShipping;
import com.arthur.orderflow.strategy.ShippingCalculator;
import com.arthur.orderflow.strategy.ShippingStrategy;
import com.arthur.orderflow.validation.OrderValidationChain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ShippingCalculator shippingCalculator;
    private final OrderValidationChain validationChain;

    public OrderService(
            OrderRepository orderRepository,
            ShippingCalculator shippingCalculator,
            OrderValidationChain validationChain) {
        this.orderRepository = orderRepository;
        this.shippingCalculator = shippingCalculator;
        this.validationChain = validationChain;
    }

    @Transactional
    public Order create(
            String customerName,
            BigDecimal total,
            String shippingType) {

        Order candidate = new Order(
                customerName,
                total,
                shippingType,
                BigDecimal.ZERO
        );

        validationChain.validate(candidate);

        ShippingStrategy strategy = switch (
                candidate.getShippingType().toUpperCase()) {
            case "ECONOMY" -> new EconomyShipping();
            case "EXPRESS" -> new ExpressShipping();
            case "FREE" -> new FreeShipping();
            default -> throw new IllegalArgumentException(
                    "Tipo de frete inválido.");
        };

        BigDecimal shippingCost =
                shippingCalculator.calculate(total, strategy);

        Order order = new Order(
                customerName,
                total,
                candidate.getShippingType().toUpperCase(),
                shippingCost
        );

        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
