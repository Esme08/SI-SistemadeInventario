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
public class empleados {
    private int idEmpleado;
    private String nombre;
    private String tel;
    private String dui;
    private int UsuarioID;
    private Conexion conn;

    public empleados(int idEmpleado, String nombre, String tel, String dui, int UsuarioID, Conexion conn) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.tel = tel;
        this.dui = dui;
        this.UsuarioID = UsuarioID;
        this.conn = conn;
    }

    public empleados(String nombre, String tel, String dui, int UsuarioID, Conexion conn) {
        this.nombre = nombre;
        this.tel = tel;
        this.dui = dui;
        this.UsuarioID = UsuarioID;
        this.conn = conn;
    }

    public empleados() 
    {
        
    }
    
    public ResultSet getEmpleados() 
    {
        try 
        {
           String orden = "SELECT empleados.idEmpleado, empleados.nombre, empleados.tel, empleados.dui, roles.NombreRol, roles.Permisos FROM empleados JOIN usuarios ON empleados.UsuarioID = usuarios.idUsuarios JOIN roles ON usuarios.RolId = roles.ID";
           Statement stm =  this.conn.conn.createStatement();
           return stm.executeQuery(orden);
        }
        catch(Exception e) 
        {
           return null;
        }
    }
    
    public void guardarEmpleados() 
    {
       
        try 
        {
            String query = "INSERT INTO empleados(nombre, tel, dui, UsuarioID)" 
            +  "VALUES (?, ?, ?, ?)";
            PreparedStatement pst = this.conn.conn.prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, tel);
            pst.setString(3, dui);
            pst.setInt(4, UsuarioID);
            pst.execute();
        }
        catch (Exception ee) 
        { 
           JOptionPane.showMessageDialog(null, ee);
        }   
    }

    public void modificarEmpleados() 
    {
       if (this.idEmpleado > 0) 
        {
            try 
            {
                String orden = 
                "UPDATE empleados SET nombre=?, tel=?, dui=?, UsuarioID=? WHERE idEmpleado=?";
                PreparedStatement pst = this.conn.conn.prepareStatement(orden);
                pst.setString(1, nombre);
                pst.setString(2, tel);
                pst.setString(3, dui);
                pst.setInt(4, UsuarioID);
                pst.setInt(5, idEmpleado);   
                pst.execute();
            }
            catch(Exception ee) 
            {
               JOptionPane.showMessageDialog(null, ee);
            }
        }
    }
    
    public void borrarEmpleados() 
    {
        try 
        {
            String orden= "DELETE FROM empleados WHERE idEmpleado=?";
            PreparedStatement pst = this.conn.conn.prepareStatement(orden);
            pst.setInt(1, this.idEmpleado);
            pst.execute();
        }
        catch(Exception ee) 
        {
            JOptionPane.showMessageDialog(null, ee);
        }     
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getUsuarioID() {
        return UsuarioID;
    }

    public void setUsuarioID(int UsuarioID) {
        this.UsuarioID = UsuarioID;
    }

    public Conexion getConn() {
        return conn;
    }

    public void setConn(Conexion conn) {
        this.conn = conn;
    }
    
    
    
}
