package com.example.pancakes_unlimited.ingredient;

import com.example.pancakes_unlimited.category.CategoryRepository;
import com.example.pancakes_unlimited.exception.ResourceNotFoundException;
import entities.CategoryEntity;
import entities.IngredientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.math.BigDecimal;
import java.util.Optional;

public class CustomizedIngredientRepositoryImpl implements CustomizedIngredientRepository {
    private final CategoryRepository categoryRepository;
    @Lazy
    @Autowired
    IngredientRepository ingredientRepository;

    public CustomizedIngredientRepositoryImpl(
            CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public IngredientDTO createIngredient(IngredientDTO newIngredient) {
        String name = newIngredient.getName();
        BigDecimal price = newIngredient.getPrice();
        int categoryId = newIngredient.getCategory_id();
        Optional<CategoryEntity> chosenCategory = categoryRepository.findById(categoryId);
        if (!chosenCategory.isPresent()) {
            throw new ResourceNotFoundException("Odabrana kategorija sastojka ne postoji.");
        }

        IngredientEntity ingredientEntity = new IngredientEntity();
        ingredientEntity.setName(name);
        ingredientEntity.setPrice(price);
        ingredientEntity.setCategoryByCategoryId(chosenCategory.get());
        return newIngredient;
    }
}
