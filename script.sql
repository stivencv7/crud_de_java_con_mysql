create database jva;
use jva;

create table administrador
(codigo int primary key auto_increment not null,
nombre varchar(70),
correo varchar(225),
contraseña varchar(225)
);