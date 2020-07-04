
package BaseDatos;

import Emergentes.DosBotones;
import Emergentes.UnBoton;
import com.mysql.jdbc.Connection;
import java.awt.Frame;
import java.awt.Window;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.SwingUtilities;
import objetos.Empleado;
import objetos.Orden;
import objetos.Platillo;

/**
 *
 * @author isaac
 */
public class Mysql {
    
    private int port = 3306;
    private String user = "root";
    private String password = "root01";
    private String host = "localhost";
    private String database = "cafeteria";
    private String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, 3306, database);
    
    private Connection con;
    private PreparedStatement st = null;
    private ResultSet result = null;
    
    private Empleado empleado = new Empleado();
    private Platillo platillo = new Platillo();
    private Orden orden = new Orden();
    private List <Platillo> listaplatilos = new ArrayList<>();
    private List <Empleado> listaEmpleado = new ArrayList<>();
    private List <Orden> listaOrdenes = new ArrayList<>();
    private Calendar calendar = new GregorianCalendar();
    
    
        public boolean conectar() 
        {
            try{
                con = (Connection) DriverManager.getConnection(url, user, password);
                return true;
            }catch(SQLException e)
            {
                System.out.println("Error al conectar \n"+e);
                return false;
            }
        }
        
        public void desconectar()
        {
            try{
                con.close();
            }catch(SQLException ex)
            {
                System.out.println("ERROR AL DESCONECTAR "+ex);
            }
        }
        
        public Orden getFirstOrden(String estado)
        {
            
            try{
                st = con.prepareStatement("select * from ordenes where Estado = '"+estado+"' order by IdOrden ASC Limit 1");
                result = st.executeQuery();
                while(result.next())
                {
                    orden.setIdOrden(result.getString(1));
                    orden.setCliente(result.getString(2));
                    orden.setPlatillos(result.getString(3));
                    orden.setTotal(result.getFloat(4));
                    orden.setFecha(result.getString(5));
                    orden.setEstado(result.getString(6));        
                }
                
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return orden;
        }
        
        public int countFirstOrden(String estado)
        {
            int i = 0;
            try{
                st = con.prepareStatement("select * from ordenes where Estado = '"+estado+"' order by IdOrden ASC Limit 1");
                result = st.executeQuery();
                while(result.next())
                {
                    i++;       
                }
                
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return i;
        }
        
        public boolean iniciar_sesion(String user, String pass)
        {
            conectar();
            try
            {
                st = con.prepareStatement("select * from empleados where NumeroEmpleado = '"+user+"' AND Contraseña = '"+pass+"'");
                result = st.executeQuery();
                
                return result.next();
            }catch(SQLException e)
            {
                System.out.println("Error de existencia "+e);
                return false;
            }
        }
        
        public boolean valida1_usuario(String user)
        {
            conectar();
            try
            {
                st = con.prepareStatement("select * from empleados where NumeroEmpleado = '"+user+"'");
                result = st.executeQuery();
                
                return result.next();
            }catch(SQLException e)
            {
                System.out.println("Error de existencia "+e);
                return false;
            }
        }
        
        public Empleado get1empelado(String user)
        {
            
            try{
                st = con.prepareStatement("select * from empleados where NumeroEmpleado = '"+user+"'");
                result = st.executeQuery();
                while(result.next())
                {
                    empleado.setNumeroEmpleado(result.getString(1));
                    empleado.setNombre(result.getString(2));
                    empleado.setPrimerApellido(result.getString(3));
                    empleado.setSegundoApellido(result.getString(4));
                    empleado.setSexo(result.getString(5));
                    empleado.setTelefono(result.getString(6));
                    empleado.setCorreo(result.getString(7));
                    empleado.setCargo(result.getString(8));
                    empleado.setContraseña(result.getString(9));
                    
                }
                
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return empleado;
        }
        
        public List muestra(String actual)
        {
            listaEmpleado.clear();
            try{
                st = con.prepareStatement("select * from empleados where NumeroEmpleado != '"+actual+"' AND NumeroEmpleado != '"+"A0"+"'");
                result = st.executeQuery();
                while(result.next())
                {
                    listaEmpleado.add(new Empleado(result.getString(1), result.getString(6), result.getString(7),result.getString(8),result.getString(9), result.getString(2), result.getString(3), result.getString(4),result.getString(5)));
                }
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return listaEmpleado;
        }
        
        public List listStatusOrdenes(String condicion)
        {
            listaOrdenes.clear();
            try{
                st = con.prepareStatement("select * from ordenes WHERE Estado = '"+condicion+"'");
                result = st.executeQuery();
                while(result.next())
                {
                    listaOrdenes.add(new Orden(result.getString(1), result.getString(2),result.getString(6)));
                }
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return listaOrdenes;
        }
        
        public List muestraPlatillos()
        {
            listaplatilos.clear();
            try{
                st = con.prepareStatement("select * from menu");
                result = st.executeQuery();
                while(result.next())
                {
                    listaplatilos.add(new Platillo(result.getString(1), result.getString(2), result.getFloat(3)));
                }
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return listaplatilos;
        }
        
        public List muestraPlatillosDinamic(String buscar)
        {
            listaplatilos.clear();
            try{
                st = con.prepareStatement("select * from menu where Idplatillo LIKE '"+buscar+"%' UNION select * from menu where NombrePlatillo LIKE '"+buscar+"%' ");
                result = st.executeQuery();
                while(result.next())
                {
                    listaplatilos.add(new Platillo(result.getString(1), result.getString(2), result.getFloat(3)));
                }
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return listaplatilos;
        }
        
        public List muestraDinamica(String actual, String buscar)
        {
            listaEmpleado.clear();
            try{
                st = con.prepareStatement("select * from empleados where (NumeroEmpleado LIKE '"+buscar+"%' AND NumeroEmpleado != '"+"A0"+"') AND NumeroEmpleado != '"+actual+"' UNION select * from empleados where (Cargo LIKE '"+buscar+"%' AND NumeroEmpleado != '"+"A0"+"') AND NumeroEmpleado != '"+actual+"' UNION select * from empleados where (Nombre LIKE '"+buscar+"%' AND NumeroEmpleado != '"+"A0"+"') AND NumeroEmpleado != '"+actual+"' UNION select * from empleados where (PrimerApellido LIKE '"+buscar+"%' AND NumeroEmpleado != '"+"A0"+"') AND NumeroEmpleado != '"+actual+"' UNION select * from empleados where (SegundoApellido LIKE '"+buscar+"%' AND NumeroEmpleado != '"+"A0"+"') AND NumeroEmpleado != '"+actual+"'");
                result = st.executeQuery();
                while(result.next())
                {
                    listaEmpleado.add(new Empleado(result.getString(1), result.getString(6), result.getString(7),result.getString(8),result.getString(9), result.getString(2), result.getString(3), result.getString(4),result.getString(5)));
                }
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return listaEmpleado;
        }
        
        public Empleado lastEmpl(String inicial)
        {
            
            try{
                st = con.prepareStatement("SELECT * FROM empleados WHERE NumeroEmpleado LIKE '"+inicial+"%' ORDER BY CAST(SUBSTR(NumeroEmpleado,2,LENGTH(NumeroEmpleado))AS UNSIGNED) DESC LIMIT 1");
                result = st.executeQuery();
                while(result.next())
                {
                    empleado.setNumeroEmpleado(result.getString(1));
                    empleado.setNombre(result.getString(2));
                    empleado.setPrimerApellido(result.getString(3));
                    empleado.setSegundoApellido(result.getString(4));
                    empleado.setSexo(result.getString(5));
                    empleado.setTelefono(result.getString(6));
                    empleado.setCorreo(result.getString(7));
                    empleado.setCargo(result.getString(8));
                    empleado.setContraseña(result.getString(9));
                    
                }
                
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return empleado;
        }
        public boolean lastEmp2(String inicial)
        {
            
            try{
                st = con.prepareStatement("SELECT * FROM empleados WHERE NumeroEmpleado LIKE '"+inicial+"%' ORDER BY CAST(SUBSTR(NumeroEmpleado,2,LENGTH(NumeroEmpleado))AS UNSIGNED) DESC LIMIT 1");
                result = st.executeQuery();
                return result.next();
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return false;
        }
        
        public int countPlatos()
        {
            int i = 0;
            try{
                st = con.prepareStatement("SELECT * FROM menu ");
                result = st.executeQuery();
                while(result.next())
                {
                    i++;
                }
                
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return i;
        }
        
        public int countOrdenes()
        {
            int i = 0;
            try{
                st = con.prepareStatement("SELECT * FROM ordenes ");
                result = st.executeQuery();
                while(result.next())
                {
                    i++;
                }
                
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return i;
        }
        
        public Platillo lastPlato()
        {
            
            try{
                st = con.prepareStatement("select * from menu order by CAST(SUBSTR(Idplatillo,2,Length(Idplatillo))AS UNSIGNED) DESC LIMIT 1");
                result = st.executeQuery();
                while(result.next())
                {
                    platillo.setIdPlatillo(result.getString(1));
                    platillo.setNombrePlatillo(result.getString(2));
                    platillo.setPrecio(result.getFloat(3));
                }
                
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return platillo;
        }
        
        public String lastOrden()
        {
            
            try{
                st = con.prepareStatement("select * from ordenes order by CAST(SUBSTR(IdOrden,3,Length(IdOrden))AS UNSIGNED) DESC LIMIT 1");
                result = st.executeQuery();
                while(result.next())
                {
                    return result.getString(1);  
                }
                
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return "OR0";
        }
        
        
        
        public boolean insertaEmpleado(Empleado emp)
        {
            try
            {
                st = con.prepareStatement("INSERT INTO empleados VALUES (?,?,?,?,?,?,?,?,?)");
                st.setString(1, emp.getNumeroEmpleado());
                st.setString(2, emp.getNombre());
                st.setString(3, emp.getPrimerApellido());
                st.setString(4, emp.getSegundoApellido());
                st.setString(5, emp.getSexo());
                st.setString(6, emp.getTelefono());
                st.setString(7, emp.getCorreo());
                st.setString(8, emp.getCargo());
                st.setString(9, emp.getContraseña());
                return st.execute();
            }catch(SQLException e)
            {
                
                System.out.println("Error al insertar\n "+ e);
            }
            
            return false;
        }
        
        public boolean insertaPlatillo(Platillo plato)
        {
            try
            {
                st = con.prepareStatement("INSERT INTO menu VALUES (?,?,?)");
                st.setString(1, plato.getIdPlatillo());
                st.setString(2, plato.getNombrePlatillo());
                st.setFloat(3, plato.getPrecio());
                return st.execute();
            }catch(SQLException e)
            {
                
                System.out.println("Error al insertar\n "+ e);
            }
            
            return false;
        }
        
        public boolean actualizaEmpleado(Empleado emp)
        {
            try
            {
                st = con.prepareStatement("UPDATE empleados SET NumeroEmpleado = '"+emp.getNumeroEmpleado()+"', Nombre = '"+emp.getNombre()+"', PrimerApellido = '"+emp.getPrimerApellido()+"', SegundoApellido = '"+emp.getSegundoApellido()+"', Sexo = '"+emp.getSexo()+"', Telefono = '"+String.valueOf(emp.getTelefono())+"', Correo = '"+emp.getCorreo()+"', Cargo = '"+emp.getCargo()+"', Contraseña = '"+emp.getContraseña()+"' WHERE NumeroEmpleado='"+emp.getNumeroEmpleado()+"'");
                st.executeUpdate();
                return true;
            }catch(SQLException e)
            {
                System.out.println("Error "+e);
            }
            return false;
        }
        
        public boolean actualizaPlato(Platillo p)
        {
            try
            {
                st = con.prepareStatement("UPDATE menu SET Idplatillo = '"+p.getIdPlatillo()+"', NombrePlatillo = '"+p.getNombrePlatillo()+"', Precio = '"+p.getPrecio()+"' WHERE Idplatillo='"+p.getIdPlatillo()+"'");
                st.executeUpdate();
                return true;
            }catch(SQLException e)
            {
                System.out.println("Error "+e);
            }
            return false;
        }
        
        
        public boolean eliminaEmpleados(String id)
        {
            try
            {
                st = con.prepareStatement("DELETE FROM empleados WHERE NumeroEmpleado = '"+id+"'");
                st.executeUpdate();
                return true;
            }catch(SQLException e)
            {
                System.out.println("ERROR AL ELIMINAR\n "+ e);
            }
            return false;   
        }
        
        public boolean eliminaPlato(String id)
        {
            try
            {
                st = con.prepareStatement("DELETE FROM menu WHERE Idplatillo = '"+id+"'");
                st.executeUpdate();
                return true;
            }catch(SQLException e)
            {
                System.out.println("ERROR AL ELIMINAR\n "+ e);
            }
            return false;   
        }
        
        
        public float ventas()
        {
            float cantidad = 0;
            try{
                st = con.prepareStatement("SELECT * FROM ordenes where Estado = 'Entregada'");
                result = st.executeQuery();
                while(result.next())
                {
                    cantidad += result.getFloat(4);
                }
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return cantidad;
        }
        
        public boolean FinalizaDia()
        {
            try
            {
                st = con.prepareStatement("DELETE FROM ordenes");
                st.executeUpdate();
                return true;
            }catch(SQLException e)
            {
                System.out.println("ERROR AL ELIMINAR\n "+ e);
            }
            return false;   
        }
        
        public boolean copyVentas()
        {
            float v =0;
            String fecha = String.valueOf(calendar.get(Calendar.YEAR))+"/"+String.valueOf(calendar.get(Calendar.MONTH)+1)+"/"+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            try
            {
                v = ventas();
                st = con.prepareStatement("INSERT INTO Ventas VALUES(?,?)");
                st.setFloat(1, v);
                st.setString(2, fecha);
                st.execute();
                return true;
            }catch(SQLException e)
            {
                System.out.println(e);
            }
            return false; 
        }
        
        public boolean validarventas()
        {
            boolean flag = false;
            String fecha = String.valueOf(calendar.get(Calendar.YEAR))+"/"+String.valueOf(calendar.get(Calendar.MONTH)+1)+"/"+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            try
            {
                st = con.prepareStatement("Select * from ventas where Fecha = '"+fecha+"'");
                result = st.executeQuery();
                while(result.next())
                {
                    return true;
                }
                
            }catch(Exception e)
            {
                System.out.println(e);
            }
            
            return flag;
        }
        
        
        public boolean insertaOrden(Orden or)
        {
            try
            {
                st = con.prepareStatement("INSERT INTO ordenes VALUES (?,?,?,?,?,?)");
                st.setString(1, or.getIdOrden());
                st.setString(2, or.getCliente());
                st.setString(3, or.getPlatillos());
                st.setFloat(4, or.getTotal());
                st.setString(5, or.getFecha());
                st.setString(6, or.getEstado());
                return st.execute();
            }catch(SQLException e)
            {
                
                System.out.println("Error al insertar\n "+ e);
            }
            
            return false;
        }
        
        public boolean ActualizaOrden(String id, String status)
        {
            try
            {
                st = con.prepareStatement("UPDATE ordenes SET Estado = '"+status+"' WHERE IdOrden = '"+id+"'");
                st.executeUpdate();
                return true;
            }catch(SQLException e)
            {
                System.out.println("Error "+e);
            }
            return false;
        }
    
}
