package wiyu.barberia_poo.Clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Properties;
import javax.mail.*;  
import javax.mail.internet.*;  

/*
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

public class Cita implements Serializable{
    public static int consecutivo = 1;
    private int codigo;
    private LocalDate dia;
    private int horaInicial;
    private Servicio servicio;
    private Cliente cliente;
    private boolean confirmada;

    public Cita(Cliente cliente, LocalDate dia, int horaInicial, Servicio servicio) throws Exception {
        if(dia.compareTo(LocalDate.now()) <= 0){
            throw new Exception("La fecha de la cita no puede ser igual o menor que el día actual");
        }
        this.dia = dia;
        this.cliente = cliente;
        this.horaInicial = horaInicial;
        this.servicio = servicio;
        this.codigo = consecutivo;
        this.confirmada = false;
        consecutivo++;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo(){
        return codigo;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }
    
    public LocalDate getDia() {
        return dia;
    }

    public void setHoraInicial(int horaInicial) {
        this.horaInicial = horaInicial;
    }
    
    public int getHoraInicial() {
        return horaInicial;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Servicio getServicio() {
        return servicio;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public String getHorarioStr(){
        return this.dia + " a las " + this.horaInicial;
    }
    
    public boolean getConfirmada() {
        return confirmada;
    }

    public void setConfirmada(boolean confirmada) {
        this.confirmada = confirmada;
    }
    
    public int modificarCita(LocalDate dia, int hora, Servicio servicio) throws Exception {
        if(dia.compareTo(LocalDate.now()) <= 0){
            throw new Exception("La fecha de la cita no puede ser igual o menor que el día actual");
        }
        this.dia = dia;
        this.horaInicial =hora;
        this.servicio = servicio;
        return this.codigo;
    }
    
    public void confirmarCita() throws Exception {
        if(this.confirmada){
            throw new Exception("La cita ya fue confirmada previamente");
        }        
        
        //https://www.javatpoint.com/example-of-sending-email-using-java-mail-api
        String host="smtp-mail.outlook.com";  
        String user="manditec3@outlook.com";//usuario del servidor de correo
        String password="mandi1234*";//contrasena del servidor de correo 
        int port = 587;
        String to=this.cliente.getCorreo();
  
        //Session object  
        Properties props = new Properties();  
        props.put("mail.smtp.host",host);  
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.auth", "true");  
        //props.setProperty("mail.smtp.ssl.enable", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
     
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(user,password);  
            }  
         });  

        //Mensaje de confirmacion 
         try {  
            MimeMessage message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(user));  
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            message.setSubject("Confirmación de cita");  
            message.setText("Su cita ha sido confirmada para " + this.getHorarioStr());  
            
            //enviar el mensaje  
            Transport.send(message);  

            System.out.println("Correo enviado correctamente a: " + this.cliente.getCorreo());  

        } 
         catch (MessagingException e) 
         {
             throw new Exception("Error al enviar el correo de confirmación de la cita");
         } 
         
         this.confirmada = true;
    }
    
    @Override
    public String toString(){
        String datos = "Código de cita: " + this.codigo + "\n";
        datos += "Código del cliente: " + this.getCliente().getCodigo() + "\n";
        datos += "Servicio de cita: " + this.servicio.toString() + "\n";
        datos += "Día de cita: " + this.dia + "\n";
        datos += "Hora inicial de la cita: " + this.horaInicial + "\n";
        return datos;
    }

}
