-- create new database
create database car_storage;
use car_storage;

-- create new table
create table carcass(
id_carcass serial not null primary key,
model varchar(30),
color char(2)
)

-- add new column into table carcass
alter table carcass add column model varchar(30) not null;
alter table carcass add column color char(2);
alter table carcass add primary key (id_carcass);

--
create table motor(
id_motor serial not null primary key,
power float
)

--
create table transmission(
id_transmission serial not null primary key,
type char(2),
description text
)

--
create table car(
id_car serial not null primary key,
firm varchar(20) not null,
id_motor int references motor(id_motor),
id_transmission int references transmission(id_transmission)
)

alter table car add column id_carcass int references carcass(id_carcass);

-- motor fill
insert into motor(
power
) values (
5.0
);

-- transmission
insert into transmission(
type, description
) VALUES (
'mn',
'A manual transmission, also known as a manual gearbox, ' ||
 'a standard transmission or colloquially in some countries ' ||
  '(e.g. the United States) as a stick shift, is a type of transmission ' ||
   'used in motor vehicle applications.'
);

-- delete regardless column and add constraint into model column;
alter table carcass drop column color;
ALTER TABLE carcass ADD CONSTRAINT model UNIQUE (model);

-- carcass
insert into carcass(
model
) values (
'Лифтбэк'
);

select * from carcass;

-- fill a car table
insert into car(
firm, id_motor, id_transmission, id_carcass
) values (
'Ауди',
3,
1,
7
);