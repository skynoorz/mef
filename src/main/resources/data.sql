INSERT INTO role(id, name) VALUES (1, 'ROLE_USER');
INSERT INTO role(id, name) VALUES (2, 'ROLE_ADMIN');
INSERT INTO usuario(id, username, password, enabled) VALUES (1, 'user', '$2a$12$yM7xkbGvXsooJH8kDheUA.W3oqsB8Whib3UuKx.vsy0rWDU9E30Ye', false); -- password es password
INSERT INTO usuario(id, username, password, enabled) VALUES (2, 'admin', '$2a$12$jtV/5kJQW5sKFNM4bUazKOUxhtSPc2i.ozKBfOhDFeZmgU8pUJgh.', false); -- password es password
INSERT INTO usuario_roles(usuario_id, roles_id) VALUES (1, 1); -- user es USER
INSERT INTO usuario_roles(usuario_id, roles_id) VALUES (2, 2); -- admin es ADMIN

INSERT INTO Tramite (codigo, nombre, numero_comprobante, resumen, monto, fecha_conclusion, vinculo_documento_digital) VALUES
('20', 'MINISTERIO DE PREVISION SOCIAL Y SALUD PUBLICA', '4', 'PAGO PENSION VITALICIA BENEMERITOS DICIEMBRE/91', 3097281.00, '1992-01-02', 'https://drive.google.com/file/d/10ZVMEO6YfntBxwwGVolPzH5kTXRTuCKb/view?usp=share_link'),
('20', 'MINISTERIO DE PREVISION SOCIAL Y SALUD PUBLICA', '5', 'PAGO PENSION VITALICIA BENEMERITOS DICIEMBRE/91', 5851838.00, '1992-01-02', 'https://drive.google.com/file/d/1tpsbHVIsM3cKlItYcI1NxXC4y7rOKEpX/view?usp=share_link'),
('15', 'MINISTERIO DE FINANZAS', '6', 'PAGO HORAS EXTRAS PERSONAL SUBSECRETARIAS Y DIRECCIONES NOVIEMBRE/91', 8716.93, '1992-01-03', 'https://drive.google.com/file/d/1qDah2wghjGI6u2aR-l2D_gPozOHnJbWG/view?usp=share_link'),
('15', 'MINISTERIO DE FINANZAS', '7', 'PAGO HORAS EXTRAS PERSONAL DIRECCION ADMINISTRATIVA DICIEMBRE/91', 9936.65, '1992-01-03', 'https://drive.google.com/file/d/1L9ddAh4eMhZl57py3yOY9aKOYY3pVk3r/view?usp=share_link'),
('15', 'MINISTERIO DE FINANZAS', '8', 'PAGO HORAS EXTRAS PERSONAL CAJA DEL TESORO GENERAL DE LA NACION DICIEMBRE/91', 5951.85, '1992-01-03', 'https://drive.google.com/file/d/1qpWXnXaEkjFZQe6x4yX08aKnNtn4tD12/view?usp=share_link'),
('15', 'MINISTERIO DE FINANZAS', '9', 'PAGO HORAS EXTRAS PERSONAL DIRECCION DE PROGRAMACION Y CONTROL FINANCIERO DICIEMBRE/91', 9156.99, '1992-01-03', 'https://drive.google.com/file/d/1q6pbBVORDYWTgqgX8YJPAmVhSLouvPWB/view?usp=share_link'),
('15', 'MINISTERIO DE FINANZAS', '11', 'PAGO HORAS EXTRAS PERSONAL DIRECCION DE PRESUPUESTO DICIEMBRE/91', 114400.27, '1992-01-03', 'https://drive.google.com/file/d/1L0K3cyxe8Ter5aHlvf1bhiv0x-v2JimI/view?usp=share_link');
