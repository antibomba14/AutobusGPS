package principal;

import captura.GeneradorDatosGPS;
import captura.DatosGPS;
import almacenamiento.AlmacenamientoDatos;
import visualizacion.VisorConsola;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Paso 1: Generar datos GPS simulados
        System.out.println("Generando datos GPS simulados...");
        GeneradorDatosGPS generador = new GeneradorDatosGPS();
        generador.generarDatos();

        // Paso 2: Cargar los datos desde el archivo CSV
        System.out.println("Cargando los datos desde el archivo CSV...");
        List<DatosGPS> listaDatos = AlmacenamientoDatos.cargarDesdeCSV("datos_gps.csv");

        // Paso 3: Mostrar los trayectos de los autobuses
        System.out.println("Mostrando los trayectos de los autobuses...");
        VisorConsola.mostrarTrayectos(listaDatos);

        // Paso 4: Mostrar las estadísticas de los autobuses
        System.out.println("Mostrando estadísticas...");
        VisorConsola.mostrarEstadisticas(listaDatos);
    }
}
