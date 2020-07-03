
package Emergentes;

import BaseDatos.Mysql;
import objetos.Empleado;
import objetos.Orden;
import objetos.Platillo;



public class GenerarId {
    
   private Orden orden = new Orden();
   private Empleado empleado = new Empleado();
   private Platillo plato = new Platillo();
   private Mysql mysql = new Mysql();
   private String letra = "", numero = "";
   private int cont = 0;

    public GenerarId() {
    }
    
    public String generaIdOrden()
    {
        mysql.conectar();
        if(mysql.countOrdenes()>0)
        {
            orden.setIdOrden(mysql.lastOrden());
            mysql.desconectar();
            return aumentaIdOrden(orden.getIdOrden());
        }else
        {
            mysql.desconectar();
            return "OR1";
        }
    }
    
    private String aumentaIdOrden(String plat)
   {
       cont = 0; letra = ""; numero = "";
        for(int i=2; i<plat.length(); i++)
        {
            numero += plat.charAt(i);
        }
        System.out.println(numero);
        cont = Integer.parseInt(numero) + 1;
        letra = "OR" + String.valueOf(cont);
       return letra;
   }

   
   public String generarEmpleado(String cargo)
   {
       if(cargo.equals("Administrador"))
       {
           letra = "A";
           mysql.conectar();
           empleado = mysql.lastEmpl(letra);
           mysql.desconectar();
       }
       else if(cargo.equals("Cajero"))
       {
           letra = "C";
           mysql.conectar();
           if(mysql.lastEmp2(letra))
           {
               empleado = mysql.lastEmpl(letra);
           }
           else
           {
               return letra + "1";
           }
           mysql.desconectar();
       }
       else if(cargo.equals("Chef"))
       {
           letra = "H";
           mysql.conectar();
           if(mysql.lastEmp2(letra))
           {
               empleado = mysql.lastEmpl(letra);
           }
           else
           {
               return letra + "1";
           }
           mysql.desconectar();
           
       }
       else
       {
           return "";
       }
       return aumentaId(empleado, letra);
   }
   
   public String generarIdPlato()
   {
       mysql.conectar();

       if(mysql.countPlatos()>0)
       {
           plato = mysql.lastPlato();
           mysql.desconectar();
           return aumentaIdPlato(plato.getIdPlatillo());
       }
       else
       {
           mysql.desconectar();
           return "P1";
       }
       
   }
   
   private String aumentaId(Empleado emp, String inicial)
   {
       cont = 0; letra = ""; numero = "";
        for(int i=1; i<emp.getNumeroEmpleado().length(); i++)
        {
            numero += emp.getNumeroEmpleado().charAt(i);
        }
        cont = (Integer.parseInt(numero)) + 1;
        letra = inicial + String.valueOf(cont);
       return letra;
   }
   
   private String aumentaIdPlato(String plat)
   {
       cont = 0; letra = ""; numero = "";
        for(int i=1; i<plat.length(); i++)
        {
            numero += plat.charAt(i);
        }
        cont = Integer.parseInt(numero) + 1;
        letra = "P" + String.valueOf(cont);
       return letra;
   }
    
}
