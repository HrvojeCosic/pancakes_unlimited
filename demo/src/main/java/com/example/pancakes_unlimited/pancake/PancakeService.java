package com.example.pancakes_unlimited.pancake;

import com.example.pancakes_unlimited.ingredient.IngredientRepository;
import entities.IngredientEntity;
import entities.PancakeEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    public void createPancake(PancakeEntity newPancake) {
        pancakeRepository.save(newPancake);
    }
    @Override
    public void deletePancake(int pancakeId) {
        Optional<PancakeEntity> pancakeToDelete = pancakeRepository.findById(pancakeId);
        if (pancakeToDelete.isEmpty()) {
            return;
        }
        pancakeRepository.delete(pancakeToDelete.get());
    }
    @Override
    public void updatePancake(int pancakeId, List<Integer> ingredientIds) {
        PancakeEntity pancakeToUpdate = pancakeRepository.findById(pancakeId)
                .orElseThrow(() -> new IllegalStateException(
                        "pancake with id " + pancakeId + "is not in our database."
                ));
          return;
//        TODO: handle commit
    }
}