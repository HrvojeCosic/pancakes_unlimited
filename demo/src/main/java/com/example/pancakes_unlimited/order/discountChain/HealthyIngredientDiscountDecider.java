package com.example.pancakes_unlimited.order.discountChain;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;
import com.example.pancakes_unlimited.order.type.OrderContent;
import com.example.pancakes_unlimited.order.type.OrderPancake;

import java.util.List;

public class HealthyIngredientDiscountDecider implements IDiscountDecider {
    private IDiscountDecider nextDecider;

    @Override
    public void setNextDecider(IDiscountDecider nextDecider) {
        this.nextDecider = nextDecider;
    }

    @Override
    public void createDiscount(OrderContent orderContent) {
        List<OrderPancake> orderPancakes = orderContent.getOrderPancakes();
        boolean achievedDiscount = false;

        for (OrderPancake pancake: orderPancakes) {
            double allPancakeNumber = pancake.getIngredients().size();
            double healthyPancakeNumber = pancake.getIngredients().stream()
                    .filter(IngredientDTO::getIsHealthy)
                    .toList().size();

            if (healthyPancakeNumber / allPancakeNumber > 0.75) {
                pancake.setPancakeDiscount(0.15);
                achievedDiscount = true;
            }
        }

        if (!achievedDiscount && nextDecider != null) {
            nextDecider.createDiscount(orderContent);
        }
    }
}
