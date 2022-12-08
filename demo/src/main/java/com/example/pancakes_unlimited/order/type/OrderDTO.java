package com.example.pancakes_unlimited.order.type;


import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class OrderDTO {

    private String description;
    private OffsetDateTime timestamp;
    private List<Integer> pancakeIds;
    private Map<Integer, OrderContent> orderContentByIds;

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public List<Integer> getPancakeIds() {
        return pancakeIds;
    }
    public Map<Integer, OrderContent> getPancakesByOrder() {
        return orderContentByIds;
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

    public OrderDTO setOrderContentByOrderIds(Map< Integer, OrderContent> pancakesByOrder) {
        this.orderContentByIds = pancakesByOrder;
        return this;
    }
}
