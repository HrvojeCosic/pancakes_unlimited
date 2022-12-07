package com.example.pancakes_unlimited.pancake;

import java.math.BigDecimal;

public class PancakeWithIngredient {
    private final Integer pancake_id;
    private final Integer ingredient_id;
    private final String ingredient_name;
    private final BigDecimal ingredient_price;
    private final String ingredient_category_name;

    public PancakeWithIngredient(int pancake_id, int ingredient_id, BigDecimal ingredient_price,
                                 String ingredient_name, String ingredient_category_name) {
        this.pancake_id = pancake_id;
        this.ingredient_id = ingredient_id;
        this.ingredient_price = ingredient_price;
        this.ingredient_name = ingredient_name;
        this.ingredient_category_name = ingredient_category_name;
    }

    public int getPancake_id() {
        return pancake_id;
    }

    public int getIngredient_id() {
        return ingredient_id;
    }

    public BigDecimal getIngredient_price() {
        return ingredient_price;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public String getIngredient_category_name() {
        return ingredient_category_name;
    }
}