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

INSERT INTO empleados (NumeroEmpleado, Nombre, PrimerApellido, SegundoApellido, Sexo, Telefono, Correo, Cargo, Contraseña)
Values("A1","Isaac Bicri","Ortiz","Martinez","Masculino",53824520,"isaac.bicri@gmail.com","Administrador","b1cr1");

INSERT INTO menu VALUES("P1","Hot cakes",15);
INSERT INTO menu VALUES("P2","Dona glaseada",7.50);
INSERT INTO menu VALUES("P3","Dona de azucar",5);
INSERT INTO menu VALUES("P4","Café de olla",8);
INSERT INTO menu VALUES("P5","Café capuccino",10);
INSERT INTO menu VALUES("P6","Café de cajeta",10);
INSERT INTO menu VALUES("P7","Pan francés",15);
INSERT INTO menu VALUES("P8","Licuado de nuez",20);
INSERT INTO menu VALUES("P9","Leche",10);
INSERT INTO menu VALUES("P10","Jugo de naranja",15);
INSERT INTO menu VALUES("P11","Sandwich de jamon",10);


select * from menu;


