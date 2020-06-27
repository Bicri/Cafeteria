
package BaseDatos;

import com.mysql.jdbc.Connection;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import objetos.Empleado;

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
        
        public boolean actualizaEmpleado(Empleado empleado)
        {
            conectar();
            try
            {
                st = con.prepareStatement("UPDATE empleados SET NumeroEmpleado = '"+empleado.getNumeroEmpleado()+"', Nombre = '"+empleado.getNombre()+"', PrimerApellido = '"+empleado.getPrimerApellido()+"', SegundoApellido = '"+empleado.getSegundoApellido()+"', Sexo = '"+empleado.getSexo()+"', Telefono = '"+empleado.getTelefono()+"', Correo = '"+empleado.getCorreo()+"', Cargo = '"+empleado.getCargo()+"', Contraseña = '"+empleado.getContraseña()+"' WHERE NumeroEmpleado='"+empleado.getNumeroEmpleado()+"'");
                st.executeUpdate();
                return true;
            }catch(SQLException e)
            {
                System.out.println("Error "+e);
                return false;
            }
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
        
        public List muestraDinamica(String actual, String buscar)
        {
            listaEmpleado.clear();
            try{
                st = con.prepareStatement("select * from empleados where (NumeroEmpleado LIKE '"+buscar+"%' AND NumeroEmpleado != '"+"A0"+"') AND NumeroEmpleado != '"+actual+"' ");
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
        
    
}
