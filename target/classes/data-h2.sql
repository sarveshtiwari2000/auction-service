INSERT INTO USER (id, balance, email, name, password, penalty, surname, username) VALUES (1, 100, 'email', 'name', 'password', 200, 'surname', 'username');
INSERT INTO USER (id, balance, email, name, password, penalty, surname, username) VALUES (2, 200, 'email', 'name', 'password', 300, 'surname', 'username');
INSERT INTO ITEM (id, buyer_id, description, end_date, name, price, seller_id, topic) VALUES (1, 2, 'description', 'end_date', 'name', 300, 1, 'topic');
INSERT INTO PURCHASE (id, buyer_id, description, end_date, name, price, purchase_date, seller_id, status, topic) VALUES (1, 2, 'description', 'end_date', 'name', 2 ,'purchase_date', 1,'status', 'topic');
INSERT INTO RESULT (id, date_time, description, from_whom_id, to_whom_id) VALUES (1, 'date_time', 'description', 1, 2);