
package BaseDatos;

import com.mysql.jdbc.Connection;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Empleado;
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
    private List <Platillo> listaplatilos = new ArrayList<>();
    private List <Empleado> listaEmpleado = new ArrayList<>();
    
    
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
        
        public boolean iniciar_sesion(String user, String pass)
        {
            conectar();
            try
            {
                st = con.prepareStatement("select * from empleados where NumeroEmpleado = '"+user+"'");
                result = st.executeQuery();
                
                if(result.next() != false)
                {
                    st = con.prepareStatement("select * from empleados where Contraseña = '"+pass+"'");
                    result = st.executeQuery();
                    return result.next();
                }
                else
                {
                    return false;
                }
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
                    empleado.setTelefono(result.getInt(6));
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
                    listaEmpleado.add(new Empleado(result.getString(1), result.getInt(6), result.getString(7),result.getString(8),result.getString(9), result.getString(2), result.getString(3), result.getString(4),result.getString(5)));
                }
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return listaEmpleado;
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
                    listaEmpleado.add(new Empleado(result.getString(1), result.getInt(6), result.getString(7),result.getString(8),result.getString(9), result.getString(2), result.getString(3), result.getString(4),result.getString(5)));
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
                st = con.prepareStatement("SELECT * FROM empleados WHERE NumeroEmpleado LIKE '"+inicial+"%' ORDER BY NumeroEmpleado DESC LIMIT 1");
                result = st.executeQuery();
                while(result.next())
                {
                    empleado.setNumeroEmpleado(result.getString(1));
                    empleado.setNombre(result.getString(2));
                    empleado.setPrimerApellido(result.getString(3));
                    empleado.setSegundoApellido(result.getString(4));
                    empleado.setSexo(result.getString(5));
                    empleado.setTelefono(result.getInt(6));
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
        
        public Platillo lastPlato()
        {
            
            try{
                st = con.prepareStatement("SELECT * FROM menu  ORDER BY Idplatillo DESC LIMIT 1");
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
        
        public boolean lastEmp2(String inicial)
        {
            
            try{
                st = con.prepareStatement("SELECT * FROM empleados WHERE NumeroEmpleado LIKE '"+inicial+"%' ORDER BY NumeroEmpleado DESC LIMIT 1");
                result = st.executeQuery();
                return result.next();
            }catch(SQLException e)
            {
                System.out.println("Error al mostrar" + e);
            }
            return false;
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
                st.setInt(6, emp.getTelefono());
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
        
    
}
