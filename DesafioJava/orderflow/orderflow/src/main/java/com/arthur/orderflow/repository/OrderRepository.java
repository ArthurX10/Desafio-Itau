package com.arthur.orderflow.repository;


import com.arthur.orderflow.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long>{
    
}
