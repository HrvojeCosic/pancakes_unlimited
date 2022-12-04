package com.example.pancakes_unlimited.pancake;

import entities.PancakeEntity;

public interface IPancakeService {
    public abstract void createPancake(PancakeEntity newPancake);
    public abstract void deletePancake(int pancakeId);
}
