package com.example.pancakes_unlimited.pancake;

import entities.PancakeEntity;

import java.util.Collection;
import java.util.List;

public interface IPancakeService {
    public abstract void createPancake(PancakeEntity newPancake);
    public abstract void deletePancake(int pancakeId);
    public abstract void updatePancake(int pancakeId, List<Integer> ingredients);
}
