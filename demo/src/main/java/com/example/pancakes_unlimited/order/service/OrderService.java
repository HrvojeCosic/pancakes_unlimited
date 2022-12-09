package com.example.pancakes_unlimited.order.service;

import com.example.pancakes_unlimited.exception.InvalidInputException;
import com.example.pancakes_unlimited.exception.ResourceNotFoundException;
import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.order.discountChain.DiscountMaker;
import com.example.pancakes_unlimited.order.type.OrderContent;
import com.example.pancakes_unlimited.order.type.OrderDTO;
import com.example.pancakes_unlimited.order.OrderRepository;
import com.example.pancakes_unlimited.order.OrderUtils;
import com.example.pancakes_unlimited.pancake.service.IPancakeService;
import com.example.pancakes_unlimited.pancake.PancakeRepository;
import com.example.pancakes_unlimited.pancake.PancakeUtils;
import com.example.pancakes_unlimited.pancake.type.PancakeWithIngredient;
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

        return new OrderDTO()
                .setDescription(createdOrder.getDescription())
                .setTimestamp(createdOrder.getTimestamp())
                .setPancakeIds(newOrder.getPancakeIds());
    }

    @Override
    public OrderDTO getOrder(int orderId) {
        PancakeOrderEntity orderMainInfo = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + orderId + " does not exist."));
        List<PancakeWithIngredient> orderPancakes = orderRepository.getOrderPancakes(orderId);

        Map<Integer, List<IngredientDTO>> pancakeByIngredients = PancakeUtils.aggregatePancakesById(orderPancakes);
        OrderContent orderContent = OrderUtils.composeOrderContent(pancakeByIngredients);
        new DiscountMaker(orderContent).createDiscount();

        Map<Integer, OrderContent> formattedOrderContent = new HashMap<>();
        formattedOrderContent.put(orderId, orderContent);

        return new OrderDTO()
                .setDescription(orderMainInfo.getDescription())
                .setTimestamp(orderMainInfo.getTimestamp())
                .setOrderContentByOrderIds(formattedOrderContent)
                .setPancakeIds(pancakeByIngredients.keySet().stream().toList());
    }
}
