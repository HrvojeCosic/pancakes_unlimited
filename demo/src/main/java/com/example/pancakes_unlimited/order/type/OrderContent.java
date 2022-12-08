package com.example.pancakes_unlimited.order.type;

import java.math.BigDecimal;
import java.util.Map;

public class OrderContent {
    private BigDecimal totalPrice;
    private Map<Integer, OrderPancake> pancakesById;

    public OrderContent(Map<Integer, OrderPancake> pancakesById, BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        this.pancakesById = pancakesById;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public Map<Integer, OrderPancake> getPancakesById() {
        return pancakesById;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPancakesById(Map<Integer, OrderPancake> pancakesById) {
        this.pancakesById = pancakesById;
    }
}