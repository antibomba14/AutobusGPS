package mantenimiento;

import captura.DatosGPS;
import almacenamiento.AlmacenamientoDatos;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class ActualizadorDatos {

    private static final Random random = new Random();

    // METODO PARA SIMULAR LOS CAMBIOS DE RECORRIDO DE UN AUTOBUS
    public static void actualizarRecorrido() {
        List<DatosGPS> datosGPS = AlmacenamientoDatos.cargarDesdeCSV("datos_gps.csv");
        if (datosGPS != null && !datosGPS.isEmpty()) {
            // Seleccionar un registro aleatorio para actualizar
            DatosGPS datoSeleccionado = datosGPS.get(random.nextInt(datosGPS.size()));

            // Actualizar los datos aleatoriamente
            datoSeleccionado.setLatitud(generarLatitudAleatoria());
            datoSeleccionado.setLongitud(generarLongitudAleatoria());
            datoSeleccionado.setVelocidad(generarVelocidadAleatoria());
            datoSeleccionado.getMarcaTiempo();

            // Mostrar qué autobús fue actualizado
            System.out.println("Recorrido del autobús actualizado: ID " + datoSeleccionado.getIdAutobus() + "\n"
                    + "Latitud:  " + datoSeleccionado.getLatitud() + "\n"
                    + "Longitud:  " + datoSeleccionado.getLongitud() + "\n"
                    + "Velocidad:  " + datoSeleccionado.getVelocidad() + "\n"
                    + "Tiempo: " + datoSeleccionado.getMarcaTiempo());

            // Guardar los datos actualizados
            guardarDatos(datosGPS);

            System.out.println("Recorrido del autobús actualizado.");
        } else {
            System.out.println("No se encontraron datos para actualizar.");
        }
    }

    // Método para generar una latitud aleatoria (simulada)
    private static double generarLatitudAleatoria() {
        return random.nextDouble() * (90.0 - (-90.0)) + (-90.0); // Rango de latitud entre -90 y 90
    }

    // Método para generar una longitud aleatoria (simulada)
    private static double generarLongitudAleatoria() {
        return random.nextDouble() * (180.0 - (-180.0)) + (-180.0); // Rango de longitud entre -180 y 180
    }

    // Método para generar una velocidad aleatoria entre 0 y 100 km/h
    private static double generarVelocidadAleatoria() {
        return random.nextDouble() * 100; // Rango de velocidad entre 0 y 100 km/h
    }
    // Método para guardar los datos actualizados en el archivo CSV
    private static void guardarDatos(List<DatosGPS> datosGPS) {
        File archivo = new File("datos_gps.csv");
        try (FileWriter writer = new FileWriter(archivo)) {
            // Escribir los datos en el archivo CSV
            for (DatosGPS dato : datosGPS) {
                writer.write(dato.getIdAutobus() + "," + dato.getMarcaTiempo() + "," + dato.getLatitud() + "," +
                        dato.getLongitud() + "," + dato.getVelocidad() + "\n");
            }
            System.out.println("Datos actualizados guardados en el archivo.");
        } catch (IOException e) {
            System.err.println("Error al guardar los datos actualizados: " + e.getMessage());
        }
    }
}
