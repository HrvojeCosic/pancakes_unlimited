package com.example.pancakes_unlimited.order;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;

import java.util.List;

public class OrderUtils {
    public static String validatePancakeIngredients (List<IngredientDTO> pancakeIngredients) {
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
}
