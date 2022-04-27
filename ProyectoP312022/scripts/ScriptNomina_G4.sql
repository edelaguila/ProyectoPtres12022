
CREATE SCHEMA IF NOT EXISTS `bdnominas` DEFAULT CHARACTER SET utf8 ;
USE `bdnominas` ;

CREATE TABLE IF NOT EXISTS tbl_empleados (
	empid INT NOT NULL AUTO_INCREMENT,
	emnombre VARCHAR(45) NOT NULL,
        emsueldo Int(10) NOT NULL,
  	emestado VARCHAR(45) NOT NULL,
  	emdias Int(10) NOT NULL,
	PRIMARY KEY (empid) )
ENGINE = InnoDB CHARACTER SET = latin1;

