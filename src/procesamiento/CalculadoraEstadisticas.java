package procesamiento;

import captura.DatosGPS;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalculadoraEstadisticas {

    // METODO PARA OBTENER LOS ID DE LOS AUTOBUSES
    public Set<String> obtenerIdsUnicos(List<DatosGPS> datosGPSList) {
        Set<String> ids = new HashSet<>();
        for (DatosGPS dato : datosGPSList) {
            ids.add(dato.getIdAutobus());
        }
        return ids;
    }

    // METODO PARA CALCULAR LA VELOCIDAD MEDIA DE UN AUTOBUS
    public double calcularVelocidadMedia(String busId, List<DatosGPS> datosGPSList) {
        double sumaVelocidades = 0;
        int cantidadRegistros = 0;

        for (DatosGPS dato : datosGPSList) {
            if (dato.getIdAutobus().equals(busId)) {
                sumaVelocidades += dato.getVelocidad();
                cantidadRegistros++;
            }
        }

        if (cantidadRegistros == 0) {
            return 0; // Evitar división por cero
        }

        return sumaVelocidades / cantidadRegistros;
    }

    // METODO PARA CONTAR EL NUMERO DE PARADAS DE UN AUTOBUS
    public int contarParadas(String busId, List<DatosGPS> datosGPSList) {
        int paradas = 0;
        final double TOLERANCIA_VELOCIDAD = 0.5; // Definimos un margen de tolerancia para considerar "parada"

        for (DatosGPS dato : datosGPSList) {
            if (dato.getIdAutobus().equals(busId) && Math.abs(dato.getVelocidad()) <= TOLERANCIA_VELOCIDAD) {
                paradas++;
            }
        }

        return paradas;
    }
}
