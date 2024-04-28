package wiyu.barberia_poo.Clases;

import java.time.DayOfWeek; // https://www.baeldung.com/java-get-day-of-week
import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/* 
Proyecto 1 POO - Barbería
Dayron Porras Perez
Amanda Ramirez Viales
Mariana Torres Valverde
 */

public class HorarioDia {
    
    private DayOfWeek dia;
    private LocalTime inicio;
    private LocalTime fin;
    private Map<Integer, LocalTime> horasConCodigo;
    
    public HorarioDia(DayOfWeek dia, LocalTime inicio, LocalTime fin) {
        this.dia = dia;
        Duration duracion = Duration.between(inicio, fin);
        if (!tieneMinutos(duracion)) {
            this.inicio = inicio;
            this.fin = fin;
        }else{
            throw new IllegalArgumentException("Horario inválido, el rango de horarios tiene que tener horas exactas para poder brindar su servicio");
        }
        this.horasConCodigo = generarMapaHorasConCodigo(inicio, fin);          
    }
    
    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }

    public Map<Integer, LocalTime> getHorasConCodigo() {
        return horasConCodigo;
    }

    public void setHorasConCodigo(Map<Integer, LocalTime> horasConCodigo) {
        this.horasConCodigo = horasConCodigo;
    }
    
    // Ejemplo para usar la funcion de obtener los procedimientos
    
//    LocalTime horaInicio = LocalTime.of(8, 30); // Por ejemplo, 8:00 AM
//    LocalTime horaFin = LocalTime.of(18, 30); // Por ejemplo, 6:00 PM
//    generarMapaHorasConCodigo(horaInicio, horaFin); 
    
    private static Map<Integer, LocalTime> generarMapaHorasConCodigo(LocalTime inicio, LocalTime fin) {

        Map<Integer, LocalTime> horasConCodigo = new HashMap<>();
        LocalTime horaActual = inicio;
        int codigo = 1; // Inicializar el código

        while (horaActual.isBefore(fin)) {
            horasConCodigo.put(codigo, horaActual);
            horaActual = horaActual.plusHours(1);
            codigo++; // Incrementar el código para la siguiente hora
        }
        
        return horasConCodigo;

//        // Imprimir el mapa (solo para verificar)
//        for (Map.Entry<Integer, LocalTime> entry : horasConCodigo.entrySet()) {
//            int codigoHora = entry.getKey();
//            LocalTime hora = entry.getValue();
//            System.out.println("Código: " + codigoHora + ", Hora: " + hora);
//        }
    }

    public static boolean tieneMinutos(Duration duracion) {
        return duracion.getSeconds() % 3600 != 0; // Verificar si hay minutos en la duración
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Horario para ").append(getDia()).append(": de ").append(getInicio()).append(" a ").append(getFin()).append("\n");
        sb.append("Horarios del día:\n");
        for (Map.Entry<Integer, LocalTime> entry : getHorasConCodigo().entrySet()) {
            sb.append("Código: ").append(entry.getKey()).append(", Hora: ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }
    
}
