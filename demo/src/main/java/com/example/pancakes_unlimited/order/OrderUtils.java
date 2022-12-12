package com.example.pancakes_unlimited.order;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.order.type.OrderContent;
import com.example.pancakes_unlimited.order.type.OrderPancake;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderUtils {
    public static String validatePancakeIngredients(List<IngredientDTO> pancakeIngredients) {
        if (pancakeIngredients == null) { return "Ordered pancake does not have any ingredients"; }

        int stuffingIngredientCount = 0, baseIngredientCount = 0;
        for(IngredientDTO ingredient: pancakeIngredients) {
            String category = ingredient.getCategory_name();
            if (category.equals("baza")) { baseIngredientCount++; }
            else if (category.equals("nadjev")) { stuffingIngredientCount++; }
        }

        if (baseIngredientCount > 1) { return "Ordered pancake has too many base ingredients."; }
        else if (stuffingIngredientCount < 1) { return "Ordered pancake has too few stuffings."; }

        return null;
    }

    public static OrderContent composeOrderContent(Map<Integer, List<IngredientDTO>> ingredientsByPancake) {
        BigDecimal totalPrice = BigDecimal.valueOf(0);
        List<OrderPancake> orderedPancakes = new ArrayList<>();

        for (Map.Entry<Integer, List<IngredientDTO>> entry : ingredientsByPancake.entrySet()) {
            List<IngredientDTO> pancakeIngredients = entry.getValue();
            BigDecimal pancakePrice = BigDecimal.valueOf(0);

            for(IngredientDTO ingredient: pancakeIngredients) {
                totalPrice = totalPrice.add(ingredient.getPrice());
                pancakePrice = pancakePrice.add(ingredient.getPrice());
            }

            orderedPancakes.add(new OrderPancake(entry.getKey(), pancakeIngredients, pancakePrice));
        }

        return new OrderContent(orderedPancakes, totalPrice);
    }
}
