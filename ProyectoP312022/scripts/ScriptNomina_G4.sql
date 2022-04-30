
CREATE SCHEMA IF NOT EXISTS `bdnominas` DEFAULT CHARACTER SET utf8 ;
USE `bdnominas` ;

CREATE TABLE IF NOT EXISTS tbl_empleados (
	empid INT NOT NULL AUTO_INCREMENT,
	empnombre VARCHAR(45) NOT NULL,
        empsueldo VARCHAR(40) NOT NULL,
  	empestado VARCHAR(45) NOT NULL,
  	empdias VARCHAR(40) NOT NULL,
	PRIMARY KEY (empid) )
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_departamentos (
	deparid INT NOT NULL AUTO_INCREMENT,
	deparnombre VARCHAR(45) NOT NULL,
        deparestado VARCHAR(40) NOT NULL,
	PRIMARY KEY (deparid))
ENGINE = InnoDB CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS tbl_cargo (
	carid INT NOT NULL AUTO_INCREMENT,
	carnombre VARCHAR(45) NOT NULL,
        carestatus VARCHAR(40) NOT NULL,
	PRIMARY KEY (carid))
ENGINE = InnoDB CHARACTER SET = latin1;


CREATE TABLE IF NOT EXISTS tbl_concepto (
	concepid INT NOT NULL AUTO_INCREMENT,
	concepnombre VARCHAR(45) NOT NULL,
        concepefecto VARCHAR(1) NOT NULL,
	concepestado VARCHAR(4) NOT NULL,
	PRIMARY KEY (concepid))
ENGINE = InnoDB CHARACTER SET = latin1;

