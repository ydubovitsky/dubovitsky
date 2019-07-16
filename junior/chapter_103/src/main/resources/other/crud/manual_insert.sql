-- insert values into rules
insert into rule(
  rule, description
) VALUES (
           'edit',
           'only edit something'
         );

-- insert values into role
insert into role(
  role
) values (
           'administrator'
         );

-- insert into users
insert into users(
  name, password, description, email
) values (
           'Matthey Smith',
           'password',
           'first user',
           'user@mail.com'
         );

-- insert into item
insert into item(
  description, id_user
) values (
           'Something item',
           1
         );
-- checking
select * from item;

-- insert into category
insert into category(
  category, id_item
) VALUES (
           'Science fiction',
           2
         );

-- state
insert into state(
  description, id_item
) VALUES (
           'Available',
           2
         );

-- attach
-- Вот тут не знаю как поступить, хранить путь к файлу что ли
insert into attach(
  file, id_item
) VALUES (
           1234567, -- последовательность битов
           2
         );

-- comments
insert into comment(
  text, id_item
) VALUES (
           'This is the first comment in database',
           2
         );