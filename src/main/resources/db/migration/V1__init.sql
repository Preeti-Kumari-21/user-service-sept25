CREATE TABLE `role`
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    created_by      VARCHAR(255) NULL,
    state           SMALLINT NULL,
    role_name       VARCHAR(255) NULL,
    CONSTRAINT pk_role PRIMARY KEY (id)
);

CREATE TABLE users
(
    id              BIGINT AUTO_INCREMENT NOT NULL,
    created_at      datetime NULL,
    last_updated_at datetime NULL,
    created_by      VARCHAR(255) NULL,
    state           SMALLINT NULL,
    user_name       VARCHAR(255) NULL,
    email           VARCHAR(255) NULL,
    password        VARCHAR(255) NULL,
    phone_number    VARCHAR(255) NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);