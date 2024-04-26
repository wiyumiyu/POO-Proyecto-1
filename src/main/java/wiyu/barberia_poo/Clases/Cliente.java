package wiyu.barberia_poo.Clases;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

public class Cliente {
    
    public static int consecutivo = 1;
    private int codigo;
    private String nombre;
    private String telefono;
    private String correo;
    private ArrayList<Cita> citas;
    
        
     public Cliente(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        // Validar el número de teléfono antes de asignarlo
        if (numeroEsValido(telefono)) {
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("Número de teléfono no válido");
        }
        // Validar el correo electrónico antes de asignarlo
        if (correoEsValido(correo)) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo electrónico no válido");
        }
        this.codigo = consecutivo;
        consecutivo++;
    }
     

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    public static boolean correoEsValido(String email) {
        // Patron para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
        return mather.find();
    } // @author Somos Programadores Facebook // https://web.facebook.com/developers08062019 // https://www.youtube.com/watch?v=zaZH6Q8vT5k&t=3s
    
    public static boolean numeroEsValido(String num) { 
        // Expresión regular para números de teléfono de Costa Rica
        String regex = "^\\+506[0-9]\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(num);
        return matcher.matches();
    } // Phone number Regex | Phone number Regex Java Validator. (n.d.). https://www.akto.io/tools/phone-number-regex-Java-tester 
    
    public int crearCita(String dia, int hora, Servicio servicio){
        Cita cita = new Cita(this.codigo, dia, hora, servicio);
        citas.add(cita);
        return cita.getCodigo();
    } 
    
    public Cita obtenerCita(int codigoCita){
        for (Cita cita : citas){
            if (cita.getCodigo() == codigoCita)
                return cita;
        }
        return null;
    }
    public void eliminarCita(int codigoCita){
        for (Cita cita:citas){
            if (cita.getCodigo() == codigoCita)
                citas.remove(cita);
        }
    }
    @Override
    public String toString() {
        String result =  "Código del cliente: " + codigo +"\n";
        result +=  "Nombre: " + nombre +"\n";
        result += "Teléfono: " + telefono +"\n";
        result += "Correo electrónico: " + correo +"\n";
        return result;
    }
    
}
