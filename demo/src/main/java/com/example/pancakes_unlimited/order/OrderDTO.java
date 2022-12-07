package com.example.pancakes_unlimited.order;


import java.time.OffsetDateTime;
import java.util.List;

public class OrderDTO {
    private final String description;
    private final OffsetDateTime timestamp;
    private final List<Integer> pancakeIds;

    public OrderDTO(String description, OffsetDateTime time, List<Integer> pancakeIds) {
        this.description = description;
        this.timestamp = time;
        this.pancakeIds = pancakeIds;
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
}
