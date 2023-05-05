use db_proyectofinal;

/*Tabla de usuarios*/
insert into user (username, mail, password)
values("Usuario1", "Usuario1@gmail.com", "Abc123..");

insert into user (username, mail, password)
values("Usuario2", "Usuario2@gmail.com", "Abc123..");

insert into user (username, mail, password)
values("Usuario3", "Usuario3@gmail.com", "Abc123..");

/*Tabla de ban*/
insert into ban(title, description, user_id)
values("La lio mucho","Es un cavernicola" , (SELECT id from user where username = "Usuario1"));

/*Tabla de rolees*/
insert into role(name, description)
values("Standard", "Es un role para el 98% de los usuarios");

insert into role(name, description)
values("Moderador", "Puede colocar warns a todos los usuarios");

insert into role(name, description)
values("Administrador", "Es capaz de revisar las peticiones de ban");


/*Tabla de Permissions*/
insert into permission(role_id, user_id)
values (3, (SELECT id from user where username = "Usuario1"));

insert into permission(role_id, user_id)
values (2, (SELECT id from user where username = "Usuario2"));

insert into permission(role_id, user_id)
values (1, (SELECT id from user where username = "Usuario3"));


/*Tabla de niveles de warn*/
insert into warnlevel(name, description)
values("Leve", "Falta leve");

insert into warnlevel(name, description)
values("Media", "Falta de gravedad media");

insert into warnlevel(name, description)
values("Grave", "Falta grave");

/*Tabla de warns*/
insert into warn(title, description, warnlevel_id, user_id)
values("Griefing", "La lió parda", 3, (SELECT id from user where username = "Usuario1"));


/*Tabla de game*/
insert into game(score, user_id)
values (55000, (SELECT id from user where username = "Usuario3"));

insert into game(score, user_id)
values (35000, (SELECT id from user where username = "Usuario3"));

insert into game(score, user_id)
values (25000, (SELECT id from user where username = "Usuario1"));


