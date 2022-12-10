package com.example.pancakes_unlimited.report;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import entities.IngredientEntity;

import java.util.ArrayList;
import java.util.List;

public class ReportUtils {
    public static List<IngredientDTO> formatIngredientsForReport(List<IngredientEntity> ingredients) {
        List<IngredientDTO> ingredientsForReport = new ArrayList<>();
        for (IngredientEntity ingredient : ingredients) {
            ingredientsForReport.add(
                    new IngredientDTO()
                            .setName(ingredient.getName())
                            .setPrice(ingredient.getPrice())
                            .setCategory_id(ingredient.getCategoryId())
                            .setIsHealthy(ingredient.getIsHealthy())
            );
        }
        return ingredientsForReport;
    }
}
