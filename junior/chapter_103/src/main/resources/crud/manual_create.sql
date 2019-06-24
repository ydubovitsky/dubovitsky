create table rule(
  id_rule SMALLSERIAL primary key ,
  rule text,
  description text
);

create table role(
  id_role serial primary key ,
  role text,
  id_rule int references rule(id_rule)
);

create table users(
  id_user serial primary key ,
  name char(30),
  password char(30),
  description text,
  email char(40),
  id_role int references role(id_role)
);

create table item(
  id_item serial primary key ,
  description text,
  id_user int references users(id_user)
);

create table category(
  id_category serial primary key ,
  category char(100),
  id_item int references item(id_item)
);

create table state(
  id_state smallserial primary key ,
  description text,
  id_item int references item(id_item)
);

create table attach(
  id_attach serial primary key ,
  -- Не уверен насчет этого типа
  file bigint,
  id_item int references item(id_item)
);

-- Changing of type
-- ALTER TABLE attach ALTER COLUMN file TYPE bytea; not work!

ALTER TABLE attach ADD COLUMN files bytea;
ALTER TABLE attach DROP COLUMN file;
ALTER TABLE attach RENAME COLUMN files TO file;

create table comment(
  id_comment bigserial primary key ,
  text text,
  id_item int references item(id_item)
);