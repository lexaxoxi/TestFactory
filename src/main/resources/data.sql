create table employee (department_id bigint, id bigint not null, profession_id bigint, fio varchar(255), note varchar(255), primary key (id));
create table profession (id bigint generated by default as identity, note varchar(255), title varchar(255), primary key (id));
create table department (id bigint generated by default as identity, parent_id bigint, note varchar(255), title varchar(255), primary key (id));

insert into employee (department_id,id, profession_id, fio, note)
values (2,1,1, 'Давыдов Клим Наумович', 'быстрый');
insert into employee(department_id,id, profession_id, fio, note)
values (2,2,5, 'Уварова Кара Дмитриевна', 'аккуратная');
insert into employee (department_id,id, profession_id, fio, note)
values (4,3,3, 'Лихачёв Арсений Лукьянович', 'усидчивый');
insert into employee (department_id,id, profession_id, fio, note)
values (5,4,2, 'Морозова Эллада Якуновна', 'ответственная');
insert into employee (department_id,id, profession_id, fio, note)
values (3,5,4, 'Семёнов Степан Платонович', 'дисциплинированный');
insert into employee (department_id,id, profession_id, fio, note)
values (7,6,2, 'Ширяева Янина Павловна', 'уволим скоро');

insert into profession (id, note, title) values (1, 'Быстро ездить', 'Водитель');
insert into profession (id, note, title) values (2, 'Лучший на свете', 'Директор');
insert into profession (id, note, title) values (3, 'Чисто чистить', 'Уборщик');
insert into profession (id, note, title) values (4, 'Знать телефоны наизусть', 'Секретарь');
insert into profession (id, note, title) values (5,  'Трудовой кодекс знать', 'Отдел кадров');

insert into department (id, parent_id, note, title) values (1, null, 'Обслуживание здания', 'ТехПерсонал');
insert into department (id, parent_id, note, title) values (2, 1, 'машины', 'Гараж');
insert into department (id, parent_id, note, title) values (3, 1, 'уборка',  'Технички');
insert into department (id, parent_id, note, title) values (4, 5, 'считают', 'ПТО');
insert into department (id, parent_id, note, title) values (5, null, 'считают и чертят', 'ИТР');
insert into department (id, parent_id, note, title) values (6, null, 'изготавливают', 'Цех');
insert into department (id, parent_id, note, title) values (7, null, 'Главные', 'Руководство');