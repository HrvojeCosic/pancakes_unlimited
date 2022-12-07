package com.example.pancakes_unlimited.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    private final IOrderService service;

    public OrderController(IOrderService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<OrderDTO> newOrder(@RequestBody OrderDTO newOrder) {
        OrderDTO createdOrder = service.createOrder(newOrder);
        return ResponseEntity.ok(createdOrder);
    }
}
