package com.example.pancakes_unlimited.order.service;

import com.example.pancakes_unlimited.order.type.OrderDTO;

public interface IOrderService {
    public abstract OrderDTO createOrder(OrderDTO newOrder);
    public abstract OrderDTO getOrder(int orderId);
}
