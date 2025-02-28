-- V1__create_user_table.sql

CREATE TABLE Users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    user_type VARCHAR(50) NOT NULL DEFAULT 'COMMUM'
);