
--DROP TABLE IF EXISTS authors;
--DROP TABLE IF EXISTS books;

CREATE TABLE IF NOT EXISTS authors(
id bigint DEFAULT nextval('author_id_seq') NOT NULL,
first_name character varying NOT NULL,
last_name character varying NOT NULL,
age integer,
CONSTRAINT "authors_pkey" PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS books(
isbn text NOT NULL,
title text NOT NULL,
author_id bigint,
CONSTRAINT "books_pkey" PRIMARY KEY ("isbn"),
CONSTRAINT "fk_author" FOREIGN KEY(author_id) REFERENCES authors(id)
);
