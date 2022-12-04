package com.example.pancakes_unlimited.pancake;

import entities.PancakeEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PancakeService implements IPancakeService {
    private final PancakeRepository repository;
    public PancakeService(PancakeRepository repository) { this.repository = repository; }
    @Override
    public void createPancake(PancakeEntity newPancake) {
        repository.save(newPancake);
    }
    @Override
    public void deletePancake(int pancakeId) {
        Optional<PancakeEntity> pancakeToDelete = repository.findById(pancakeId);
        if (pancakeToDelete.isEmpty()) {
            return;
        }
        repository.delete(pancakeToDelete.get());
    }
}