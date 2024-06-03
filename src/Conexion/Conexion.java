package Conexion;

// Importaciones necesarias para el funcionamiento de
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author esme :3
 * 
 */

public class Conexion 
{
    // Variables´para la conexión y la ejecución de consultas
    public Connection conn;
    private Statement stm;
   
    /*constructor donde se realiza la conexión a la base de datos 
    por medio de los parámetros Usuario y Clave,
    que son las credenciales de la persona que quiere usar el sistema*/
    public Conexion(String pUsuario, String pClave)  
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver") ;
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/los_amigos?zeroDateTimeBehavior=CONVERT_TO_NULL",  pUsuario, pClave);
            this.stm = this.conn.createStatement();
        }
       catch(Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Constructor vacío
    public Conexion() 
    {
        
    }
   
   //Método para obtener la conexión
   public Connection getConnection()
   {
       return this.conn;
   }
   
   //Método para realizar una consulta
   public ArrayList<Object[]> consultar(String query) 
   {
       
        ArrayList<Object[]> aResultados = new ArrayList<>();

        try 
        {
            ResultSet rs = this.stm.executeQuery(query);
            int columnCount = ((ResultSetMetaData) rs.getMetaData()).getColumnCount();

            while (rs.next()) 
            {
                Object[] fila = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) 
                {
                    fila[i-1] = rs.getObject(i);
                }
                aResultados.add(fila);
        }
    } 
    catch (Exception e) 
    {
        JOptionPane.showMessageDialog(null, e);
    }
    
    return aResultados;
    }
   
   //Método para insertar datos
   public void insertar(String query, Object[] params) 
   {
        try 
        {
            PreparedStatement pStmt = this.conn.prepareStatement(query);
            if (params != null) 
            {
                for (int i = 0; i < params.length; i++) 
                    pStmt.setObject(i + 1, params[i]);
                pStmt.executeUpdate();
            }
        } 
        catch (Exception e) { int i=0; }
    }
}
