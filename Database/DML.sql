use db_proyectofinal;

/*Tabla de usuarios*/
insert into t_user (a_user_name, a_user_mail, a_user_password, a_user_isBan)
values("Usuario1", "Usuario1@gmail.com", "Abc123..", false);

insert into t_user (a_user_name, a_user_mail, a_user_password, a_user_isBan)
values("Usuario2", "Usuario2@gmail.com", "Abc123..", false);

insert into t_user (a_user_name, a_user_mail, a_user_password, a_user_isBan)
values("Usuario3", "Usuario3@gmail.com", "Abc123..", true);

/*Tabla de Permissions*/
insert into t_permissions(a_permission_role, a_user_id)
values ("Administrador", 1);

insert into t_permissions(a_permission_role, a_user_id)
values ("Moderador", 2);

insert into t_permissions(a_permission_role, a_user_id)
values ("Standard", 3);


/*Tabla de Match*/
insert into t_match(a_match_score, a_user_id)
values (45000, 2);

insert into t_match(a_match_score, a_user_id)
values (35000, 3);

insert into t_match(a_match_score, a_user_id)
values (25000.54, 1);
