insert into users (id, document_number, email, name, password, role_id)
values (default, '1234567890', 'admin@gmail.com', 'admin', '$2a$10$dVsbSNcBA3w50V9YNSD4SOkDemzexqYvDIcr44enjCNK5aPaTY2AW', 1);

INSERT INTO role (id, description, name)
VALUES (1, 'ROLE_ADMIN', 'ADMIN');

INSERT INTO role (id, description, name)
VALUES (2, 'ROLE_USER', 'USER');
