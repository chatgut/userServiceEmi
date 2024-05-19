CREATE DATABASE user;

CREATE TABLE IF NOT EXISTS user (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      user_name VARCHAR(255) NOT NULL UNIQUE,
                      first_name VARCHAR(255) NOT NULL,
                      last_name VARCHAR(255) NOT NULL,
                      user_token VARCHAR(255) UNIQUE,
                      image_url VARCHAR(255),
                      number_of_messages INT
);