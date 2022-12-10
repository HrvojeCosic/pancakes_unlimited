package com.example.pancakes_unlimited.report.service;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;

import java.util.List;

public interface IReportService {
    public abstract List<IngredientDTO> getMostPopularMonthlyIngredients();
    public abstract List<IngredientDTO> getMostPopularMonthlyHealthyIngredientIds();
}
