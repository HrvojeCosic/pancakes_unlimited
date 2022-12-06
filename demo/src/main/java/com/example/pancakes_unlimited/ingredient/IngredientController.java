package com.example.pancakes_unlimited.ingredient;

import entities.PancakeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ingredient")
public class IngredientController {
    private final IIngredientService service;
    public IngredientController(IIngredientService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<IngredientDTO> newIngredient(@RequestBody IngredientDTO newIngredient) {
        IngredientDTO createdIngredient = service.createIngredient((newIngredient));
        return ResponseEntity.ok(createdIngredient);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<IngredientDTO> updateIngredient(@PathVariable(value = "id") int ingredientId,
                                                          @RequestBody IngredientDTO ingredientUpdatePayload) {
        IngredientDTO updatedIngredient = service.updateIngredient(ingredientId, ingredientUpdatePayload);
        return ResponseEntity.ok(updatedIngredient);
    }
}
