package com.example.pancakes_unlimited.order.service;

import com.example.pancakes_unlimited.order.OrderDTO;

public interface IOrderService {
    public abstract OrderDTO createOrder(OrderDTO newOrder);
    public abstract OrderDTO getOrder(int orderId);
}
