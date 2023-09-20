CREATE DATABASE blockbuster;
USE blockbuster;
create table persona(id int primary key auto_increment, nombre varchar(150) not null);
create table pelicula(id int primary key auto_increment, titulo varchar(150) not null, idioma varchar(255)  not null);
-- TIPO 1 ACTOR
-- TIPO 2 PRODUCTOR
-- TIPO 3 CLIENTE
create table actores(id_pelicula int not null, id_persona int not null, primary key(id_pelicula, id_persona), 
constraint is_an_actor check(id_persona = 1));
