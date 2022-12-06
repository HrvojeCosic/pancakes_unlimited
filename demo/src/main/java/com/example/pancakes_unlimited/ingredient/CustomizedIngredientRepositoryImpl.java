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
    public IngredientDTO createIngredient(String name, BigDecimal price, int categoryId) {
        Optional<CategoryEntity> chosenCategory = categoryRepository.findById(categoryId);
        if (!chosenCategory.isPresent()) {
            throw new ResourceNotFoundException("Chosen ingredient category does not exist.");
        }

       IngredientEntity ingredientEntity = new IngredientEntity();
       ingredientEntity.setName(name)
                       .setPrice(price)
                       .setCategoryByCategoryId(chosenCategory.get());

       ingredientRepository.save(ingredientEntity);
        return new IngredientDTO(name, price, categoryId);
    }

    @Override
    public IngredientDTO updateIngredient(int ingredientId, String name, BigDecimal price, int categoryId) {
        Optional<IngredientEntity> chosenIngredient = ingredientRepository.findById(ingredientId);
        if (!chosenIngredient.isPresent()) {
            throw new ResourceNotFoundException("Ingredient does not exist.");
        }

        IngredientEntity ingredientToUpdate = chosenIngredient.get();
        if (name != null) { ingredientToUpdate.setName(name); }
        if (price != null) { ingredientToUpdate.setPrice(price); }
        if (categoryId != 0) {
            Optional<CategoryEntity> chosenCategory = categoryRepository.findById(categoryId);
            if (!chosenCategory.isPresent()) {
                throw new ResourceNotFoundException("Chosen ingredient category does not exist.");
            }
            ingredientToUpdate.setCategoryByCategoryId(chosenCategory.get());
        }
        return new IngredientDTO(name, price, categoryId);
    }
}
