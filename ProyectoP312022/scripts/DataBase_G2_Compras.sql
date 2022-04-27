CREATE SCHEMA IF NOT EXISTS `bdprueba78` DEFAULT CHARACTER SET utf8 ;

USE `bdprueba78` ;

CREATE TABLE IF NOT EXISTS tbl_proveedor(
    provid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    provnombre VARCHAR(45) NOT NULL,
    provsaldo INT (10) NOT NULL,
    provestado VARCHAR(1)  NOT NULL,
    provtelefono VARCHAR(10) NOT NULL,
    provdireccion VARCHAR(16) NOT NULL   
    )ENGINE = InnoDB CHARACTER SET = latin1;
    
CREATE TABLE IF NOT EXISTS tbl_producto(
    prodid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    provid INT NOT NULL,
    prodnombre VARCHAR(16) NOT NULL,
    prodmarca VARCHAR(16) NOT NULL,
    prodprecio INT (11) NOT NULL,
    Prodlinea VARCHAR(16) NOT NULL,
    prodexistencia VARCHAR(16) NOT NULL,
    FOREIGN KEY (provid) REFERENCES tbl_proveedor(provid)
    
	)ENGINE = INNODB CHARACTER SET = latin1;
      
   CREATE TABLE IF NOT EXISTS tbl_ordecompraencabezado(
       ordid INT NOT NULL AUTO_INCREMENT,
       ordfecha DATE NOT NULL,
       provid INT NOT NULL,
       
       PRIMARY KEY(ordid),
       FOREIGN KEY (provid) REFERENCES tbl_producto(provid)
       
    )ENGINE = InnoDB CHARACTER SET = latin1;
    
    
    CREATE TABLE IF NOT EXISTS tbl_ordecompradetalle(
    ordid INT NOT NULL,
    prodid INT NOT NULL,
    ordcantidad INT (11) NOT NULL,    
    ordcosto INT(11) NOT NULL,
    PRIMARY KEY(prodid,ordcantidad,ordcosto),
    FOREIGN KEY (ordid) REFERENCES tbl_ordecompraencabezado(ordid),     
    FOREIGN KEY (prodid) REFERENCES tbl_producto(prodid)   
    )ENGINE = InnoDB CHARACTER SET = latin1;
    
    
    
  CREATE TABLE IF NOT EXISTS tbl_compraencabezado(
         comid INT NOT NULL AUTO_INCREMENT,
         comserie INT(11) NOT NULL,
         comfechaemi DATE NOT NULL,
         comfechavenci DATE NOT NULL,
         provid INT NOT NULL,
         ordid INT NOT NULL,
      
      PRIMARY KEY(comid,comserie),
      FOREIGN KEY (provid) REFERENCES tbl_ordecompraencabezado(provid),
      FOREIGN KEY (ordid) REFERENCES tbl_ordecompraencabezado(ordid)
  )ENGINE = InnoDB CHARACTER SET = latin1; 
  
  
  
  
  
    CREATE TABLE IF NOT EXISTS tbl_compradetalle(
         comid INT NOT NULL,
         comserie INT NOT NULL,
         prodid INT NOT NULL,
         ordcantidad INT NOT NULL,
         ordcosto INT NOT NULL,
         bodid INT NOT NULL,
         FOREIGN KEY (comid,comserie) REFERENCES tbl_compraencabezado(comid,comserie),
       FOREIGN KEY (prodid,ordcantidad,ordcosto) REFERENCES tbl_ordecompradetalle(prodid,ordcantidad,ordcosto)
         
         
        
         
  )ENGINE = InnoDB CHARACTER SET = latin1;
 
      CREATE TABLE IF NOT EXISTS  tbl_concepto(
 	conid INT NOT NULL AUTO_INCREMENT,
    connombre VARCHAR(16) NOT NULL,
    conefecto VARCHAR(1) NOT NULL,
    conestatus VARCHAR(1) NOT NULL,
   PRIMARY KEY (conid)
        
	)ENGINE = INNODB CHARACTER SET = latin1;
    
 CREATE TABLE IF NOT EXISTS tbl_cuentasporpagar(
     
     conid INT NOT NULL,
     cuentadoc INT(11) NOT NULL,
     cuentaslado INT(11) NOT NULL,
     cuentfechaemi DATE NOT NULL,
     cuentfechavenci DATE NOT NULL,
     cuentavalor INT(11) NOT NULL,
     cuentareferencia INT (11) NOT NULL,
     provid INT NOT NULL,

     
     FOREIGN KEY (conid) REFERENCES tbl_concepto(conid),
     FOREIGN KEY (provid) REFERENCES tbl_compraencabezado(provid)
    )ENGINE = InnoDB CHARACTER SET = latin1;