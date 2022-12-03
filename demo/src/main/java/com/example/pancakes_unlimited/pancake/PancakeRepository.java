package com.example.pancakes_unlimited.pancake;

import entities.PancakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PancakeRepository extends JpaRepository<PancakeEntity, Integer> {
}
