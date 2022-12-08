package com.example.pancakes_unlimited.pancake;

import com.example.pancakes_unlimited.pancake.type.PancakeWithIngredient;
import entities.PancakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PancakeRepository extends JpaRepository<PancakeEntity, Integer> {
    @Query(value = "INSERT INTO pancake_ingredient " +
                   "(pancake_id, ingredient_id) " +
                   "VALUES(" +
                   "(SELECT id FROM pancake WHERE id = :pancakeId)," +
                   "(SELECT id FROM ingredient WHERE id = :ingredientId))" +
                   "ON CONFLICT (pancake_id, ingredient_id) DO NOTHING " +
                   "RETURNING *",
            nativeQuery = true)
    Optional<Integer> addPancakeIngredient(int pancakeId, int ingredientId);


    @Query(value = "DELETE FROM pancake_ingredient " +
                   "WHERE pancake_id = :pancakeId " +
                   "AND ingredient_id = :ingredientId " +
                   "RETURNING *",
            nativeQuery = true)
    Optional<Integer> deletePancakeIngredient(int pancakeId, int ingredientId);

    @Query("SELECT new com.example.pancakes_unlimited.pancake.type.PancakeWithIngredient(" +
           "PI.pancakeId, PI.ingredientId, ING.price, ING.name, C.name) " +
           "FROM PancakeIngredientEntity AS PI " +
           "JOIN IngredientEntity AS ING ON PI.ingredientId = ING.id " +
           "JOIN CategoryEntity AS C ON C.id = ING.categoryByCategoryId.id")
    List<PancakeWithIngredient> getPancakesByIngredients();
}
