
CREATE TABLE IF NOT EXISTS aplicaciones (
aplid int AUTO_INCREMENT,
aplNombre VARCHAR(50),
aplEstatus VARCHAR(50),
PRIMARY KEY (aplid)
) ENGINE=InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS perfilUsuario (
perid int AUTO_INCREMENT,
usuid VARCHAR(15),
PRIMARY KEY (perid),
FOREIGN KEY (usuid) REFERENCES usuario (usuid)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
