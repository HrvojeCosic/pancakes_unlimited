package com.example.pancakes_unlimited.ingredient;

import java.math.BigDecimal;

public interface CustomizedIngredientRepository {
    public IngredientDTO createIngredient(String name, BigDecimal price, int categoryId);
    public IngredientDTO updateIngredient(int ingredientId, String name, BigDecimal price, int categoryId);
}
