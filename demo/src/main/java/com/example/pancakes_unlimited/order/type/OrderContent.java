package com.example.pancakes_unlimited.order.type;

import java.math.BigDecimal;
import java.util.List;

public class OrderContent {
    private BigDecimal totalPrice;
    private List<OrderPancake> orderPancakes;

    public OrderContent(List<OrderPancake> orderPancakes, BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        this.orderPancakes = orderPancakes;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public List<OrderPancake> getOrderPancakes() {
        return orderPancakes;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderPancakes(List<OrderPancake> orderPancakes) {
        this.orderPancakes = orderPancakes;
    }
}