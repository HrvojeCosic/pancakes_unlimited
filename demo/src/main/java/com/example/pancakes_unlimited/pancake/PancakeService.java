package com.example.pancakes_unlimited.pancake;

import com.example.pancakes_unlimited.exception.ResourceNotFoundException;
import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.ingredient.IngredientRepository;
import entities.IngredientEntity;
import entities.PancakeEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;

@Transactional
@Service
public class PancakeService implements IPancakeService {
    private final PancakeRepository pancakeRepository;
    private final IngredientRepository ingredientRepository;
    public PancakeService(
            PancakeRepository pancakeRepository, IngredientRepository ingredientRepository) {
        this.pancakeRepository = pancakeRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public PancakeEntity createPancake(PancakeEntity newPancake) {
        return pancakeRepository.save(newPancake);
    }

    @Override
    public void deletePancake(int pancakeId) {
        Optional<PancakeEntity> pancakeToDelete = pancakeRepository.findById(pancakeId);
        if (pancakeToDelete.isEmpty()) {
            throw new ResourceNotFoundException("Pancake with id " + pancakeId + " does not exist.");
        }
        pancakeRepository.delete(pancakeToDelete.get());
    }

    @Override
    public PancakeEntity updatePancake(int pancakeId, PancakeUpdatePayload payload) {
        PancakeEntity pancakeToUpdate = pancakeRepository.findById(pancakeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Pancake with id " + pancakeId + " does not exist."
                ));

        if (payload.getAddedIngredients() != null && payload.getAddedIngredients().size() != 0) {
            for (int ingredientId: payload.getAddedIngredients()) {
                Optional<IngredientEntity> optionalIngredient = ingredientRepository.findById(ingredientId);
                if (optionalIngredient.isPresent()) {
                    pancakeRepository.addPancakeIngredient(pancakeId, ingredientId);
                }
            }
        }
        if (payload.getRemovedIngredients() != null && payload.getRemovedIngredients().size() != 0) {
            for (int ingredientId: payload.getRemovedIngredients()) {
                Optional<IngredientEntity> optionalIngredient = ingredientRepository.findById(ingredientId);
                if (optionalIngredient.isPresent()) {
                    pancakeRepository.deletePancakeIngredient(pancakeId, ingredientId);
                }
            }
        }
        return pancakeToUpdate;
    }

    @Override
    public Map<Integer, List<IngredientDTO>> getAllPancakes() {
        List<PancakeWithIngredient> pancakesWithIngredients = pancakeRepository.getPancakesByIngredients();

        Map<Integer, List<IngredientDTO>> pancakeByIngredients = new HashMap<>();
        for(PancakeWithIngredient pancake: pancakesWithIngredients) {
            int pancake_id = pancake.getPancake_id();
            IngredientDTO pancakeIngredient = new IngredientDTO(pancake.getIngredient_name(),
                              pancake.getIngredient_price(),
                              pancake.getIngredient_category_name());

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