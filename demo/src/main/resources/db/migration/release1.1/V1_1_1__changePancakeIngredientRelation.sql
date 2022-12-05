ALTER TABLE ingredient
DROP COLUMN pancake_id;

CREATE TABLE pancake_ingredient (
    id int PRIMARY KEY,
    pancake_id int REFERENCES pancake (id),
    ingredient_id int REFERENCES ingredient(id)
);