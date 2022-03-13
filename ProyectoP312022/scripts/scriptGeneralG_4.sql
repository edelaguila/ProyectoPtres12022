
CREATE TABLE IF NOT EXISTS aplicaciones (
id_aplicacion int AUTO_INCREMENT,
nombre_aplicacion VARCHAR(50),
estatus_aplicacion VARCHAR(50),
PRIMARY KEY (id_aplicacion)
) ENGINE=InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS perfil_usuario (
id_perfil int AUTO_INCREMENT,
id_usuario VARCHAR(15),
PRIMARY KEY (id_perfil),
FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
