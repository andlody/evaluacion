CREATE TABLE users (
    id integer generated by default as identity,
    created timestamp,
    email varchar(255),
    is_active boolean not null,
    last_login timestamp,
    modified timestamp,
    name varchar(150),
    password varchar(150),
    token varchar(255),
    primary key (id)
);

CREATE TABLE phones (
    id integer generated by default as identity,
    citycode varchar(10),
    contrycode varchar(10),
    number varchar(15),
    user_id integer,
    primary key (id)
);

ALTER TABLE phones ADD foreign key (user_id) references users;