package Conexion;

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
    public Connection conn;
    private Statement stm;
   
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

    public Conexion() 
    {
        
    }
   
   public Connection getConnection()
   {
       return this.conn;
   }
   
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
