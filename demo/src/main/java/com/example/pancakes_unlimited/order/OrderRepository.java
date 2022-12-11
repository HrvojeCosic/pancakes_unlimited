package com.example.pancakes_unlimited.order;

import com.example.pancakes_unlimited.pancake.type.PancakeWithIngredient;
import entities.PancakeOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<PancakeOrderEntity, Integer> {
    @Query("SELECT new com.example.pancakes_unlimited.pancake.type.PancakeWithIngredient(" +
           "PI.pancakeId, PI.ingredientId, ING.price, ING.name, C.name, ING.isHealthy) " +
           "FROM PancakeIngredientEntity AS PI " +
           "JOIN IngredientEntity AS ING ON PI.ingredientId = ING.id " +
           "JOIN CategoryEntity AS C ON C.id = ING.categoryByCategoryId.id " +
           "JOIN PancakeEntity AS P ON PI.pancakeId = P.id " +
           "JOIN PancakeOrderEntity AS ORDER ON ORDER.id = :orderId " +
           "WHERE P.pancakeOrder.id = :orderId"
    )
    public List<PancakeWithIngredient> getOrderPancakes(int orderId);

    @Modifying
    @Query(value = "UPDATE pancake " +
                   "SET order_id = null " +
                   "WHERE id = :pancakeId AND order_id = :orderId",
            nativeQuery = true)
    public void removePancakeFromOrder(int pancakeId, int orderId);
}
