CREATE TABLE user
(
    id                 BIGINT AUTO_INCREMENT NOT NULL,
    user_name          VARCHAR(255)          NOT NULL,
    first_name         VARCHAR(255)          NOT NULL,
    last_name          VARCHAR(255)          NOT NULL,
    user_token         VARCHAR(255)          NULL,
    image_url          VARCHAR(255)          NULL,
    number_of_messages INT                   NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

ALTER TABLE user
    ADD CONSTRAINT uc_user_user_name UNIQUE (user_name);