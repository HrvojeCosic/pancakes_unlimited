package com.example.pancakes_unlimited.pancake;

import entities.PancakeEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pancake")
public class PancakeController {
    private final IPancakeService service;

    public PancakeController(IPancakeService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void newPancake(@RequestBody PancakeEntity newPancake) {
        service.createPancake((newPancake));
    }
    @DeleteMapping("/{id}")
    public void deletePancake(@PathVariable(value = "id") int pancakeId) {
       service.deletePancake(pancakeId);
    }
}
