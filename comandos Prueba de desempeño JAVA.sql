CREATE DATABASE riwi_empleos;
USE riwi_empleos;

CREATE TABLE coder(
id int primary key auto_increment,
nombre varchar(255) not  null,
apellido varchar(255) not null,
 documento varchar(11) not null unique,
 cohorte int not null,
 cv text
);


CREATE TABLE empresa(
id int primary key auto_increment,
nombre varchar(255) not  null,
sector varchar(255) not null,
ubicacion varchar(255) not null,
 contacto varchar(11) not null
);

CREATE table vacante(
id int AUTO_INCREMENT PRIMARY KEY,
fk_id_empresa INT not null,
titulo varchar(255) not null,
descripcion text not null,
duracion varchar(255) not null,
estado varchar(50) not null CHECK(estado IN("ACTIVO","INACTIVO")),
constraint fk_vacnate_empresa foreign key  (fk_id_empresa) references empresa (id) ON DELETE CASCADE
);

CREATE table contratacion(
id int AUTO_INCREMENT PRIMARY KEY,
fk_id_vacante int not null,
fk_id_coder int not null,
fecha_aplicacion timestamp default current_timestamp not null,
estado varchar(50) not null CHECK(estado IN("ACTIVO","INACTIVO")),
salario decimal(10,2),
constraint fk_contratacion_cacante foreign key (fk_id_vacante) references vacante(id) ON DELETE CASCADE,
constraint fk_contratacion_coder foreign key (fk_id_coder) references coder(id) ON DELETE CASCADE
);

alter table vacante ADD COLUMN tecnologia varchar(255) not null;

alter table coder 
ADD COLUMN clan varchar(50) NOT NULL  check (clan IN ("LOVELACE", "META", "VAN ROSUM", "LINUX", "JOB", "DARWINGLACE")); 

alter table vacante ADD COLUMN titulo varchar(255) not null;

alter table coder ADD COLUMN cohorte int not null;

drop table contratacion;

select * from coder;