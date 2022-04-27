
CREATE SCHEMA IF NOT EXISTS `bdnominas` DEFAULT CHARACTER SET utf8 ;
USE `bdnominas` ;

CREATE TABLE IF NOT EXISTS tbl_empleados (
	empid INT NOT NULL AUTO_INCREMENT,
	emnombre VARCHAR(45) NOT NULL,
	emcargo VARCHAR(45) NOT NULL,
    emdepartamento VARCHAR(45) NOT NULL,
    emsueldo Int(10) NOT NULL,
	PRIMARY KEY (empid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_tiempo (
	tiemid INT NOT NULL AUTO_INCREMENT,
    tiemfechaingreso DATE,
    tiemfechafinal DATE,
	PRIMARY KEY (tiemid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_percepciones (
	percepid INT NOT NULL AUTO_INCREMENT,
	percepmonto int (45) NOT NULL,
	percepviatico int(45) NOT NULL,
	PRIMARY KEY (percepid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_deducciones (
	deducid INT NOT NULL AUTO_INCREMENT,
	deducmonto int (45) NOT NULL,
	PRIMARY KEY (deducid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_nomina (
	empid INT NOT NULL AUTO_INCREMENT,
	emnombre VARCHAR(45) NOT NULL,
	emcargo VARCHAR(45) NOT NULL,
   	emdepartamento VARCHAR(45) NOT NULL,
   	emsueldo Int(10) NOT NULL,
	empercepciones Int(10) NOT NULL,
	emdeducciones Int(10) NOT NULL,
	PRIMARY KEY (empid) )
ENGINE = InnoDB CHARACTER SET = latin1;