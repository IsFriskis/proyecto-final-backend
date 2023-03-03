drop database if exists db_proyectofinal;

create database if not exists db_proyectofinal;

use db_proyectofinal;

create table if not exists t_user(
a_user_id integer primary key auto_increment,
a_user_name varchar(15) unique,
a_user_mail varchar(25) unique,
a_user_password varchar (50),
a_user_isBan bool default false
);

create table if not exists t_permissions(
a_permission_id integer primary key auto_increment,
a_permission_role enum("Standard", "Moderador", "Administrador"),
a_user_id integer,
foreign key (a_user_id) references t_user(a_user_id)
);

create table if not exists t_warns(
a_warn_id integer primary key auto_increment,
a_warn_title varchar(30),
a_warn_description varchar(200),
a_warn_type enum("Leve", "Medio", "Grave"),
a_user_id integer,
foreign key (a_user_id) references t_user(a_user_id)
);

create table if not exists t_match(
a_match_id integer primary key auto_increment,
a_match_score float,
a_user_id integer,
foreign key (a_user_id) references t_user(a_user_id)
);