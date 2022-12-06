package com.example.pancakes_unlimited.ingredient;

import entities.IngredientEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class IngredientService implements IIngredientService {
    private final IngredientRepository ingredientRepository;
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientDTO createIngredient(IngredientDTO newIngredient) {
        return ingredientRepository.createIngredient(newIngredient);
    }

    @Override
    public void deleteIngredient(int ingredientId) {

    }

    @Override
    public IngredientDTO updateIngredient(int ingredientId, IngredientDTO payload) {
        return ingredientRepository.updateIngredient(ingredientId, payload);
    }
}
