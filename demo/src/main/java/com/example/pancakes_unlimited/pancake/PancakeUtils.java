package com.example.pancakes_unlimited.pancake;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;

import java.util.*;

public class PancakeUtils {
    public static Map<Integer, List<IngredientDTO>> aggregatePancakesById (Collection<PancakeWithIngredient> orderInfo) {

        Map<Integer, List<IngredientDTO>> pancakeByIngredients = new HashMap<>();

        for(PancakeWithIngredient pancake: orderInfo) {
            int pancake_id = pancake.getPancake_id();
            IngredientDTO pancakeIngredient = new IngredientDTO()
                    .setName(pancake.getIngredient_name())
                    .setPrice(pancake.getIngredient_price())
                    .setCategory_id(pancake.getIngredient_id())
                    .setCategory_name(pancake.getIngredient_category_name());

            if (!pancakeByIngredients.containsKey(pancake_id)) {
                List<IngredientDTO> ingredients = new ArrayList<>();
                ingredients.add(pancakeIngredient);
                pancakeByIngredients.put(pancake_id, ingredients);
            } else {
                List<IngredientDTO> existingPancake = pancakeByIngredients.get(pancake_id);
                existingPancake.add(pancakeIngredient);
            }
        }

        return pancakeByIngredients;
    }
}
