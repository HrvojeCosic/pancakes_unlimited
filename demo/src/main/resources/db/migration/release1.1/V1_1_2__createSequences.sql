CREATE SEQUENCE pancake_id_seq
    start with 1
    increment by 1;

CREATE SEQUENCE ingredient_id_seq
    start with 1
    increment by 1;

CREATE SEQUENCE pancake_ingredient_id_seq
    start with 1
    increment by 1;

ALTER TABLE pancake ALTER COLUMN id SET DEFAULT nextval('pancake_id_seq');
ALTER TABLE ingredient ALTER COLUMN id SET DEFAULT nextval('ingredient_id_seq');
ALTER TABLE pancake_ingredient ALTER COLUMN id SET DEFAULT nextval('pancake_ingredient_id_seq');
