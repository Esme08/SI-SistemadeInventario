package sistema_los_amigos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
* @author lauut
*/
public class clientes {
    private int idCliente;
    private String nombre;
    private String correo;
    private Conexion conn;

    public clientes(int idCliente, String nombre, String correo, Conexion conn) 
    {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.conn = conn;
    }

    public clientes(String nombre, String correo, Conexion conn) 
    {
        this.nombre = nombre;
        this.correo = correo;
        this.conn = conn;
    }

    public clientes() 
    {
        
    }
    
    public ResultSet getClientes() 
    {
        try 
        {
           String orden = "SELECT * FROM clientes;";
           Statement stm =  this.conn.conn.createStatement();
           return stm.executeQuery(orden);
        }
        catch(Exception e) 
        {
           return null;
        }
    }
    
    public ResultSet getClientes(String Cliente) 
    {
        try 
        {
           String orden = "SELECT * FROM clientes WHERE nombre LIKE ?";
           PreparedStatement stm = this.conn.conn.prepareStatement(orden);
           stm.setString(1, "%" + Cliente + "%");
           return stm.executeQuery();
        }
        catch(Exception e) 
        {
           return null;
        }
    }
    
    public void guardarClientes() 
    {
       
        try 
        {
            String query = "INSERT INTO clientes(nombre, correo)" 
            +  "VALUES (?, ?)";
            PreparedStatement pst = this.conn.conn.prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, correo);
            pst.execute();
        }
        catch (Exception ee) 
        { 
           JOptionPane.showMessageDialog(null, ee);
        }   
    }

    public void modificarClientes() 
    {
       if (this.idCliente > 0) 
        {
            try 
            {
                String orden = 
                "UPDATE clientes SET nombre=?, correo=?" + "WHERE idCliente=?";
                PreparedStatement pst = this.conn.conn.prepareStatement(orden);
                pst.setString(1, nombre);
                pst.setString(2, correo);
                pst.setInt(3, idCliente);
                pst.execute();
            }
            catch(Exception ee) 
            {
               JOptionPane.showMessageDialog(null, ee);
            }
        }
    }
    
    public void borrarClientes() 
    {
        try 
        {
            String orden= "DELETE FROM clientes WHERE idCliente=?";
            PreparedStatement pst = this.conn.conn.prepareStatement(orden);
            pst.setInt(1, this.idCliente);
            pst.execute();
        }
        catch(Exception ee) 
        {
            JOptionPane.showMessageDialog(null, ee);
        }     
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }  
}
