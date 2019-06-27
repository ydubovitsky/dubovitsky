-- 1. Вывести список всех машин и все привязанные к ним детали.
select car.firm, carcass.model, motor.power, transmission.type
from car, motor, transmission, carcass
where car.id_carcass = carcass.id_carcass
and
car.id_transmission = transmission.id_transmission
and
car.id_motor = motor.id_motor;

-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select distinct car.firm, carcass.model, motor.power, transmission.type
from car, motor, transmission, carcass
EXCEPT
select distinct car.firm, carcass.model, motor.power, transmission.type
from car, motor, transmission, carcass
where car.id_carcass = carcass.id_carcass
and
car.id_transmission = transmission.id_transmission
and
car.id_motor = motor.id_motor
