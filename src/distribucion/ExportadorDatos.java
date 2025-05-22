package distribucion;

import captura.DatosGPS;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class ExportadorDatos {

    public static void exportarUltimaPosicion(List<DatosGPS> listaDatos) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();

        for (DatosGPS datos : listaDatos) {
            String nombreArchivo = datos.getIdAutobus() + "_datos_bus.json";
            String json = gson.toJson(datos);

            try (FileWriter writer = new FileWriter(nombreArchivo)) {
                writer.write(json);
                System.out.println("Archivo exportado con éxito: " + nombreArchivo);
            } catch (IOException e) {
                System.err.println("Error al exportar el archivo: " + e.getMessage());
            }
        }
    }
}
