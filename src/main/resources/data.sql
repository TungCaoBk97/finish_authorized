create table if not exists persistent_logins (
     username varchar(100) not null,
     series varchar(64) primary key,
     token varchar(64) not null,
     last_used timestamp not null
);

delete from  user_role;
delete from  roles;
delete from  users;

INSERT INTO roles (id, username) VALUES
(1, 'ADMIN'),
(2, 'ACTUATOR'),
(3, 'USER');

INSERT INTO users (id, password, username) VALUES
(1, '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS', 'Admin'),
(3, '$2a$10$ByIUiNaRfBKSV6urZoBBxe4UbJ/sS6u1ZaPORHF9AtNWAuVPVz1by', 'User');

insert into user_role(id, user_id, role_id) values
(1, 1,1),
(2, 1,2),
(3, 1,3),
(4, 3,2);