insert into CAR (ID, BRAND, MODEL, MILEAGE, DAMAGED, AVAILABLE, PRICE_PER_DAY, EXIST)
values ('PP42069', 'Fiat', 'Multipla', 123456, 0, 1, 150, 1),
('PO00123', 'Ford', 'Kuga', 20100, 0,1, 300, 1),
('PO5553', 'Mazda', '3', 5000, 0, 1, 250, 1),
('PO9933', 'VW', 'Passat', 12000, 0, 0 , 300, 1),
('PO4343', 'BMW', '5', 8000, 0, 0, 550, 1);

insert into CLIENT (id, name, last_name, date_of_birth)
values ('90101012345', 'Lukasz', 'Tararynowicz', '1990-10-10'),
('87122512345', 'Kazmierz', 'Nowak', '1987-12-25'),
('92050812345', 'Koteł', 'Pieseł', '1992-05-08'),
('69042012345', 'Krzysztof', 'Kups', '1969-04-20'),
('94070712345', 'Krystyna', 'Czubowna', '1994-07-07'),
('90022812345', 'Jeżuś', 'Chytrus', '1990-02-28');

insert into RENTAL (id, car_id, client_id, date_of_rental,
                    date_of_return, mileage, damaged,
                    active, deposit, total_price)
values
(nextval('rent_seq'), 'PP42069', '87122512345', '2019-01-20', '2019-01-22', 120, 0, 0, 100, 300),
(nextval('rent_seq'),'PP42069', '69042012345', '2019-02-05', '2019-02-10', 300, 0, 0, 250, 750),
(nextval('rent_seq'),'PO00123', '90101012345', '2019-03-17', '2019-03-20', 500, 0, 0, 300, 900),
(nextval('rent_seq'),'PO5553', '92050812345', '2019-08-20', '2019-08-27', 700, 0, 0, 400, 1750),
(nextval('rent_seq'),'PO9933', '94070712345', '2019-09-07', '2019-09-10', 0, 0, 1, 300, 900),
(nextval('rent_seq'),'PO4343', '90022812345', '2019-09-06', '2019-09-12', 0, 0, 1, 1000, 3300);


insert into ROLE (id, authority) values (nextval('role_seq'), 'USER');
insert into ROLE (id, authority) values (nextval('role_seq'), 'ADMIN');

insert INTO USER (username, password, first_name, last_name, role_id)
values ('user', '$2a$10$LuYcF8ajzSrKybB0MfCv7Ol/ib03tqSH63sEhnVuAvqESdIATD7Hy', 'Imie', 'Nazwisko', 1),
('admin', '$2a$10$LuYcF8ajzSrKybB0MfCv7Ol/ib03tqSH63sEhnVuAvqESdIATD7Hy', 'Imie1', 'Nazwisko1', 2);
