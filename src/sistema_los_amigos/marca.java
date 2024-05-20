package sistema_los_amigos;

import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lauut
 */
public class marca {
    private int id_marca;
    private String nombre;
    private Conexion conn;

    public marca(int id_marca, String nombre) 
    {
        this.id_marca = id_marca;
        this.nombre = nombre;
    }

    public marca(String nombre) 
    {
        this.nombre = nombre;
    }

    public marca() 
    {
        
    }
    
//    public ResultSet getTipoProducto() 
//    {
//        try 
//        {
//           String orden = " SELECT * FROM tipo_producto" ;
//           Statement stm =  this.conn.conn.createStatement();
//           return stm.executeQuery(orden);
//        }
//        catch(Exception e) 
//        {
//           return null;
//        }
//    }
//    
//    public void guardarTipoProducto() 
//    {
//       
//        try 
//        {
//            String query = "INSERT INTO tipo_producto(nombre, descripcion)" 
//            +  "VALUES (?, ?)";
//            PreparedStatement pst = this.conn.conn.prepareStatement(query);
//            pst.setString(1, this.nombre);
//            pst.setString(2, this.descripcion);
//            pst.execute();
//        }
//        catch (Exception ee) 
//        { 
//           JOptionPane.showMessageDialog(null, ee);
//        }   
//    }
//
//    public void modificarTipoProducto() 
//    {
//       if (this.idtipo_producto > 0) 
//        {
//            try 
//            {
//                String orden = 
//                "UPDATE tipo_producto SET nombre=?, descripcion=? " + "WHERE idtipo_producto=?";
//                PreparedStatement pst = this.conn.conn.prepareStatement(orden);
//                pst.setString(1, this.nombre);
//                pst.setString(2, this.descripcion);
//                pst.setInt(3, this.idtipo_producto);;
//                pst.execute();
//            }
//            catch(Exception ee) 
//            {
//               
//            }
//        }
//    }
//    
//    public void borrarTipoProducto() 
//    {
//        try 
//        {
//            String orden= "DELETE FROM tipo_producto WHERE idtipo_producto=?";
//            PreparedStatement pst = this.conn.conn.prepareStatement(orden);
//            pst.setInt(1, this.idtipo_producto);
//            pst.execute();
//        }
//        catch(Exception ee) 
//        {
//
//        }     
//    }

    public int getId_marca() 
    {
        return id_marca;
    }

    public void setId_marca(int id_marca) 
    {
        this.id_marca = id_marca;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
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
