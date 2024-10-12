CREATE DATABASE bdpos;

\c bdpos; -- Cambia a la base de datos recien creada

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
    fecha_modificacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Crear trigger para actualizar fecha_modificacion en cambios
CREATE OR REPLACE FUNCTION actualizar_fecha_modificacion() 
RETURNS TRIGGER AS $$
BEGIN
    NEW.fecha_modificacion = CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER actualizar_modificacion
BEFORE UPDATE ON empleados
FOR EACH ROW EXECUTE FUNCTION actualizar_fecha_modificacion();

