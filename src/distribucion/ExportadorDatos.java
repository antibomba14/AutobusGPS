package distribucion;

import captura.DatosGPS;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorDatos {

    // METODO PARA EXPORTAR LOS DATOS DE LA ULTIMA POSICION DE CADA AUTOBUS EN FORMATO JSON
    public static void exportarUltimaPosicion(List<DatosGPS> listaDatos) {
        // Creamos un objeto Gson para convertir a JSON
        Gson gson = new Gson();

        // Recorremos la lista de datos para exportar la última posición de cada autobús
        for (DatosGPS datos : listaDatos) {
            // Creamos un archivo JSON por cada autobús
            String nombreArchivo = datos.getIdAutobus() + "_status.json";

            // Convertimos el objeto DatosGPS a JSON
            String json = gson.toJson(datos);

            // Guardamos el JSON en un archivo
            try (FileWriter writer = new FileWriter(nombreArchivo)) {
                writer.write(json);
                System.out.println("Archivo exportado con éxito: " + nombreArchivo);
            } catch (IOException e) {
                System.err.println("Error al exportar el archivo: " + e.getMessage());
            }
        }
    }
}
