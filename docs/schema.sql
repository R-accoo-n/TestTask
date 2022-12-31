CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS users (
                       id uuid NOT NULL DEFAULT uuid_generate_v4(),
                       "name" varchar(64) NOT NULL,
                       "surname" varchar(64) NOT NULL,
                       "birth_date" date NOT NULL,
                       CONSTRAINT users_pkey PRIMARY KEY (id)
);