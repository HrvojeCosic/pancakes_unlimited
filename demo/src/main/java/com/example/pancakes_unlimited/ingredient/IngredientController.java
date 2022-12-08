package com.example.pancakes_unlimited.ingredient;

import com.example.pancakes_unlimited.ingredient.service.IIngredientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ingredient")
public class IngredientController {
    private final IIngredientService service;
    public IngredientController(IIngredientService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<IngredientDTO>> getAllIngredients() {
        List<IngredientDTO> ingredients = service.getAllIngredients();
        return ResponseEntity.ok(ingredients);
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
