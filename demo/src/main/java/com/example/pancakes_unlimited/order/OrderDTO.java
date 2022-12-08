package com.example.pancakes_unlimited.order;


import com.example.pancakes_unlimited.ingredient.IngredientDTO;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class OrderDTO {
    private String description;
    private OffsetDateTime timestamp;
    private List<Integer> pancakeIds;
    private Map< Integer, Map<Integer, List<IngredientDTO>> > pancakesByOrder;

    public String getDescription() {
        return description;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public List<Integer> getPancakeIds() {
        return pancakeIds;
    }
    public Map< Integer, Map<Integer, List<IngredientDTO>> > getPancakesByOrder() {
        return pancakesByOrder;
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

    public OrderDTO setPancakesByOrder(Map< Integer, Map<Integer, List<IngredientDTO>> > pancakesByOrder) {
        System.out.println("pancakesByOrder"+pancakesByOrder);
        this.pancakesByOrder = pancakesByOrder;
        return this;
    }
}
