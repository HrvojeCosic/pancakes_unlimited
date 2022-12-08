package com.example.pancakes_unlimited.ingredient;

import java.math.BigDecimal;

public class IngredientDTO {
    private String name;
    private BigDecimal price;
    private int category_id;
    private String category_name;
    private boolean isHealthy;

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public boolean getIsHealthy() {
        return isHealthy;
    }

    public IngredientDTO setName(String name) {
        this.name = name;
        return this;
    }

    public IngredientDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public IngredientDTO setCategory_id(int category_id) {
        this.category_id = category_id;
        return this;
    }

    public IngredientDTO setCategory_name(String category_name) {
        this.category_name = category_name;
        return this;
    }

    public IngredientDTO setIsHealthy(boolean isHealthy) {
        this.isHealthy = isHealthy;
        return this;
    }
}
