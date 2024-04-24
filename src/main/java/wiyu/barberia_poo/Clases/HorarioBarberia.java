package wiyu.barberia_poo.Clases;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author maria
 */
public class HorarioBarberia {
    
    // Ejemplo para usar la funcion de obtener los procedimientos
    
//    LocalTime horaInicio = LocalTime.of(8, 30); // Por ejemplo, 8:00 AM
//    LocalTime horaFin = LocalTime.of(18, 30); // Por ejemplo, 6:00 PM
//    generarMapaHorasConCodigo(horaInicio, horaFin); 
    
    public static void generarMapaHorasConCodigo(LocalTime inicio, LocalTime fin) {
        Duration duracion = Duration.between(inicio, fin);
        if (tieneMinutos(duracion)) {
            throw new IllegalArgumentException("Horario inválido, el rango de horarios tiene que tener horas exactas para poder brindar su servicio");
        }

        Map<Integer, LocalTime> horasConCodigo = new HashMap<>();
        LocalTime horaActual = inicio;
        int codigo = 1; // Inicializar el código

        while (horaActual.isBefore(fin)) {
            horasConCodigo.put(codigo, horaActual);
            horaActual = horaActual.plusHours(1);
            codigo++; // Incrementar el código para la siguiente hora
        }

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
    
}
