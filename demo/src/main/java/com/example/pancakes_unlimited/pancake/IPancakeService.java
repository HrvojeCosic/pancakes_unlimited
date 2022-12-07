package com.example.pancakes_unlimited.pancake;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import entities.PancakeEntity;

import java.util.List;
import java.util.Map;


public interface IPancakeService {
    public abstract PancakeEntity createPancake(PancakeEntity newPancake);
    public abstract void deletePancake(int pancakeId);
    public abstract PancakeEntity updatePancake(int pancakeId, PancakeUpdatePayload payload);
    public abstract Map<Integer, List<IngredientDTO>> getAllPancakes();
}
