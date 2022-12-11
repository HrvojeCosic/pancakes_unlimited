package com.example.pancakes_unlimited.order.type;

import com.example.pancakes_unlimited.ingredient.IngredientDTO;

import java.math.BigDecimal;
import java.util.List;

public class OrderPancake {
    private int pancakeId;
    private List<IngredientDTO> ingredients;
    private BigDecimal pancakePrice;
    private Double pancakeDiscount;

    public OrderPancake(int pancakeId, List<IngredientDTO> ingredients, BigDecimal pancakePrice) {
        this.pancakeId = pancakeId;
        this.ingredients = ingredients;
        this.pancakePrice = pancakePrice;
    }

    public int getPancakeId() {
        return pancakeId;
    }

    public List<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public BigDecimal getPancakePrice() {
        return pancakePrice;
    }

    public Double getPancakeDiscount() {
        return pancakeDiscount;
    }

    public void setIngredients(List<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public void setPancakeId(int id) {
        this.pancakeId = id;
    }
    public void setPancakePrice(BigDecimal pancakePrice) {
        this.pancakePrice = pancakePrice;
    }

    public void setPancakeDiscount(Double pancakeDiscount) {
        this.pancakeDiscount = pancakeDiscount;
    }
}