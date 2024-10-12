CREATE DATABASE IF NOT EXISTS bd_mysql;
USE bd_mysql;

CREATE TABLE IF NOT EXISTS empleados (
    dpi VARCHAR(13) PRIMARY KEY,
    primer_nombre VARCHAR(50),
    segundo_nombre VARCHAR(50),
    primer_apellido VARCHAR(50),
    segundo_apellido VARCHAR(50),
    direccion VARCHAR(100),
    telefono_casa VARCHAR(15),
    telefono_movil VARCHAR(15),
    salario_base DECIMAL(10, 2),
    bonificacion DECIMAL(10, 2),
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

SET SQL_SAFE_UPDATES = 0; UPDATE empleados SET fecha_modificacion = NOW(); SET SQL_SAFE_UPDATES = 1;
