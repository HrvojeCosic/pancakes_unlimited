package com.example.pancakes_unlimited.order;

import com.example.pancakes_unlimited.order.service.IOrderService;
import com.example.pancakes_unlimited.order.type.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> allOrders = service.getAllOrders();
        return ResponseEntity.ok(allOrders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable(value = "id") int orderId) {
        OrderDTO fetchedOrder = service.getOrder(orderId);
        return ResponseEntity.ok(fetchedOrder);
    }
}
