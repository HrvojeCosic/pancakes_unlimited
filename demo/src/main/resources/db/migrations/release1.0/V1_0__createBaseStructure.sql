CREATE TABLE IF NOT EXISTS category(
    id int PRIMARY KEY,
    name varchar(32) NOT NULL
);

CREATE TABLE IF NOT EXISTS pancake (
    id int PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS ingredient(
     id int PRIMARY KEY,
     name varchar(32) NOT NULL,
     price DECIMAL(6, 2) NOT NULL,
     pancake_id int,
     category_id int NOT NULL,
     FOREIGN KEY (pancake_id) REFERENCES pancake(id),
     FOREIGN KEY (category_id) REFERENCES category(id)
);
