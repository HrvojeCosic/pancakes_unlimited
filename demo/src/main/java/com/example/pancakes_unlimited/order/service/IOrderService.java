package com.example.pancakes_unlimited.order.service;

import com.example.pancakes_unlimited.order.type.OrderDTO;

import java.util.List;

public interface IOrderService {
    public abstract OrderDTO createOrder(OrderDTO newOrder);
    public abstract List<OrderDTO> getAllOrders();
    public abstract OrderDTO getOrder(int orderId);
}
