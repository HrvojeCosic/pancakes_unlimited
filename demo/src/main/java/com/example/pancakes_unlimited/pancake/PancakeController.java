package com.example.pancakes_unlimited.pancake;

import entities.PancakeEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PancakeController {
    private final PancakeRepository repository;

    public PancakeController(PancakeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/pancake")
    public  PancakeEntity newPancake(@RequestBody PancakeEntity newPancake) {
        return repository.save(newPancake);
    }
}
