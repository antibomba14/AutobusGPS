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

    // METODO PARA GUARDAR LOS DATOS EN UN ARCHIVO CSV
    public static void guardarEnCSV(String nombreArchivo, List<DatosGPS> listaDatos) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            // Escribir la cabecera
            escritor.write("idAutobus,timestamp,latitud,longitud,velocidad");
            escritor.newLine();

            // Escribir cada registro de datos en el archivo CSV
            for (DatosGPS dato : listaDatos) {
                escritor.write(String.format("%s,%s,%f,%f,%f",
                        dato.getIdAutobus(),
                        dato.getMarcaTiempo(),
                        dato.getLatitud(),
                        dato.getLongitud(),
                        dato.getVelocidad()));
                escritor.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo CSV: " + e.getMessage());
        }
    }
}
