DROP TABLE usuario;

CREATE TABLE usuario(
	id INTEGER NOT NULL GENERATED ALWAYS AS 
		IDENTITY (START WITH 1, INCREMENT BY 1),
	nombre VARCHAR(50),
	clave VARCHAR(20),
	PRIMARY KEY (id)
);

INSERT INTO usuario(nombre, clave) VALUES('juan', '123');
INSERT INTO usuario(nombre, clave) VALUES('maria', '456');

SELECT * FROM usuario;