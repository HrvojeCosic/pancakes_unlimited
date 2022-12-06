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
    public IngredientEntity createIngredient(IngredientEntity newIngredient) {
        return ingredientRepository.save(newIngredient);
    }

    @Override
    public void deleteIngredient(int ingredientId) {

    }

    @Override
    public IngredientEntity updateIngredient(int ingredientId, IngredientEntity payload) {
        return null;
    }
}
