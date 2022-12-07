CREATE TABLE IF NOT EXISTS pancake_order(
    id SERIAL PRIMARY KEY,
    description TEXT,
    timestamp TIMESTAMPTZ NOT NULL
);

ALTER TABLE pancake
ADD COLUMN order_id int REFERENCES pancake_order (id);
