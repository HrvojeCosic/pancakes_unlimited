package com.example.pancakes_unlimited.report.service;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.ingredient.repository.IngredientRepository;
import com.example.pancakes_unlimited.report.ReportUtils;
import entities.IngredientEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements IReportService {
    IngredientRepository repository;

    public ReportService(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IngredientDTO> getMostPopularMonthlyIngredients() {
        List<Integer> ingredientIds = repository.getMostOrderedMonthlyIngredientIds();
        List<IngredientEntity> mostOrderedMonthlyIngredients = repository.findAllById(ingredientIds);

        return ReportUtils.formatIngredientsForReport(mostOrderedMonthlyIngredients);
    }

    @Override
    public List<IngredientDTO> getMostPopularMonthlyHealthyIngredientIds() {
        List<Integer> ingredientIds = repository.getMostOrderedMonthlyHealthyIngredientIds();
        List<IngredientEntity> mostOrderedMonthlyHealthyIngredients = repository.findAllById(ingredientIds);

        return ReportUtils.formatIngredientsForReport(mostOrderedMonthlyHealthyIngredients);
    }
}
