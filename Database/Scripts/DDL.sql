drop database if exists db_proyectofinal;

create database if not exists db_proyectofinal;

use db_proyectofinal;

create table if not exists user(
id varchar(36) primary key default (UUID()),
username varchar(15) unique,
mail varchar(25) unique,
password varchar (150)
);

create table if not exists ban(
id integer primary key auto_increment,
title varchar(50),
description varchar(200),
timestart datetime default now(),
timeend datetime default '2000-01-01 01:00:00', 
review boolean default false,
user_id varchar(36) not null unique,
foreign key (user_id) references user(id) on delete cascade
);

create table if not exists role(
id integer primary key auto_increment,
name varchar(20),
description varchar(100)
);

create table if not exists permission(
id integer primary key auto_increment,
role_id integer not null,
foreign key (role_id) references role(id),
user_id varchar(36),
foreign key (user_id) references user(id) on delete cascade
);

create table if not exists warnlevel(
id integer primary key auto_increment,
name varchar(20),
description varchar(100)
);

create table if not exists warn(
id integer primary key auto_increment,
title varchar(30),
description varchar(200),
warnlevel_id integer,
foreign key (warnlevel_id) references warnlevel(id),
date datetime default now(),
user_id varchar(36),
foreign key (user_id) references user(id) on delete cascade
);

create table if not exists game(
id integer primary key auto_increment,
score float,
date datetime default now(),
user_id varchar(36),
foreign key (user_id) references user(id) on delete cascade
);