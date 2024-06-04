package sistema_los_amigos;

import java.util.Properties;
import javax.swing.JOptionPane;
import javax.activation.*;

import javax.mail.*;

import javax.mail.internet.*;


/*
 * @author esmer
 */

public class FacturaElectrónica 
{

    public FacturaElectrónica() 
    {
        
    }
    
    public void CrearYEnviarFactura(String Correo, String Mensaje)
    {
        String CorreoEmisor = "esmeraldajasmi746@gmail.com";
        String Contraseña = "tfrd jluz ymht kqaw";
        
        
        Properties objetoPEC = new Properties();
        
        objetoPEC.put("mail.smtp.host", "smtp.gmail.com");
        objetoPEC.setProperty("mail.smtp.starttls.enable", "true");
        objetoPEC.put("mail.smtp.port", "517");
        objetoPEC.setProperty("mail.smtp.port", "587");
        objetoPEC.put("mail.smtp.user", CorreoEmisor);
        objetoPEC.setProperty("mail.smtp.auth", "true");
        
        Session sesion = Session.getDefaultInstance(objetoPEC);
        
        MimeMessage mail = new MimeMessage(sesion);
        
        try
        {
            mail.setFrom(new InternetAddress(CorreoEmisor));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(Correo));
            mail.setSubject("Comprobante de venta Activaciones los Amigos");
            mail.setText(Mensaje);
            
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(CorreoEmisor, Contraseña);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            
            JOptionPane.showMessageDialog(null, "Venta realizada");
        }
        catch(Exception ee)
        {
            JOptionPane.showMessageDialog(null, "Error: " + ee);
        }   
    }
    
}
