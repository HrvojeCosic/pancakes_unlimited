package com.example.pancakes_unlimited.pancake;

import com.example.pancakes_unlimited.exception.ResourceNotFoundException;
import com.example.pancakes_unlimited.ingredient.IngredientRepository;
import entities.IngredientEntity;
import entities.PancakeEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
            throw new ResourceNotFoundException("pancake with id " + pancakeId + " does not exist.");
        }
        pancakeRepository.delete(pancakeToDelete.get());
    }
    @Override
    public PancakeEntity updatePancake(int pancakeId, PancakeUpdatePayload payload) {
        PancakeEntity pancakeToUpdate = pancakeRepository.findById(pancakeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "pancake with id " + pancakeId + " does not exist."
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
}