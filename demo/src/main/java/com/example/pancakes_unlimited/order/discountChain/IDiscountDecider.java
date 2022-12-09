package com.example.pancakes_unlimited.order.discountChain;

import com.example.pancakes_unlimited.order.type.OrderContent;

public interface IDiscountDecider {
    public void setNextDecider(IDiscountDecider nextCalculator);
    public void createDiscount(OrderContent orderContent);
}
