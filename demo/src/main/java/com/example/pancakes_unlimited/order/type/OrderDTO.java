package com.example.pancakes_unlimited.order.type;


import java.time.OffsetDateTime;
import java.util.List;

public class OrderDTO {

    private int id;
    private String description;
    private OffsetDateTime timestamp;
    private List<Integer> pancakeIds;
    private OrderContent orderContent;

    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public List<Integer> getPancakeIds() {
        return pancakeIds;
    }
    public OrderContent getOrderContent() {
        return orderContent;
    }

    public OrderDTO setId(int id) {
        this.id = id;
        return this;
    }
    public OrderDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public OrderDTO setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public OrderDTO setPancakeIds(List<Integer> pancakeIds) {
        this.pancakeIds = pancakeIds;
        return this;
    }

    public OrderDTO setOrderContentByOrderIds(OrderContent orderContent) {
        this.orderContent = orderContent;
        return this;
    }
}
