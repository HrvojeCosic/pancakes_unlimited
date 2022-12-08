package com.example.pancakes_unlimited.order.type;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderPancake {
    private List<IngredientDTO> ingredients;
    private BigDecimal pancakePrice;

    public OrderPancake(List<IngredientDTO> ingredients, BigDecimal pancakePrice) {
        this.ingredients = ingredients;
        this.pancakePrice = pancakePrice;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public BigDecimal getPancakePrice() {
        return pancakePrice;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public void setPancakePrice(BigDecimal pancakePrice) {
        this.pancakePrice = pancakePrice;
    }
}