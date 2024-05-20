package sistema_los_amigos;

import Conexion.Conexion;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistema_los_amigos.FormulariosComunes.Inicio;

/**
 *
 * @author esme
 */
public class Sistema_Los_Amigos {
    
    Conexion conn = new Conexion(); // aqui está la conexion
    String Usuario;
    int Rol;
    int idusu;
    
     public Conexion getConn() {
        return conn;
    }

    public void setConn(String usuario, String contra) {
        conn = new Conexion(usuario, contra);
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getRol() {
        return Rol;
    }

    public int getIdusu() {
        return idusu;
    }
    
    public void verificarRol() //este método es para obtener el rol del usuario
    {
        ArrayList<Integer> rool = new ArrayList<>();
        try 
        {
            ArrayList<Object[]> roll = this.conn.consultar("Select idUsuarios, RolId from Usuarios where Nombre='"+Usuario+"'");
            for (Object[] dato : roll) 
            {
               rool.add(Integer.valueOf(dato[0].toString()));
               rool.add(Integer.valueOf(dato[1].toString()));
           }  
            idusu = rool.get(0);
            Rol = rool.get(1);
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
    }
    
}
