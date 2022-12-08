package com.example.pancakes_unlimited.ingredient.service;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import entities.IngredientEntity;

import java.util.List;

public interface IIngredientService {
    public abstract List<IngredientDTO> getAllIngredients();
    public abstract IngredientDTO createIngredient(IngredientDTO newIngredient);
    public abstract void deleteIngredient(int ingredientId);
    public abstract IngredientDTO updateIngredient(int ingredientId, IngredientDTO payload);
}
