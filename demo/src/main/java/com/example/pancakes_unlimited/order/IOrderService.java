package com.example.pancakes_unlimited.order;

public interface IOrderService {
    public abstract OrderDTO createOrder(OrderDTO newOrder);
    public abstract OrderDTO getOrder(int orderId);
}
