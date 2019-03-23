CREATE DATABASE base_nomina;
USE base_nomina;
CREATE TABLE concepto(
	codigo_concepto INT(10)NOT NULL,
    nombre_concepto VARCHAR(20),
    efecto_concepto VARCHAR(1),
    PRIMARY KEY(codigo_concepto)
)DEFAULT CHARSET=utf8;
CREATE TABLE puestos(
	codigo_puesto INT(10)NOT NULL,
    nombre_puesto VARCHAR(20),
    PRIMARY KEY(codigo_puesto)
)DEFAULT CHARSET=utf8;
CREATE TABLE departamentos(
	codigo_depto INT(10)NOT NULL,
    nombre_depto VARCHAR(20),
    PRIMARY KEY(codigo_depto)
)DEFAULT CHARSET=utf8;
CREATE TABLE empleados(
	codigo_emp INT(10)NOT NULL,
    nombre_emp VARCHAR(20),
    sueldo_emp DOUBLE (10,2),
    codigo_puesto INT(10) NOT NULL,
    codigo_depto INT(10) NOT NULL,
    PRIMARY KEY(codigo_emp),
    CONSTRAINT FK_puestoempleados FOREIGN KEY (codigo_puesto) REFERENCES puestos(codigo_puesto),
    CONSTRAINT FK_departamentosempleados FOREIGN KEY (codigo_depto) REFERENCES departamentos(codigo_depto)
)DEFAULT CHARSET=utf8;
CREATE TABLE usuarios(
	codigo_usuario INT(10)NOT NULL,
    nombre_usuario VARCHAR(20),
    clave_usuario VARCHAR(20),
    estado_usuario BOOLEAN,
    codigo_emp INT(10) NOT NULL,
    PRIMARY KEY(codigo_usuario),
    CONSTRAINT FK_empleadosusuarios FOREIGN KEY (codigo_emp) REFERENCES empleados(codigo_emp)
)DEFAULT CHARSET=utf8;
CREATE TABLE nomina_encabezado(
	codigo_nominal INT(10)NOT NULL,
    fecha_inicial_nominal DATE,
    fecha_final_nominal DATE,
    PRIMARY KEY(codigo_nominal)
)DEFAULT CHARSET=utf8;
CREATE TABLE nomina_detalle(
	codigo_nominal INT(10)NOT NULL,
    codigo_emp INT(10)NOT NULL,
    codigo_concepto INT(10)NOT NULL,
    valor_nominadetalle DOUBLE(10,2),
    PRIMARY KEY(codigo_nominal,codigo_emp,codigo_concepto),
    CONSTRAINT FK_dettalenomina FOREIGN KEY (codigo_nominal) REFERENCES nomina_encabezado(codigo_nominal),
    CONSTRAINT FK_dettaleempleados FOREIGN KEY (codigo_emp) REFERENCES empleados(codigo_emp),
    CONSTRAINT FK_dettaleconcepto FOREIGN KEY (codigo_concepto) REFERENCES concepto(codigo_concepto)
)DEFAULT CHARSET=utf8;