package com.arthur.orderflow.Controller;

import com.arthur.orderflow.model.Order;
import com.arthur.orderflow.service.OrderService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController // retorna o objeto e os dados do objeto gravados na respota HTTP como JSON E XML
@RequestMapping("/api/orders") 
public class OrderController {
    
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    public record CreateOrderRequest(
        String customerName,
        BigDecimal total,
        String shippingType
    ){}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // indica que o status da resposta HTTP será 201 Created
    public Order create(@RequestBody CreateOrderRequest request){
        return orderService.create(
        request.customerName(),
        request.total(),
        request.shippingType()
    );
    }
    

    @GetMapping
    public List<Order> findAll(){
        return orderService.findAll();
    }
}
