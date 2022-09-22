INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_USER');

INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('admin', 'Admin','a@a', 'rightthere', '0666666666', '$2a$10$BFwCOIynlxC/DOdP1i/vrOZcSJEGZkhrurO7uijU0Ksu55iX3duh6', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Antoine', 'Maffray','am@am.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Eugenie', 'Villaret','ev@ev.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Raoul', 'AmeurMoussa','ram@ram.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Sophia', 'Bracquemart','ev@ev.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Maxime', 'Lafont','ev@ev.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Kamil', 'Bouledine','kb@kb.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Maxime', 'Lafont','ml@ml.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Pierre', 'Perol','ml@ml.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Flora', 'Chevalier','fc@fc.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');
INSERT INTO user (name, firstname, email, address, phone_number, password, register_date) VALUES ('Charles', 'Robert','cr@cr.com', 'rightthere', '0666666666', 'pswd', '2022-09-22');

INSERT INTO users_roles (user_id, role_id) VALUES (1,2)

INSERT INTO game (name, type_calc) VALUES ('Seven Wonders', 1)

INSERT INTO round (match_date, game_id) VALUES ('2022-09-22', 1);

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (0, 2, -6, 10, 0, 43, 0, 0, 12)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (1, 1, 1, 62)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (10, 1, 6, 5, 0, 16, 5, 0, 13)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (1, 2, 2, 56)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (10, 4, 12, 32, 3, 0, 0, 0, 0)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (1, 3, 3, 61)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (3, 5, 12, 12, 3, 1, 9, 0, 0)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (1, 4, 4, 44)


INSERT INTO round (match_date, game_id) VALUES ('2022-09-23', 1);

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (5, 3, 18, 34, 0, 10, 0, 6, 0)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (2, 1, 5, 76)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (7, 3, -5, 11, 0, 18, 17, 0, 0)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (2, 2, 6, 51)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (10, 3, 12, 0, 8, 10, 10, 4, 0)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (2, 3, 7, 57)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (8, 2, -5, 0, 0, 28, 0, 13, 0)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (2, 4, 8, 46)



INSERT INTO round (match_date, game_id) VALUES ('2022-09-24', 1);

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (7, 3, 7, 20, 3, 2, 9, 0, 0)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (3, 1, 9, 51)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (8, 1, -1, 15, 0, 13, 7, 0, 16)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (3, 2, 10, 59)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (10, 3, 1, 18, 0, 31, 0, 0, 5)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (3, 3, 11, 68)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (5, 3, 20, 3, 7, 0, 15, 0, 0)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (3, 4, 12, 58)

INSERT INTO round (match_date, game_id) VALUES ('2022-09-25', 1);

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (7, 1, 5, 4, 0, 31, 18, 0, 6)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (4, 1, 12, 72)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (20, 5, 0, 8, 4, 1, 7, 0, 7)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (4, 2, 13, 52)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (10, 2, 18, 20, 0, 0, 8, 0, 15)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (4, 3, 14, 73)

INSERT INTO nature (wonder, money, war, civilian, business, science, guilds, cities, agora) VALUES (10, 4, 6, 12, 0, 13, 5, 0, 0)
INSERT INTO result (round_id, user_id, nature_id, score) VALUES (4, 4, 15, 50)


INSERT INTO friendship (active, date, friend_id, requester_id) VALUES (1, '2022-09-22', 2, 1)
INSERT INTO friendship (active, date, friend_id, requester_id) VALUES (1, '2022-09-22', 3, 1)

INSERT INTO friendship (active, date, friend_id, requester_id) VALUES (1, '2022-09-22', 2, 4)
INSERT INTO friendship (active, date, friend_id, requester_id) VALUES (1, '2022-09-22', 3, 4)

