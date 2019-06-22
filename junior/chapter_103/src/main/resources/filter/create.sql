-- create tables
create table product(
                      id_product smallserial primary key ,
                      name varchar(100),
                      id_type int references type(id_type) not null ,
                      expiry_date TIMESTAMP  NOT NULL DEFAULT current_date,
                      price float
);

create table type(
                   id_type smallserial primary key ,
                   name varchar(100)
);

-- inserts values into tables type
insert into type(
  name
) values ('cheese'),
         ('butter'),
         ('water'),
         ('milk'),
         ('vegetables');

select * from type;

-- inserts values into tables product

insert into product(
  name,
  id_type,
  price
) values (
           'Российский',
           1,
           23.4
         ),
         (
          'Масло Белорусское',
          2,
          12.3
          ),
         (
          'Молоко',
          3,
          99.9
          ),
         (
          'Яблоко',
          5,
          0.99
          );

select * from product;

-- add new column in product
ALTER TABLE product ADD COLUMN count integer;