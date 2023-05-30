use db_proyectofinal;


/*Tabla de usuarios*/

INSERT INTO user (username, mail, password) 
VALUES  ("JCarril", "JCarril@gmail.com", "$2a$10$RHINPxdqSNpqH7zIvvxXzejLvPeZ3EkwP4PdUWvfhTPGbbCZp089i"),
("SdeSeijas", "SdeSeijas@gmail.com", "$2a$10$RHINPxdqSNpqH7zIvvxXzejLvPeZ3EkwP4PdUWvfhTPGbbCZp089i"),
("Friskis", "Friskis@gmail.com", "$2a$10$RHINPxdqSNpqH7zIvvxXzejLvPeZ3EkwP4PdUWvfhTPGbbCZp089i"),
("GengarXz", "GengarXz@gmail.com", "$2a$10$RHINPxdqSNpqH7zIvvxXzejLvPeZ3EkwP4PdUWvfhTPGbbCZp089i"),
("Ypablosv5Y", "Ypablosv5Y@gmail.com", "$2a$10$RHINPxdqSNpqH7zIvvxXzejLvPeZ3EkwP4PdUWvfhTPGbbCZp089i"),
("Juan", "Juan@gmail.com", "$2a$10$RHINPxdqSNpqH7zIvvxXzejLvPeZ3EkwP4PdUWvfhTPGbbCZp089i"),
("Pedro", "Pedro@gmail.com", "$2a$10$RHINPxdqSNpqH7zIvvxXzejLvPeZ3EkwP4PdUWvfhTPGbbCZp089i"),
("María", "Maria@gmail.com", "$2a$10$RHINPxdqSNpqH7zIvvxXzejLvPeZ3EkwP4PdUWvfhTPGbbCZp089i")
;
 

/*Tabla de ban*/
insert into ban(title, description, user_id)
values("La lio mucho","Es un cavernicola" , (SELECT id from user where username = "JCarril"));

/*Tabla de rolees*/
insert into role(name, description)
values("Standard", "Es un role para el 98% de los usuarios"),
("Moderador", "Puede colocar warns a todos los usuarios"),
("Administrador", "Es capaz de revisar las peticiones de ban")
;


/*Tabla de Permissions*/
insert into permission(role_id, user_id)
values (3, (SELECT id from user where username = "JCarril")),
(2, (SELECT id from user where username = "SdeSeijas")),
(1, (SELECT id from user where username = "Friskis")),
(1, (SELECT id from user where username = "GengarXz")),
(1, (SELECT id from user where username = "Ypablosv5Y")),
(1, (SELECT id from user where username = "Juan")), 
(1, (SELECT id from user where username = "Pedro")), 
(1, (SELECT id from user where username = "María"))
;

/*Tabla de niveles de warn*/
insert into warnlevel(name, description)
values("Leve", "Falta leve"),
("Media", "Falta de gravedad media"),
("Grave", "Falta grave")
;

/*Tabla de warns*/
insert into warn(title, description, warnlevel_id, user_id)
values("Griefing", "La lió parda", 3, (SELECT id from user where username = "JCarril"));

/*Tabla de game*/
INSERT INTO game (score, user_id) VALUES 
(100 + RAND() * 100000, (SELECT id from user where username = "SdeSeijas")),
(100 + RAND() * 100000, (SELECT id from user where username = "SdeSeijas")),
(100 + RAND() * 100000, (SELECT id from user where username = "Friskis")),
(100 + RAND() * 100000, (SELECT id from user where username = "JCarril")),
(100 + RAND() * 100000, (SELECT id from user where username = "Ypablosv5Y")),
(100 + RAND() * 100000, (SELECT id from user where username = "Ypablosv5Y")),
(100 + RAND() * 100000, (SELECT id from user where username = "Juan")),
(100 + RAND() * 100000, (SELECT id from user where username = "Pedro")),
(100 + RAND() * 100000, (SELECT id from user where username = "María")), 
(100 + RAND() * 100000, (SELECT id from user where username = "Ypablosv5Y")),
(100 + RAND() * 100000, (SELECT id from user where username = "Juan")), 
(100 + RAND() * 100000, (SELECT id from user where username = "Pedro")), 
(100 + RAND() * 100000, (SELECT id from user where username = "María"));