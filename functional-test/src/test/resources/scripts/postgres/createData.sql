DROP TABLE IF EXISTS user_data;

CREATE TABLE user_data (
   id integer NOT NULL,
   user_name text COLLATE pg_catalog."default",
   age integer NOT NULL,
   employed boolean NOT NULL,
    CONSTRAINT data_user_pkey PRIMARY KEY (id)
);

ALTER TABLE user_data
    OWNER to my_db;

INSERT INTO user_data (id, user_name, age, employed) VALUES
	(0, 'First user', 1, false),
 	(100, 'Last user', 20, true);