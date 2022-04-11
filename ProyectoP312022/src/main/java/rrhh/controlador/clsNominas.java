/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.controlador;

import seguridad.controlador.*;

/**
 *
 * @author visitante
 */
public class clsNominas {
   int nomid;
   String nomnombre;
   String nomcargo; 
   String nomdepartamento;
   String nompercepciones;
   String nomdeduciones;
   String nomdialaborados;   
   String nombre; 
   String cargo; 
   String departamento; 
   String percepciones;
   String deducciones; 
   String díaslaborados;

    public clsNominas() {
    }

    public clsNominas(int nomid) {
        this.nomid= nomid;
    }

    
    public clsNominas(String nombre, String cargo) {
        this.nomnombre = nombre;
        this.nomcargo = cargo;
    }
    public clsNominas(int nomid,String nombre, String cargo) {
         this.nomid= nomid;
         this.nomnombre = nombre;
         this.nomcargo = cargo;
    }

    public int getnomid() {
        return nomid;
    }

    public void setnomid(int nomid) {
        this.nomid = nomid;
    }

    public String getNombre() {     
        return nomnombre;
    }

    public void setNombre(String nombre) {
        this.nomnombre = nombre;
    }

    public String getcargo() {
        return nomcargo;
    }

    public void setcargo(String cargo) {
        this.nomcargo = cargo;
    }
     public String getdepartamento(){
        return nomdepartamento;        
    }
      public void setdepartamento(){
        this.nomdepartamento = departamento;
    }
      public String getpercepciones(){
          return nompercepciones;
      }
      public void setpercepciones() {
       this.nompercepciones = percepciones;
      }
      public String getdeduciones(){
          return nomdeduciones;
      }
      public void setdeduciones() {
       this.nomdeduciones= deducciones;
      }
      public String getdiaslaborados(){
          return nomdialaborados;
      }
      public void setdiaslaborados() {
       this.nomdialaborados= díaslaborados;
      }    
     
        
    
    
    @Override
    public String toString() {
        return "tbl_nomina{" + "nomid=" + nomid + ", nomnombre=" + nomnombre + ", nomcargo=" + nomcargo + ",nomdepartamento=" + nomdepartamento + ",nompercepciones=" + nompercepciones + ",nomdeduciones=" +nomdeduciones + ",nomdialaborados=" + nomdialaborados+ '}';
    }
    
}
