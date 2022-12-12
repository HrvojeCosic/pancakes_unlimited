package com.example.pancakes_unlimited.pancake;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.pancake.type.PancakeWithIngredient;

import java.util.*;

public class PancakeUtils {
    public static Map<Integer, List<IngredientDTO>> aggregatePancakesById (Collection<PancakeWithIngredient> orderInfo) {

        Map<Integer, List<IngredientDTO>> ingredientsByPancake = new HashMap<>();

        for(PancakeWithIngredient pancake: orderInfo) {
            int pancake_id = pancake.getPancake_id();
            IngredientDTO pancakeIngredient = new IngredientDTO()
                    .setName(pancake.getIngredient_name())
                    .setPrice(pancake.getIngredient_price())
                    .setCategory_id(pancake.getIngredient_id())
                    .setCategory_name(pancake.getIngredient_category_name())
                    .setIsHealthy(pancake.getIngredientIsHealthy());

            if (!ingredientsByPancake.containsKey(pancake_id)) {
                List<IngredientDTO> ingredients = new ArrayList<>();
                ingredients.add(pancakeIngredient);
                ingredientsByPancake.put(pancake_id, ingredients);
            } else {
                List<IngredientDTO> existingPancake = ingredientsByPancake.get(pancake_id);
                existingPancake.add(pancakeIngredient);
            }
        }

        return ingredientsByPancake;
    }
}
