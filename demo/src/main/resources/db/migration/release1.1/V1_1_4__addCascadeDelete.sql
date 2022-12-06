ALTER TABLE pancake_ingredient
    DROP CONSTRAINT pancake_ingredient_pancake_id_fkey,
    ADD CONSTRAINT pancake_ingredient_pancake_id_fkey
        FOREIGN KEY (pancake_id)
            REFERENCES pancake(id)
            ON DELETE CASCADE;

ALTER TABLE pancake_ingredient
    DROP CONSTRAINT pancake_ingredient_ingredient_id_fkey,
    ADD CONSTRAINT pancake_ingredient_ingredient_id_fkey
        FOREIGN KEY (ingredient_id)
            REFERENCES ingredient(id)
            ON DELETE CASCADE;