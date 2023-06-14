INSERT INTO role(id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role(id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO user(id, username, password, enabled) VALUES (1, 'user', '$2a$12$yM7xkbGvXsooJH8kDheUA.W3oqsB8Whib3UuKx.vsy0rWDU9E30Ye', false); -- password es password
INSERT INTO user(id, username, password, enabled) VALUES (2, 'admin', '$2a$12$jtV/5kJQW5sKFNM4bUazKOUxhtSPc2i.ozKBfOhDFeZmgU8pUJgh.', false); -- password es password
INSERT INTO user_roles(user_id, roles_id) VALUES (1, 1); -- user es USER
INSERT INTO user_roles(user_id, roles_id) VALUES (2, 2); -- admin es ADMIN