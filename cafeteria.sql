create database cafeteria;

use cafeteria;

create table empleados
(
	NumeroEmpleado varchar(10) unique,
    Nombre varchar(20),
    PrimerApellido varchar(15),
    SegundoApellido varchar(15),
    Sexo varchar (10),
    Telefono int,
    Correo varchar(50),
    Cargo varchar(15),
    Contraseña varchar(15)
);

create table menu
(
	Idplatillo	varchar(10) unique,
    NombrePlatillo varchar(30),
    Precio	float
);

create table ventas
(
	TotalVentas float,
    Fecha varchar(10) unique
);

create table ordenes
(
	IdOrden	varchar(10) unique,
    Cliente	varchar(15),
    Platillos text,
    Total	float,
    Fecha	varchar(10),
    Estado	varchar(15)
);


-- Ingreso manual de datos ------------------------------------------------------------------------------------------

INSERT INTO empleados (NumeroEmpleado, Nombre, Cargo, Contraseña)Values("A0","root","Administrador","r3c0p3r1");
