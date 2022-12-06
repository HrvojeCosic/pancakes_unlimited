package com.example.pancakes_unlimited.ingredient;

import entities.IngredientEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ingredient")
public class IngredientController {
    private final IIngredientService service;
    public IngredientController(IIngredientService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<IngredientEntity> newIngredient(@RequestBody IngredientEntity newIngredient) {
        IngredientEntity createdIngredient = service.createIngredient((newIngredient));
        return ResponseEntity.ok(createdIngredient);
    }
}
