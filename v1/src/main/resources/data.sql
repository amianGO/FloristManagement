-- Insertar roles si no existen
INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- Insertar usuarios con las contraseñas codificadas
INSERT INTO usuarios (username, password) VALUES ('user1', '$2a$10$.6n1ogoKZFCBBu3LsspTmOk4alLUE0Hgw8EtdBGNVFanawmlcHTJy');
INSERT INTO usuarios (username, password) VALUES ('admin1', '$2a$10$kJrulbwKc0VXC79eBJ7kMuhbRgxkj4kMsdSM3JZ7v4EjVYNAzhL7m');

-- Asociar roles a los usuarios
INSERT INTO usuario_roles (usuario_id, role_id) 
SELECT user_id, rol_id FROM usuarios u
JOIN roles r ON r.name = 'ROLE_USER' WHERE u.username = 'user1';

INSERT INTO usuario_roles (usuario_id, role_id) 
SELECT user_id, rol_id FROM usuarios u
JOIN roles r ON r.name = 'ROLE_ADMIN' WHERE u.username = 'admin1';