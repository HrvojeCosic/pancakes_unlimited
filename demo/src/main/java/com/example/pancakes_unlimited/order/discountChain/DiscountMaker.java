package com.example.pancakes_unlimited.order.discountChain;

import com.example.pancakes_unlimited.order.type.OrderContent;

public class DiscountMaker {
    IDiscountDecider handler;
    OrderContent orderContent;

    public DiscountMaker(OrderContent orderContent) {
        this.orderContent = orderContent;

        IDiscountDecider healthyIngredientDiscountDecider = new HealthyIngredientDiscountDecider();
        IDiscountDecider totalPriceDiscountDecider = new TotalPriceDiscountDecider();

        healthyIngredientDiscountDecider.setNextDecider(totalPriceDiscountDecider);
        handler = healthyIngredientDiscountDecider;
    }

    public void createDiscount() {
        handler.createDiscount(orderContent);
    }
}
