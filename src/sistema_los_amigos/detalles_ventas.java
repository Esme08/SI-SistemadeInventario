package sistema_los_amigos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lauut
 */
public class detalles_ventas {
    private int iddetalles_venta;
    private int id_venta;
    private int id_producto;
    private int cantidad_vendida;
    private Conexion conn;

    public detalles_ventas(int iddetalles_venta, int id_venta, int id_producto, int cantidad_vendida, Conexion conn) 
    {
        this.iddetalles_venta = iddetalles_venta;
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad_vendida = cantidad_vendida;
        this.conn = conn;
    }

    public detalles_ventas(int id_venta, int id_producto, int cantidad_vendida, Conexion conn) 
    {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.cantidad_vendida = cantidad_vendida;
        this.conn = conn;
    }

    public detalles_ventas() 
    {
        
    }
    
    public ResultSet getDetalleVentas(int idVenta) 
    {
        try 
        {
           String orden = "SELECT productos.nombre, detalles_venta.cantidad_vendida, productos.precio FROM detalles_venta JOIN productos ON productos.idProducto = detalles_venta.id_producto WHERE detalles_venta.id_venta = ?" ;
           PreparedStatement stm = this.conn.conn.prepareStatement(orden);
           stm.setInt(1, idVenta);
           return stm.executeQuery();
        }
        catch(Exception e) 
        {
           return null;
        }
    }
    
    public void guardarDetalleVentas() 
    {
       
        try 
        {
            String query = "INSERT INTO detalles_venta(id_venta, id_producto, cantidad_vendida)" 
            +  "VALUES(?, ?, ?)";
            PreparedStatement pst = this.conn.conn.prepareStatement(query);
            pst.setInt(1, this.id_venta);
            pst.setInt(2, this.id_producto);
            pst.setInt(3, this.cantidad_vendida);
            pst.execute();
        }
        catch (Exception ee) 
        { 
           JOptionPane.showMessageDialog(null, ee);
        }   
    }

    public void modificarDetalleVentas() 
    {
       if (this.iddetalles_venta > 0) 
        {
            try 
            {
                String orden = 
                "UPDATE detalles_venta SET id_venta=?, id_producto=?, cantidad_vendida=?" + "WHERE iddetalles_venta=?";
                PreparedStatement pst = this.conn.conn.prepareStatement(orden);
                pst.setInt(1, this.id_venta);
                pst.setInt(2, this.id_producto);
                pst.setInt(3, this.cantidad_vendida);
                pst.setInt(4, this.iddetalles_venta);
                pst.execute();
            }
            catch(Exception ee) 
            {
               JOptionPane.showMessageDialog(null, ee);
            }
        }
    }
    
    public void borrarDetalleVentas() 
    {
        try 
        {
            String orden= "DELETE FROM detalles_venta WHERE iddetalles_venta=?";
            PreparedStatement pst = this.conn.conn.prepareStatement(orden);
            pst.setInt(1, this.iddetalles_venta);
            pst.execute();
        }
        catch(Exception ee) 
        {
            JOptionPane.showMessageDialog(null, ee);
        }     
    }

    public int getIddetalles_venta() {
        return iddetalles_venta;
    }

    public void setIddetalles_venta(int iddetalles_venta) {
        this.iddetalles_venta = iddetalles_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(int cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }
    
    
}
