CREATE UNIQUE INDEX idx_unique_pancake_ingredient
    ON pancake_ingredient (pancake_id, ingredient_id);