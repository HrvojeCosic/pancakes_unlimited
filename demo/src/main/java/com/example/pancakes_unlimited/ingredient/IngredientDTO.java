package com.example.pancakes_unlimited.ingredient;

import java.math.BigDecimal;

public class IngredientDTO {
    private final String name;
    private final BigDecimal price;
    private final int category_id;

    public IngredientDTO(String name, BigDecimal price, int category_id) {
        this.name = name;
        this.price = price;
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCategory_id() {
        return category_id;
    }
}
