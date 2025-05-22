package almacenamiento;

import captura.DatosGPS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AlmacenamientoDatos {

    //METODO PARA CARGAR LOS DATOS DESDE UN ARCHIVO CSV
    public static List<DatosGPS> cargarDesdeCSV(String nombreArchivo) {
        List<DatosGPS> lista = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea = lector.readLine(); // Saltar cabecera

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 5) {
                    String idAutobus = partes[0];
                    LocalDateTime marcaTiempo = LocalDateTime.parse(partes[1]);
                    double latitud = Double.parseDouble(partes[2]);
                    double longitud = Double.parseDouble(partes[3]);
                    double velocidad = Double.parseDouble(partes[4]);

                    DatosGPS dato = new DatosGPS(idAutobus, marcaTiempo, latitud, longitud, velocidad);
                    lista.add(dato);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return lista;
    }
}
