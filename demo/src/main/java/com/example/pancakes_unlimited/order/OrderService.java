package com.example.pancakes_unlimited.order;

import com.example.pancakes_unlimited.exception.InvalidInputException;
import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.pancake.IPancakeService;
import com.example.pancakes_unlimited.pancake.PancakeRepository;
import entities.PancakeOrderEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.*;

@Transactional(rollbackOn = InvalidInputException.class)
@Service
public class OrderService implements IOrderService {
    private final IPancakeService pancakeService;
    private final OrderRepository orderRepository;
    private final PancakeRepository pancakeRepository;

    public OrderService(IPancakeService pancakeService,
                        OrderRepository orderRepository,
                        PancakeRepository pancakeRepository) {
        this.pancakeService = pancakeService;
        this.orderRepository = orderRepository;
        this.pancakeRepository = pancakeRepository;
    }

    @Override
    public OrderDTO createOrder(OrderDTO newOrder) {
        PancakeOrderEntity createdOrder = orderRepository.save(new PancakeOrderEntity()
                        .setDescription(newOrder.getDescription())
                        .setTimestamp(OffsetDateTime.now(ZoneId.of("CET")))
        );

        if (newOrder.getPancakeIds() == null || newOrder.getPancakeIds().size() == 0) {
            throw new InvalidInputException("Order must include at least one pancake.");
        }

        Map<Integer, List<IngredientDTO>> allPancakes = pancakeService.getAllPancakes();
        for(Integer pancakeId: newOrder.getPancakeIds()) {
            List<IngredientDTO> pancakeIngredients = allPancakes.get(pancakeId);

            String errorMessage = OrderUtils.validatePancakeIngredients(pancakeIngredients);
            if (errorMessage != null) { throw new InvalidInputException(errorMessage); }

            pancakeRepository.findById(pancakeId).get().setOrder(createdOrder);
        }

        return new OrderDTO(createdOrder.getDescription(),
                            createdOrder.getTimestamp(),
                            newOrder.getPancakeIds());
    }

    @Override
    public void deleteOrder(int orderId) {
        //TODO
    }
}
