package visualizacion;

import captura.DatosGPS;
import procesamiento.CalculadoraEstadisticas;
import java.util.List;

public class VisorConsola {

    // METODO PARA MOSTRAR LOS TRAYECTOS DE TODOS LOS AUTOBUSES
    public static void mostrarTrayectos(List<DatosGPS> datosGPSList) {
        System.out.println("Trayectos de los autobuses:");
        for (DatosGPS dato : datosGPSList) {
            System.out.println("Bus ID: " + dato.getIdAutobus());
            System.out.println("Timestamp:  " + dato.getMarcaTiempo());
            System.out.println("Latitud:  " + dato.getLatitud());
            System.out.println("Longitud:  " + dato.getLongitud());
            System.out.println("Velocidad:  " + dato.getVelocidad());
            System.out.println("------------");
        }
    }

    // METODO PARA MOSTRAR ESTADISTICAS DE LOS AUTOBUSES
    public static void mostrarEstadisticas(List<DatosGPS> datosGPSList) {
        // Calcular la velocidad media y número de paradas utilizando la clase CalculadoraEstadisticas
        CalculadoraEstadisticas calc = new CalculadoraEstadisticas();

        // Mostrar la velocidad media de cada autobús
        System.out.println("Estadísticas de velocidad media de los autobuses:");
        for (String busId : calc.obtenerIdsUnicos(datosGPSList)) {
            double velocidadMedia = calc.calcularVelocidadMedia(busId, datosGPSList);
            System.out.println("Bus ID: " + busId + " - Velocidad media: " + velocidadMedia + " km/h");
        }

        // Mostrar número de paradas por autobús
        System.out.println("Estadísticas de paradas:");
        for (String busId : calc.obtenerIdsUnicos(datosGPSList)) {
            int paradas = calc.contarParadas(busId, datosGPSList);
            System.out.println("Bus ID: " + busId + " - Número de paradas: " + paradas);
        }
    }
}
