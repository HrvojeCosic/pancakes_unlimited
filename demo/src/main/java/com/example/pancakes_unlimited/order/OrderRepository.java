package com.example.pancakes_unlimited.order;

import entities.PancakeOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository  extends JpaRepository<PancakeOrderEntity, Integer> {
}
