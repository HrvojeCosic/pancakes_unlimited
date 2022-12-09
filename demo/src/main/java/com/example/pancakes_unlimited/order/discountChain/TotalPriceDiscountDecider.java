package com.example.pancakes_unlimited.order.discountChain;

import com.example.pancakes_unlimited.order.type.OrderContent;

import java.math.BigDecimal;
import java.util.*;

public class TotalPriceDiscountDecider implements IDiscountDecider {
    private IDiscountDecider nextDecider;

    @Override
    public void setNextDecider(IDiscountDecider nextDecider) {
        this.nextDecider = nextDecider;
    }

    @Override
    public void createDiscount(OrderContent orderContent) {
        boolean achievedDiscount = false;

        Map<BigDecimal, Double> discountByTotalPrice = new HashMap<>();
        discountByTotalPrice.put(BigDecimal.valueOf(200), 0.10);
        discountByTotalPrice.put(BigDecimal.valueOf(100), 0.05);

        List<BigDecimal> discountByTotalPriceKeys = new ArrayList<>(discountByTotalPrice.keySet());
        Collections.sort(discountByTotalPriceKeys);

        for (BigDecimal totalPriceThreshold: discountByTotalPriceKeys) {
            if (orderContent.getTotalPrice().compareTo(totalPriceThreshold) == 1) {
                achievedDiscount = true;
                orderContent.setOrderDiscount(discountByTotalPrice.get(totalPriceThreshold));
            }
        }

        if (!achievedDiscount && nextDecider != null) {
            nextDecider.createDiscount(orderContent);
        }
    }
}
