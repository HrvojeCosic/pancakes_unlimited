package com.example.pancakes_unlimited.ingredient.repository;

import entities.IngredientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Integer>, CustomizedIngredientRepository {
    @Query(value = "WITH Ordered_ingredient_ocurrances_by_id AS (" +
            "SELECT ingredient_id, COUNT(ingredient_id) AS occurance " +
            "FROM pancake_order AS PO " +
            "JOIN pancake AS P ON PO.id = P.order_id " +
            "JOIN pancake_ingredient AS PI ON P.id = PI.pancake_id " +
            "JOIN ingredient AS I ON I.id = PI.ingredient_id " +
            "WHERE timestamp > (current_date - interval '30' day)" +
            "GROUP BY ingredient_id ORDER BY occurance DESC) " +

            "SELECT ingredient_id " +
            "FROM Ordered_ingredient_ocurrances_by_id " +
            "WHERE occurance = (SELECT occurance FROM Ordered_ingredient_ocurrances_by_id LIMIT 1);",
            nativeQuery = true)
    public List<Integer> getMostOrderedMonthlyIngredientIds();

    @Query(value = "WITH Ordered_ingredient_ocurrances_by_id AS (" +
            "SELECT ingredient_id, COUNT(ingredient_id) AS occurance " +
            "FROM pancake_order AS PO " +
            "JOIN pancake AS P ON PO.id = P.order_id " +
            "JOIN pancake_ingredient AS PI ON P.id = PI.pancake_id " +
            "JOIN ingredient AS I ON I.id = PI.ingredient_id " +
            "WHERE timestamp > (current_date - interval '30' day)" +
            "AND I.is_healthy = true " +
            "GROUP BY ingredient_id ORDER BY occurance DESC) " +

            "SELECT ingredient_id " +
            "FROM Ordered_ingredient_ocurrances_by_id " +
            "WHERE occurance = (SELECT occurance FROM Ordered_ingredient_ocurrances_by_id LIMIT 1);",
            nativeQuery = true)
    public List<Integer> getMostOrderedMonthlyHealthyIngredientIds();
}
