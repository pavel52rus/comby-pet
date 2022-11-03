CREATE SCHEMA IF NOT EXISTS public;

SET SCHEMA 'public';

CREATE TABLE books (
    id bigserial primary key,
    name text NOT NULL,
    author_id bigint NOT NULL
);

CREATE TABLE authors (
    id bigserial primary key,
    full_name varchar(256) NOT NULL
)
