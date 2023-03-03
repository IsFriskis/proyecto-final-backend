use db_proyectofinal;

/*Tabla de usuarios*/
insert into t_user (a_user_name, a_user_mail, a_user_password)
values("Usuario1", "Usuario1@gmail.com", "Abc123..");

insert into t_user (a_user_name, a_user_mail, a_user_password)
values("Usuario2", "Usuario2@gmail.com", "Abc123..");

insert into t_user (a_user_name, a_user_mail, a_user_password)
values("Usuario3", "Usuario3@gmail.com", "Abc123..");



/*Tabla de roles*/
insert into t_rol(a_rol_name, a_rol_description)
values("Standard", "Es un rol para el 98% de los usuarios");

insert into t_rol(a_rol_name, a_rol_description)
values("Moderador", "Puede colocar warns a todos los usuarios");

insert into t_rol(a_rol_name, a_rol_description)
values("Administrador", "Es capaz de revisar las peticiones de ban");

/*Tabla de niveles de warn*/
insert into t_warnlevel(a_warnlevel_name, a_warnlevel_description)
values("Leve", "Falta leve");

insert into t_warnlevel(a_warnlevel_name, a_warnlevel_description)
values("Media", "Falta de gravedad media");

insert into t_warnlevel(a_warnlevel_name, a_warnlevel_description)
values("Grave", "Falta grave");

/*Tabla de Permissions*/
insert into t_permissions(a_rol_id, a_user_id)
values (3, (SELECT a_user_id from t_user where a_user_name = "Usuario1"));

insert into t_permissions(a_rol_id, a_user_id)
values (2, (SELECT a_user_id from t_user where a_user_name = "Usuario2"));

insert into t_permissions(a_rol_id, a_user_id)
values (1, (SELECT a_user_id from t_user where a_user_name = "Usuario3"));

/*Tabla de Match*/
insert into t_match(a_match_score, a_user_id)
values (45000, (SELECT a_user_id from t_user where a_user_name = "Usuario2"));

insert into t_match(a_match_score, a_user_id)
values (35000, (SELECT a_user_id from t_user where a_user_name = "Usuario3"));

insert into t_match(a_match_score, a_user_id)
values (25000.54, (SELECT a_user_id from t_user where a_user_name = "Usuario1"));

/*Tabla de bans*/
insert into t_bans(a_ban_description, a_user_id)
values("La lió el perro" , (SELECT a_user_id from t_user where a_user_name = "Usuario1"));

/*Tabla de warns*/
insert into t_warns(a_warn_title, a_warn_description, a_warnlevel_id, a_user_id)
values("Griefing", "La lió parda", 3, (SELECT a_user_id from t_user where a_user_name = "Usuario1"));
