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

CREATE TABLE users_roles
(
    roles_id BIGINT NOT NULL,
    users_id BIGINT NOT NULL
);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_role FOREIGN KEY (roles_id) REFERENCES `role` (id);

ALTER TABLE users_roles
    ADD CONSTRAINT fk_userol_on_user FOREIGN KEY (users_id) REFERENCES users (id);