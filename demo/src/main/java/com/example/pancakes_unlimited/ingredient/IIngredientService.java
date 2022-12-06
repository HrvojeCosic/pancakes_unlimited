package com.example.pancakes_unlimited.ingredient;

import entities.IngredientEntity;

public interface IIngredientService {
    public abstract IngredientDTO createIngredient(IngredientDTO newIngredient);
    public abstract void deleteIngredient(int ingredientId);
    public abstract IngredientEntity updateIngredient(int ingredientId, IngredientEntity payload);
}
