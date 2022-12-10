package com.example.pancakes_unlimited.report;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.report.service.IReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    private final IReportService service;

    public ReportController(IReportService service) {
        this.service = service;
    }

    @GetMapping("/monthlyIngredientReport")
    public List<IngredientDTO> createMonthlyIngredientReport() {
        return service.getMostPopularMonthlyIngredients();
    }

    @GetMapping("/monthlyHealthyIngredientReport")
    public List<IngredientDTO> createMonthlyHealthyIngredientReport() {
        return service.getMostPopularMonthlyHealthyIngredientIds();
    }
}
