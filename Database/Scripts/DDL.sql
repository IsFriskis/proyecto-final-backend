drop database if exists db_proyectofinal;

create database if not exists db_proyectofinal;

use db_proyectofinal;

create table if not exists t_user(
a_user_id varchar(36) primary key default (UUID()),
a_user_name varchar(15) unique,
a_user_mail varchar(25) unique,
a_user_password varchar (50),
a_user_isBan bool default false
);

create table if not exists t_bans(
a_ban_id integer,
a_ban_description varchar(200),
a_ban_timestart timestamp default now(),
a_ban_timeend timestamp, 
a_ban_review boolean default false,
a_user_id varchar(36),
foreign key (a_user_id) references t_user(a_user_id)
);

create table if not exists t_rol(
a_rol_id integer primary key auto_increment,
a_rol_name varchar(20),
a_rol_description varchar(100)
);

create table if not exists t_permissions(
a_permission_id integer primary key auto_increment,
a_rol_id integer not null,
foreign key (a_rol_id) references t_rol(a_rol_id),
a_user_id varchar(36),
foreign key (a_user_id) references t_user(a_user_id) 
);

create table if not exists t_warnlevel(
a_warnlevel_id integer primary key auto_increment,
a_warnlevel_name varchar(20),
a_warnlevel_description varchar(100)
);

create table if not exists t_warns(
a_warn_id integer primary key auto_increment,
a_warn_title varchar(30),
a_warn_description varchar(200),
a_warnlevel_id integer,
foreign key (a_warnlevel_id) references t_warnlevel(a_warnlevel_id),
a_warn_date timestamp default now(),
a_user_id varchar(36),
foreign key (a_user_id) references t_user(a_user_id)
);

create table if not exists t_match(
a_match_id integer primary key auto_increment,
a_match_score float,
a_match_date timestamp,
a_user_id varchar(36),
foreign key (a_user_id) references t_user(a_user_id)
);