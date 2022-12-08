package com.example.pancakes_unlimited.pancake.service;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.pancake.type.PancakeUpdateDTO;
import entities.PancakeEntity;

import java.util.List;
import java.util.Map;


public interface IPancakeService {
    public abstract PancakeEntity createPancake(PancakeEntity newPancake);
    public abstract void deletePancake(int pancakeId);
    public abstract PancakeEntity updatePancake(int pancakeId, PancakeUpdateDTO payload);
    public abstract Map<Integer, List<IngredientDTO>> getAllPancakes();
}
