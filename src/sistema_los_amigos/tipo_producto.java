package sistema_los_amigos;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * @author lauut
 */

public class tipo_producto {
    private int idtipo_producto;
    private String nombre;
    private String descripcion;
    private Conexion conn;

    public tipo_producto(int idtipo_producto, String nombre, String descripcion, Conexion conn) 
    {
        this.idtipo_producto = idtipo_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.conn = conn;
    }
    
    public tipo_producto(String nombre, String descripcion, Conexion conn) 
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.conn = conn;
    }
    
    public tipo_producto() 
    {
        
    }  
    
    public ResultSet getTipoProducto() 
    {
        try 
        {
           String orden = " SELECT * FROM tipo_producto" ;
           Statement stm =  this.conn.conn.createStatement();
           return stm.executeQuery(orden);
        }
        catch(Exception e) 
        {
           return null;
        }
    }
    
    public void guardarTipoProducto() 
    {
       
        try 
        {
            String query = "INSERT INTO tipo_producto(nombre, descripcion)" 
            +  "VALUES (?, ?)";
            PreparedStatement pst = this.conn.conn.prepareStatement(query);
            pst.setString(1, this.nombre);
            pst.setString(2, this.descripcion);
            pst.execute();
        }
        catch (Exception ee) 
        { 
           JOptionPane.showMessageDialog(null, ee);
        }   
    }

    public void modificarTipoProducto() 
    {
       if (this.idtipo_producto > 0) 
        {
            try 
            {
                String orden = 
                "UPDATE tipo_producto SET nombre=?, descripcion=? " + "WHERE idtipo_producto=?";
                PreparedStatement pst = this.conn.conn.prepareStatement(orden);
                pst.setString(1, this.nombre);
                pst.setString(2, this.descripcion);
                pst.setInt(3, this.idtipo_producto);;
                pst.execute();
            }
            catch(Exception ee) 
            {
               JOptionPane.showMessageDialog(null, ee);
            }
        }
    }
    
    public void borrarTipoProducto() 
    {
        try 
        {
            String orden= "DELETE FROM tipo_producto WHERE idtipo_producto=?";
            PreparedStatement pst = this.conn.conn.prepareStatement(orden);
            pst.setInt(1, this.idtipo_producto);
            pst.execute();
        }
        catch(Exception ee) 
        {
            JOptionPane.showMessageDialog(null, ee);
        }     
    }
    
    public Conexion getConn() 
    {
        return conn;
    }

    public void setConn(Conexion conn) 
    {
        this.conn = conn;
    }

    public int getIdtipo_producto() 
    {
        return idtipo_producto;
    }

    public void setIdtipo_producto(int idtipo_producto) 
    {
        this.idtipo_producto = idtipo_producto;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getDescripcion() 
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion) 
    {
        this.descripcion = descripcion;
    }
    
}
