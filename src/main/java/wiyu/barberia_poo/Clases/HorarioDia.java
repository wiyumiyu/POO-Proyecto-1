package wiyu.barberia_poo.Clases;

import java.io.Serializable; // https://www.baeldung.com/java-get-day-of-week
import java.time.LocalDate;
/* 
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

public class HorarioDia implements Serializable{
    
    private LocalDate dia;
    private int inicio;
    private int fin;
    
    public HorarioDia(LocalDate dia, int inicio, int fin) throws Exception {
        if (inicio >= fin)
            throw new Exception("La hora inicial debe ser menor que la final");
        this.dia = dia;
        this.inicio = inicio;
        this.fin = fin;          
    }
    
    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
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
        String str = "Horario para el día " + this.dia + "\n";
        str+= " Inicio: " + this.inicio + ":00" + "\n";
        str+= " Final: " + this.fin + ":00" + "\n";
        return str;
    }
    
}
