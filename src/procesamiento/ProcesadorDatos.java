package procesamiento;

import captura.DatosGPS;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ProcesadorDatos {

    // Filtra por ID de autobús
    public static List<DatosGPS> filtrarPorAutobus(List<DatosGPS> lista, String idAutobus) {
        return lista.stream()
                .filter(d -> d.getIdAutobus().equalsIgnoreCase(idAutobus))
                .collect(Collectors.toList());
    }

    // Filtra por rango de fecha y hora
    public static List<DatosGPS> filtrarPorRangoHorario(List<DatosGPS> lista, LocalDateTime inicio, LocalDateTime fin) {
        return lista.stream()
                .filter(d -> !d.getMarcaTiempo().isBefore(inicio) && !d.getMarcaTiempo().isAfter(fin))
                .collect(Collectors.toList());
    }

    // Valida si un dato es correcto
    public static boolean datoValido(DatosGPS dato) {
        boolean coordenadasValidas = dato.getLatitud() >= -90 && dato.getLatitud() <= 90 &&
                dato.getLongitud() >= -180 && dato.getLongitud() <= 180;
        boolean velocidadValida = dato.getVelocidad() >= 0 && dato.getVelocidad() <= 120;
        return coordenadasValidas && velocidadValida;
    }

    // Elimina datos inválidos
    public static List<DatosGPS> eliminarDatosInvalidos(List<DatosGPS> lista) {
        return lista.stream()
                .filter(ProcesadorDatos::datoValido)
                .collect(Collectors.toList());
    }
}
