-- Database: library_db
-- Role: library
-- DROP ROLE IF EXISTS library;

CREATE ROLE library WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  REPLICATION
  ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:5bLiyEZPsxC9hOn4LCI84g==$fM2xSNZ/mGAjcYztta88Fm4Uye7ymxuAiuXiL0ux4iM=:PUbPxIbhlCT85Vs9aut1hOUQNJbWnwSGDwBjWaM0rS8=';


DROP DATABASE IF EXISTS library_db;

CREATE DATABASE library_db
    WITH
    OWNER = library
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
	
-- SCHEMA: library_db

-- DROP SCHEMA IF EXISTS library_db ;

CREATE SCHEMA IF NOT EXISTS library_db
    AUTHORIZATION library;
	

-- Table: library_db.book_tbl

-- DROP TABLE IF EXISTS library_db.book_tbl;

CREATE TABLE IF NOT EXISTS library_db.book_tbl
(
    book_id bigint NOT NULL,
    title character varying(50) COLLATE pg_catalog."default" NOT NULL,
    author character varying(50) COLLATE pg_catalog."default" NOT NULL,
    isbn character varying(20) COLLATE pg_catalog."default" NOT NULL,
    publication_year date NOT NULL,
    is_borrowed boolean NOT NULL DEFAULT false,
    CONSTRAINT book_tbl_pkey PRIMARY KEY (book_id)
)

-- Table: library_db.partrons_tbl

-- DROP TABLE IF EXISTS library_db.partrons_tbl;

CREATE TABLE IF NOT EXISTS library_db.partrons_tbl
(
    patrons_id bigint NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    email character varying(50) COLLATE pg_catalog."default" NOT NULL,
    address character varying(200) COLLATE pg_catalog."default" NOT NULL,
    phone_no character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT partrons_tbl_pkey PRIMARY KEY (patrons_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS library_db.partrons_tbl
    OWNER to library;
	

-- Table: library_db.borrowing_record_tbl

-- DROP TABLE IF EXISTS library_db.borrowing_record_tbl;

CREATE TABLE IF NOT EXISTS library_db.borrowing_record_tbl
(
    bw_id bigint NOT NULL,
    book_id bigint NOT NULL,
    borrow_date date,
    return_date date,
    patrons_id bigint,
    CONSTRAINT borrowing_record_tbl_pkey PRIMARY KEY (bw_id),
    CONSTRAINT bowrrow_book_id FOREIGN KEY (book_id)
        REFERENCES library_db.book_tbl (book_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT bowrrow_partions_id FOREIGN KEY (patrons_id)
        REFERENCES library_db.partrons_tbl (patrons_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS library_db.borrowing_record_tbl
    OWNER to library;

	
