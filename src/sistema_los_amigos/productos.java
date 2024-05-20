package sistema_los_amigos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * @author lauut
 */

public class productos {
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;
    private int id_marca;
    private int id_tipoproducto;
    private Conexion conn;

    public productos(int idProducto, String nombre, String descripcion, double precio, int cantidad, int id_marca, int id_tipoproducto, Conexion conn) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_marca = id_marca;
        this.id_tipoproducto = id_tipoproducto;
        this.conn = conn;
    }

    public productos(String nombre, String descripcion, double precio, int cantidad, int id_marca, int id_tipoproducto, Conexion conn) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_marca = id_marca;
        this.id_tipoproducto = id_tipoproducto;
        this.conn = conn;
    }

    public productos() 
    {
        
    }
    
    public ResultSet getProductos() 
    {
        try 
        {
           String orden = " SELECT * FROM productos" ;
           Statement stm =  this.conn.conn.createStatement();
           return stm.executeQuery(orden);
        }
        catch(Exception e) 
        {
           return null;
        }
    }
    
    public void guardarProductos() 
    {
       
        try 
        {
            String query = "INSERT INTO productos(nombre, descripcion, precio, cantidad, id_marca, id_tipoproducto)" 
            +  "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = this.conn.conn.prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, descripcion);
            pst.setDouble(3, precio);
            pst.setInt(4, cantidad);
            pst.setInt(5, id_marca);
            pst.setInt(6, id_tipoproducto);
            pst.execute();
        }
        catch (Exception ee) 
        { 
           JOptionPane.showMessageDialog(null, ee);
        }   
    }

    public void modificarProductos() 
    {
       if (this.idProducto > 0) 
        {
            try 
            {
                String orden = 
                "UPDATE productos SET nombre=?, descripcion=?, precio=?, cantidad=?, id_marca=?, id_tipoproducto=?  " + "WHERE idProducto=?";
                PreparedStatement pst = this.conn.conn.prepareStatement(orden);
                pst.setString(1, nombre);
                pst.setString(2, descripcion);
                pst.setDouble(3, precio);
                pst.setInt(4, cantidad);
                pst.setInt(5, id_marca);
                pst.setInt(6, id_tipoproducto);
                pst.setInt(7, idProducto);;
                pst.execute();
            }
            catch(Exception ee) 
            {
               
            }
        }
    }
    
    public void borrarProductos() 
    {
        try 
        {
            String orden= "DELETE FROM productos WHERE idProducto=?";
            PreparedStatement pst = this.conn.conn.prepareStatement(orden);
            pst.setInt(1, this.idProducto);
            pst.execute();
        }
        catch(Exception ee) 
        {

        }     
    }
    
    public int getIdProducto()
    {
        return idProducto;
    }

    public void setIdProducto(int idProducto) 
    {
        this.idProducto = idProducto;
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

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio) 
    {
        this.precio = precio;
    }

    public int getCantidad() 
    {
        return cantidad;
    }

    public void setCantidad(int cantidad) 
    {
        this.cantidad = cantidad;
    }

    public int getId_marca()
    {
        return id_marca;
    }

    public void setId_marca(int id_marca) 
    {
        this.id_marca = id_marca;
    }

    public int getId_tipoproducto()
    {
        return id_tipoproducto;
    }

    public void setId_tipoproducto(int id_tipoproducto) 
    {
        this.id_tipoproducto = id_tipoproducto;
    }

    public Conexion getConn()
    {
        return conn;
    }

    public void setConn(Conexion conn)
    {
        this.conn = conn;
    }
    
}
