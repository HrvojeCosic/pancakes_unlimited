package com.example.pancakes_unlimited.pancake;

import java.util.List;

public class PancakeUpdatePayload {
    private List<Integer> addedIngredients;
    private List<Integer> removedIngredients;

    public List<Integer> getAddedIngredients() {
        return addedIngredients;
    }
    public List<Integer> getRemovedIngredients() {
        return removedIngredients;
    }
}
