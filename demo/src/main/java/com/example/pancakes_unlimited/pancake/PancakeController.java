package com.example.pancakes_unlimited.pancake;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import entities.PancakeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pancake")
public class PancakeController {
    private final IPancakeService service;

    public PancakeController(IPancakeService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity< Map<Integer, List<IngredientDTO>> > getAll() {
        Map<Integer, List<IngredientDTO>> allPancakes = service.getAllPancakes();
        return ResponseEntity.ok(allPancakes);
    }

    @PostMapping("/create")
    public ResponseEntity<PancakeEntity> newPancake(@RequestBody PancakeEntity newPancake) {
        PancakeEntity createdPancake = service.createPancake((newPancake));
        return ResponseEntity.ok(createdPancake);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePancake(@PathVariable(value = "id") int pancakeId) {
       service.deletePancake(pancakeId);
       return ResponseEntity.ok("Pancake with id " + pancakeId + " successfully deleted");
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<PancakeEntity> updatePancake(@PathVariable(value = "id") int pancakeId,
                                                       @RequestBody PancakeUpdatePayload pancakeUpdatePayload) {
            PancakeEntity updatedPancake = service.updatePancake(pancakeId, pancakeUpdatePayload);
            return ResponseEntity.ok(updatedPancake);
    }
}
