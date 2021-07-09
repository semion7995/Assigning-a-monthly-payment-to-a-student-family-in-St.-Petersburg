insert into jc_street (street_code, street_name) values (2,'Second First'), (3, 'Third Street');
вставляем сразу несколько данных в нашу табличку
update jc_street SET street_name = 'Third name' WHERE street_code = 3;

update jc_street SET street_name = 'First street', street_code=10 WHERE street_code = 1;
сразу изменим оба поля в таблице с стрит кодом = 1;

delete from jc_street WHERE street_code = 10;
удаляем строку с указанным идентификатором


select street_name, street_code from jc_street where street_code = 3 OR street_code =1;
вытаскиваем записи с кодом 1, 3

select street_name, street_code from jc_street where street_code in (1,3);
вытаскиваем записи с кодом 1, 3

select street_code from (select street_name, street_code from jc_street where street_code in (1,3)) s1;
объявляем множество и вытаскиваем из него записи s1
select street_code from (select street_name, street_code from jc_street where street_code in (1,3)) s1;

вытаскиваю всё из множества с1
select street_name sn, street_code sc from jc_street where street_code in (1,3)

select sn  from (select street_name sn, street_code sc from jc_street where street_code in (1,3)) s1;
объявил поля как сокращенный вытащил множество

select street_name as sn, street_code as sc from jc_street where street_code in (1,3);
старая форма обозначения полей теперь можно обойтись и без as
вытаскиваю переменную как sn вот и всё

select street_name as sn, street_code as sc from jc_street where street_code in (1,3) order by street_code ASC;
сортировка от меньшего к большему DESC от большего к меньшему

select street_code, upper (street_name) from jc_street where upper(street_name) like upper('%firs%')
//переводим всю выборку в верхний регистр

select street_code, street_name from jc_street where upper(street_name) like upper('%firs%')
выведет в нормальном виде при этом не важно в каком регистре пользователь будет вводить буквы
-------------------------------------------------------------------------------------------------

select * from jc_country_struct where area_id like '__0000000000' получаем код краев
select * from jc_country_struct where area_id like '02___0000000' получаем код областей

select * from jc_country_struct where area_id like '02___0000000' and area_id <> '020000000000' получаем только области
select * from jc_country_struct where area_id like '02001___0000' and area_id <> '020010000000' получаем районы первой области
select * from jc_country_struct where area_id like '02001001____' and area_id <> '020010010000' получаем все поселения
select * from jc_country_struct where area_id like '02002002____' and area_id <> '020020020000' всё для второго района

select * from jc_student_order
inner join jc_register_office on jc_register_office.r_office_id = jc_student_order.register_office_id
where student_order_status = 0 order by student_order_date
склеиваем две таблицы при этом колонки id дублируются

select * from jc_student_order so
inner join jc_register_office ro on ro.r_office_id = so.register_office_id
where student_order_status = 0 order by student_order_date
более лаконичный вариант обозвали таблицы сокращённо


select ro.r_office_area_id, ro.r_office_name, so.* from jc_student_order so
inner join jc_register_office ro on ro.r_office_id = so.register_office_id
where student_order_status = 0 order by student_order_date
вытаскиваем все колонки из Ордера и только указанные колонки из регистера

update jc_student_order set register_office_id = 2 where student_order_id in (1,3,5,7)
добавляем 2 ЗАГС в студентов с id 1,3,5,7

select so.* , ro.r_office_area_id, ro.r_office_name,
po_h.p_office_area_id as h_p_office_area_id, po_h.p_office_name as h_p_office_name,
po_w.p_office_area_id as w_p_office_area_id, po_w.p_office_name as w_p_office_name
from jc_student_order so
inner join jc_register_office ro on ro.r_office_id = so.register_office_id
inner join jc_passport_office po_h on po_h.p_office_id = so.h_passport_office_id
inner join jc_passport_office po_w on po_w.p_office_id = so.w_passport_office_id
where student_order_status = 0 order by student_order_date
полдключаем две таблицы под видом двух разных множеств при этом столбцы переименовываем так как нам надо


SELECT soc.*, ro.r_office_area_id, ro.r_office_name
FROM jc_student_child soc
INNER JOIN jc_register_office ro on ro.r_office_id = soc.c_register_office_id
WHERE student_order_id IN (1,2,3)
ORDER BY student_order_id
прикрутили к детям таблицу регистров и сузили круг поиска по конкретным student_order_id

select so.* , ro.r_office_area_id, ro.r_office_name,
po_h.p_office_area_id as h_p_office_area_id, po_h.p_office_name as h_p_office_name,
po_w.p_office_area_id as w_p_office_area_id, po_w.p_office_name as w_p_office_name,
soc.*, ro_c.r_office_area_id, ro_c.r_office_name
from jc_student_order so
inner join jc_register_office ro on ro.r_office_id = so.register_office_id
inner join jc_passport_office po_h on po_h.p_office_id = so.h_passport_office_id
inner join jc_passport_office po_w on po_w.p_office_id = so.w_passport_office_id
INNER JOIN jc_student_child soc on soc.student_order_id = so.student_order_id
inner join jc_register_office ro_c on ro_c.r_office_id = soc.c_register_office_id
where student_order_status = 0 order by student_order_date
получаем все необходимые данные с помощью одного большогно запроса

CREATE INDEX idx_student_order_status ON jc_student_order(student_order_states)
CREATE INDEX
создаю индекс для таблицы student_order который делает выборку по статусу запроса

самый простой вариант правильной выборки индекса - это обращать внимание на условия
которые нам необходимы и под них уже смотреть нужен ли мне индекс под одно поле или под два
так как условие WHERE может содерж 2 и более поля

CREATE INDEX idx_student_order_status ON jc_student_order(student_order_status);
	CREATE INDEX idx_student_order_id ON jc_student_child(student_order_id);
	для более быстрой выборки детей под определённую заявку
