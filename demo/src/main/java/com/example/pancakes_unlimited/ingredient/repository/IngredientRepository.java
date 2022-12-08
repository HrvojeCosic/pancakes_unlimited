package com.example.pancakes_unlimited.ingredient.repository;

import com.example.pancakes_unlimited.ingredient.repository.CustomizedIngredientRepository;
import entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Integer>, CustomizedIngredientRepository {
}
