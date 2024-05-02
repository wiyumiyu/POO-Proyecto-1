package wiyu.barberia_poo.Clases;

import java.io.Serializable; // https://www.baeldung.com/java-get-day-of-week
import java.time.DayOfWeek;
import java.time.LocalDate;
/* 
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

public class HorarioDia implements Serializable{
    
    private int dia;
    private int inicio;
    private int fin;
    
    public HorarioDia(int dia, int inicio, int fin) throws Exception {
        if (inicio >= fin)
            throw new Exception("La hora inicial debe ser menor que la final");
        this.dia = dia;
        this.inicio = inicio;
        this.fin = fin;          
    }
    
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }
    
    @Override
    public String toString() {
        String nombreDia = "";
        
        switch(this.dia){
            case 1:
                nombreDia = "lunes";
                break;
            case 2:
                nombreDia = "martes";
                break;
            case 3:
                nombreDia = "miércoles";
                break;
            case 4:
                nombreDia = "jueves";
                break;
            case 5:
                nombreDia = "viernes";
                break;
            case 6:
                nombreDia = "sábado";
                break;
            case 7:
                nombreDia = "domingo";
                break;
               
        }
        String str = "Horario para el día " + nombreDia + "\n";
        str+= " Inicio: " + this.inicio + ":00" + "\n";
        str+= " Final: " + this.fin + ":00" + "\n";
        return str;
    }
    
}
