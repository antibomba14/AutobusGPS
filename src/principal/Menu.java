package principal;

import archivado.ArchivadorDatos;
import captura.DatosGPS;
import captura.GeneradorDatosGPS;
import almacenamiento.AlmacenamientoDatos;
import distribucion.ExportadorDatos;
import mantenimiento.ActualizadorDatos;
import visualizacion.VisorConsola;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static List<DatosGPS> listaDatos;

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Generar datos GPS simulados");
            System.out.println("2. Cargar datos desde archivo CSV");
            System.out.println("3. Exportar datos a JSON");
            System.out.println("4. Mostrar trayectos de los autobuses");
            System.out.println("5. Mostrar estadísticas de los autobuses");
            System.out.println("6. Archivar archivos antiguos");
            System.out.println("7. Eliminar archivos de la carpeta 'archivados' con más de 7 días");
            System.out.println("8. Modificar parámetros de los autobuses");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Generando datos GPS simulados...");
                    GeneradorDatosGPS generador = new GeneradorDatosGPS();
                    generador.generarDatos();
                    break;
                case 2:
                    System.out.println("Cargando los datos desde el archivo CSV...");
                    listaDatos = AlmacenamientoDatos.cargarDesdeCSV("datos_gps.csv");
                    break;
                case 3:
                    if (listaDatos == null || listaDatos.isEmpty()) {
                        System.out.println("Primero debes cargar los datos (opción 2).");
                    } else {
                        System.out.println("Exportando datos en formato JSON...");
                        ExportadorDatos.exportarUltimaPosicion(listaDatos);
                    }
                    break;
                case 4:
                    if (listaDatos == null || listaDatos.isEmpty()) {
                        System.out.println("Primero debes cargar los datos (opción 2).");
                    } else {
                        System.out.println("Mostrando trayectos de los autobuses...");
                        VisorConsola.mostrarTrayectos(listaDatos);
                    }
                    break;
                case 5:
                    if (listaDatos == null || listaDatos.isEmpty()) {
                        System.out.println("Primero debes cargar los datos (opción 2).");
                    } else {
                        System.out.println("Mostrando estadísticas...");
                        VisorConsola.mostrarEstadisticas(listaDatos);
                    }
                    break;
                case 6:
                    ArchivadorDatos.archivarArchivosAntiguos();
                    break;
                case 7:
                    ArchivadorDatos.eliminarArchivosAntiguos();
                    break;
                case 8:
                    ActualizadorDatos.actualizarRecorrido();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 9);
    }
}
