package com.example.pancakes_unlimited.ingredient;

public interface CustomizedIngredientRepository {
    public IngredientDTO createIngredient(IngredientDTO newIngredient);
    public IngredientDTO updateIngredient(int ingredientId, IngredientDTO payload);
}
