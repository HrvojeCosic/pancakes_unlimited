package com.example.pancakes_unlimited.ingredient;

import entities.IngredientEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class IngredientService implements IIngredientService {
    private final IngredientRepository ingredientRepository;
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<IngredientDTO> getAllIngredients() {
        List<IngredientDTO> ingredients = new ArrayList<>();
        for(IngredientEntity ingredientEntity: ingredientRepository.findAll()) {
            ingredients.add(new IngredientDTO()
                            .setName(ingredientEntity.getName())
                            .setPrice(ingredientEntity.getPrice())
                            .setCategory_id(ingredientEntity.getCategoryId())
            );
        }
        return ingredients;
    }

    @Override
    public IngredientDTO createIngredient(IngredientDTO newIngredient) {
        String name = newIngredient.getName();
        BigDecimal price = newIngredient.getPrice();
        int categoryId = newIngredient.getCategory_id();

        return ingredientRepository.createIngredient(name, price, categoryId);
    }

    @Override
    public void deleteIngredient(int ingredientId) {

    }

    @Override
    public IngredientDTO updateIngredient(int ingredientId, IngredientDTO payload) {
        String name = payload.getName();
        BigDecimal price = payload.getPrice();
        int categoryId = payload.getCategory_id();

        return ingredientRepository.updateIngredient(ingredientId, name, price, categoryId);
    }
}
