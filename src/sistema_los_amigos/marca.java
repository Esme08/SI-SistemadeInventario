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

    public marca(int id_marca, String nombre, Conexion conn) 
    {
        this.id_marca = id_marca;
        this.nombre = nombre;
        this.conn = conn;
    }

    public marca(String nombre,Conexion conn) 
    {
        this.nombre = nombre;
        this.conn = conn;
    }

    public marca() 
    {
        
    }
    
    public ResultSet getMarca() 
    {
        try 
        {
           String orden = " SELECT * FROM marca" ;
           Statement stm =  this.conn.conn.createStatement();
           return stm.executeQuery(orden);
        }
        catch(Exception e) 
        {
           return null;
        }
    }
    
    public void guardarMarca() 
    {
       
        try 
        {
            String query = "INSERT INTO marca(nombre)" 
            +  "VALUES (?)";
            PreparedStatement pst = this.conn.conn.prepareStatement(query);
            pst.setString(1, this.nombre);
            pst.execute();
        }
        catch (Exception ee) 
        { 
           JOptionPane.showMessageDialog(null, ee);
        }   
    }

    public void modificarMarca() 
    {
       if (this.id_marca > 0) 
        {
            try 
            {
                String orden = 
                "UPDATE marca SET nombre=? " + "WHERE idmarca=?";
                PreparedStatement pst = this.conn.conn.prepareStatement(orden);
                pst.setString(1, this.nombre);
                pst.setInt(2, this.id_marca);;
                pst.execute();
            }
            catch(Exception ee) 
            {
               JOptionPane.showMessageDialog(null, ee);
            }
        }
    }
    
    public void borrarMarca() 
    {
        try 
        {
            String orden= "DELETE FROM marca WHERE idmarca=?";
            PreparedStatement pst = this.conn.conn.prepareStatement(orden);
            pst.setInt(1, this.id_marca);
            pst.execute();
        }
        catch(Exception ee) 
        {
            JOptionPane.showMessageDialog(null, ee);
        }     
    }

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
