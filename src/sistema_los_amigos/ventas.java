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
public class ventas {
    private int idventas;
    private int id_cliente;
    private int id_empleado;
    private String fecha;
    private double total; 
    private Conexion conn;

    public ventas(int idventas, int id_cliente, int id_empleado, String fecha, double total, Conexion conn) 
    {
        this.idventas = idventas;
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.fecha = fecha;
        this.total = total;
        this.conn = conn;
    }

    public ventas(int id_cliente, int id_empleado, String fecha, double total, Conexion conn) 
    {
        this.id_cliente = id_cliente;
        this.id_empleado = id_empleado;
        this.fecha = fecha;
        this.total = total;
        this.conn = conn;
    }

    public ventas() 
    {
        
    }
    
    public ResultSet getVentas() 
    {
        try 
        {
           String orden = " SELECT * FROM ventas" ;
           Statement stm =  this.conn.conn.createStatement();
           return stm.executeQuery(orden);
        }
        catch(Exception e) 
        {
           return null;
        }
    }
    
    public void guardarVentas() 
    {
       
        try 
        {
            String query = "INSERT INTO ventas(id_cliente, id_empleado, fecha, total)" 
            +  "VALUES(?, ?, ?, ?)";
            PreparedStatement pst = this.conn.conn.prepareStatement(query);
            pst.setInt(1, this.id_cliente);
            pst.setInt(2, this.id_empleado);
            pst.setString(3, this.fecha);
            pst.setDouble(4, this.total);
            pst.execute();
        }
        catch (Exception ee) 
        { 
           JOptionPane.showMessageDialog(null, ee);
        }   
    }

    public void modificarVentas() 
    {
       if (this.idventas > 0) 
        {
            try 
            {
                String orden = 
                "UPDATE marca SET id_cliente=?, id_empleado=?, fecha=?, total=?" + "WHERE idventas=?";
                PreparedStatement pst = this.conn.conn.prepareStatement(orden);
                pst.setInt(1, this.id_cliente);
                pst.setInt(2, this.id_empleado);
                pst.setString(3, this.fecha);
                pst.setDouble(4, this.total);
                pst.setInt(5, this.idventas);
                pst.execute();
            }
            catch(Exception ee) 
            {
               JOptionPane.showMessageDialog(null, ee);
            }
        }
    }
    
    public void borrarVentas() 
    {
        try 
        {
            String orden= "DELETE FROM ventas WHERE idventas=?";
            PreparedStatement pst = this.conn.conn.prepareStatement(orden);
            pst.setInt(1, this.idventas);
            pst.execute();
        }
        catch(Exception ee) 
        {
            JOptionPane.showMessageDialog(null, ee);
        }     
    }

    public int getIdventas() {
        return idventas;
    }

    public void setIdventas(int idventas) {
        this.idventas = idventas;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }
}
