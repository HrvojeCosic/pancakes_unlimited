package com.example.pancakes_unlimited.pancake;

import entities.PancakeEntity;


public interface IPancakeService {
    public abstract PancakeEntity createPancake(PancakeEntity newPancake);
    public abstract void deletePancake(int pancakeId);
    public abstract PancakeEntity updatePancake(int pancakeId, PancakeUpdatePayload payload);
}
