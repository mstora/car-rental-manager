insert into CAR (ID, BRAND, MODEL, MILEAGE, IS_DAMAGED, IS_AVAILABLE, PRICE_PER_DAY)
values ('PP42069', 'Fiat', 'Multipla', 123456, 0, 1, 150),
('PO00123', 'Ford', 'Kuga', 20100, 0,1, 300),
('PO5553', 'Mazda', '3', 5000, 0, 1, 250),
('PO9933', 'VW', 'Passat', 12000, 0, 1 , 300),
('PO4343', 'BMW', '5', 8000, 0, 1, 550);


insert into CLIENT (id, name, last_name, date_of_birth)
values ('90101012345', 'Lukasz', 'Tararynowicz', 1990-10-10),
('87122512345', 'Kazmierz', 'Nowak', 1987-12-25),
('92050812345', 'Koteł', 'Pieseł', 1992-05-08),
('70012012345', 'Jacek', 'Stachurski', 1970-01-20),
('69042012345', 'Krzysztof', 'Kups', 1969-04-20),
('94070712345', 'Krystyna', 'Czubowna', 1994-07-07),
('80020212345', 'Ewa', 'Ewa', 1980-02-02),
('90022812345', 'Jeżuś', 'Chytrus', 1990-02-28);


insert INTO USER (username, password, first_name, last_name, role_id)
values ('user', '$2a$10$LuYcF8ajzSrKybB0MfCv7Ol/ib03tqSH63sEhnVuAvqESdIATD7Hy', 'Imie', 'Nazwisko', 1),
('superUser', '$2a$10$LuYcF8ajzSrKybB0MfCv7Ol/ib03tqSH63sEhnVuAvqESdIATD7Hy', 'Imie1', 'Nazwisko1', 2);

/* password: password */

commit;
