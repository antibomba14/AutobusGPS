package captura;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

public class GeneradorDatosGPS {

    private static final String[] AUTOBUSES = {"BUS01", "BUS02", "BUS03"};
    private static final int DURACION_MINUTOS = 60;
    private static final String ARCHIVO_CSV = "datos_gps.csv";

    public static void generarDatos() {
        try (FileWriter escritor = new FileWriter(ARCHIVO_CSV)) {
            escritor.write("idAutobus, marcaTiempo, latitud, longitud, velocidad\n");

            LocalDateTime inicio = LocalDateTime.of(2025, 3, 25, 8, 0);
            Random aleatorio = new Random();

            for (String autobus : AUTOBUSES) {
                LocalDateTime tiempoActual = inicio;

                for (int i = 0; i < DURACION_MINUTOS; i++) {
                    double latitud = 40.40 + aleatorio.nextDouble() * 0.01;
                    double longitud = -3.70 - aleatorio.nextDouble() * 0.01;
                    double velocidad;
                    if (aleatorio.nextDouble() < 0.25) { // 25% de probabilidad de parada
                        velocidad = 0;
                    } else {
                        velocidad = 10 + aleatorio.nextDouble() * 40; // velocidad entre 10 y 40 km/h
                    }

                    DatosGPS dato = new DatosGPS(autobus, tiempoActual, latitud, longitud, velocidad);
                    escritor.write(dato.toString() + "\n");

                    tiempoActual = tiempoActual.plusMinutes(1);
                }
            }

            System.out.println("Datos GPS simulados generados correctamente en '" + ARCHIVO_CSV + "'.");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo CSV: " + e.getMessage());
        }
    }
}
