package wiyu.barberia_poo.Clases;

import java.time.Duration;
import java.time.LocalTime;

/**
 *
 * @author maria
 */
public class HorarioBarberia {
    
    public static long calcularHoras(LocalTime horaInicio, LocalTime horaSalida) {
        // Calcular la diferencia de tiempo
        Duration duracion = Duration.between(horaInicio, horaSalida);
        
        // Verificar si los minutos son diferentes de cero
        if (tieneMinutos(duracion)) {
            throw new IllegalArgumentException("Error: La diferencia de tiempo no puede tener minutos.");
        }
        
        // Obtener las horas de la duración
        long horas = duracion.toHours();
        
        return horas;
    }
    
    // Función para verificar si la duración tiene minutos
    public static boolean tieneMinutos(Duration duracion) {
        return duracion.toMinutes() % 60 != 0;
    }
    
}
