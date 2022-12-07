package com.example.pancakes_unlimited.order;

import com.example.pancakes_unlimited.exception.InvalidInputException;
import com.example.pancakes_unlimited.exception.ResourceNotFoundException;
import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.pancake.IPancakeService;
import com.example.pancakes_unlimited.pancake.PancakeRepository;
import entities.PancakeEntity;
import entities.PancakeOrderEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
            throw new InvalidInputException("Order must have at least one pancake.");
        }

        Map<Integer, List<IngredientDTO>> allPancakes = pancakeService.getAllPancakes();
        for(Integer pancakeId: newOrder.getPancakeIds()) {
            List<IngredientDTO> pancakeIngredients = allPancakes.get(pancakeId);
            if (pancakeIngredients == null) {
                throw new InvalidInputException("Ordered pancake does not have any ingredients.");
            }

            int baseIngredientCount = 0;
            int stuffingIngredientCount = 0;
            for(IngredientDTO ingredient: pancakeIngredients) {
                String category = ingredient.getCategory_name();
                if (category.equals("baza")) {
                    baseIngredientCount++;
                    if (baseIngredientCount > 1) {
                        throw new InvalidInputException("Ordered pancake has too many base ingredients.");
                    }
                } else if (category.equals("nadjev")) {
                    stuffingIngredientCount++;
                }
            }
            if (stuffingIngredientCount < 1) {
                throw new InvalidInputException("Ordered pancake has too few stuffings.");
            }

            pancakeRepository.findById(pancakeId).get().setOrder(createdOrder);
        }

        return new OrderDTO(
                createdOrder.getDescription(),
                createdOrder.getTimestamp(),
                newOrder.getPancakeIds());
    }

    @Override
    public void deleteOrder(int orderId) {
        //TODO
    }
}
