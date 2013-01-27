--liquibase formatted sql
 
--changeset sergey:1
CREATE TABLE users (
    user_id serial primary key,
    USERNAME VARCHAR(45) NOT NULL,
  	PASSWORD VARCHAR(45) NOT NULL,
  	enabled boolean  NOT NULL
);
--rollback drop table users

--changeset sergey:2

CREATE TABLE user_roles (
    user_role_id serial primary key,
    user_id INTEGER NOT NULL REFERENCES users(user_id),
    AUTHORITY VARCHAR(45)
	
);

--rollback drop table user_roles