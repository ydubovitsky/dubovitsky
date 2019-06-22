-- 1. Написать запрос получение всех продуктов с типом "СЫР";
select id_product, product.name, type from product, type
  where product.id_type = type.id_type and type.name = 'cheese';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
create view prod_pos as
select id_product, name, position('Мороженое' in name) as pos
  from product;
select name from prod_pos where pos > 0;

-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
-- (что делаем: к текущей дате прибавляем месяц, и вычитаем из срока годности получившуюся дату,
-- если значение равно 0, то срок годности кончается в следующем месяце.
select name from clock where month(
	convert(
		(select times from clock group by times), date)
        ) -
    convert(
		date_add(current_date(), interval 1 month), date)
        = 0 group by name;


-- 4. Написать запрос, который выводит самый дорогой продукт.
select id_product, name from product
  where price = (select max(price) from product);

-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
select * from product;
select id_type, count(product.id_type) as Count_of_products from product group by product.id_type order by id_type;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select id_product, name,type from product
  where product.id_type = (select type.id_type from type where type.name = 'cheese')
  union
select id_product, name,type from product
  where product.id_type = (select type.id_type from type where type.name = 'milk');

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select * from product;
-- у всех молочных продуктов количество равно 15 теперь
update product set count = 15 where product.id_type = 3;
select type.name from product, type where
  product.count < 10 group by type.name;

-- 8. Вывести все продукты и их тип.
select product.name, type.name from product, type
  where product.id_type = type.id_type;