insert into CAR (id, brand, model, mileage, is_damaged, is_available, price_per_day)
values ('PP42069', 'Fiat', 'Multipla', 123456, '0', '1', '150'),
('PO00123', 'Ford', 'Kuga', '20100', '0', '1', '300'),
('PO5553', 'Mazda', '3', '5000', '0', '1', '250'),
('PO9933', 'VW', 'Passat', '12000', '0', '1' , '300'),
('PO4343', 'BMW', '5', '8000', '0', '1', '550');

insert INTO USER (username, password, first_name, last_name, role_id)
values ('user', '$2a$10$LuYcF8ajzSrKybB0MfCv7Ol/ib03tqSH63sEhnVuAvqESdIATD7Hy', 'Imie', 'Nazwisko', 1),
('superUser', '$2a$10$LuYcF8ajzSrKybB0MfCv7Ol/ib03tqSH63sEhnVuAvqESdIATD7Hy', 'Imie1', 'Nazwisko1', 2);

/* password: password */

commit;
