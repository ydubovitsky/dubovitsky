CREATE FUNCTION one() RETURNS integer AS $$
    SELECT count(id_car) from car AS result;
$$ LANGUAGE SQL;

-- Альтернативная запись строковой константы:
CREATE FUNCTION two() RETURNS integer AS '
    SELECT count(id_car) from car AS result;
' LANGUAGE SQL;

select one();
select two();