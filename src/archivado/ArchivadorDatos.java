package archivado;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


public class ArchivadorDatos {

    private static final String CARPETA_ARCHIVO = "archivados"; // Carpeta de archivado
    private static final int DIAS_LIMITE = 7; // Limite de días para eliminar archivos

    // METODO PARA ARCHIVAR ARCHIVOS ANTIGUOS
    public static void archivarArchivosAntiguos() {
        File carpeta = new File("."); // Carpeta actual donde están los archivos
        File[] archivos = carpeta.listFiles((dir, nombre) -> nombre.endsWith("datos_gps.csv"));

        if (archivos != null) {
            for (File archivo : archivos) {
                // Verificar si el archivo tiene más de 7 días de antigüedad
                if (esAntiguo(archivo)) {
                    // Archivar el archivo moviéndolo a la carpeta "archivados"
                    moverArchivoACarpeta(archivo);
                }
            }
        }
    }

    // METODO PARA ELIMINAR ARCHIVOS QUE TENGAN MAS DE 7 DIAS DE ANTIGUEDAD
    public static void eliminarArchivosAntiguos() {
        File carpeta = new File(CARPETA_ARCHIVO);
        if (carpeta.exists()) {
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    if (esAntiguo(archivo)) {
                        // Eliminar archivo si tiene más de 7 días de antigüedad
                        if (archivo.delete()) {
                            System.out.println("Archivo eliminado: " + archivo.getName());
                        } else {
                            System.out.println("Error al eliminar el archivo: " + archivo.getName());
                        }
                    }
                }
            }
        }
    }

    // Verifica si el archivo tiene más de 7 días de antigüedad
    private static boolean esAntiguo(File archivo) {
        long tiempoActual = System.currentTimeMillis();
        long tiempoArchivo = archivo.lastModified();
        long diferenciaEnDias = (tiempoActual - tiempoArchivo) / (1000 * 60 * 60 * 24);

        return diferenciaEnDias > DIAS_LIMITE;
    }

    // Mover archivo a la carpeta "archivados"
    private static void moverArchivoACarpeta(File archivo) {
        File carpetaArchivos = new File(CARPETA_ARCHIVO);
        if (!carpetaArchivos.exists()) {
            carpetaArchivos.mkdirs(); // Crear la carpeta si no existe
        }

        File archivoDestino = new File(carpetaArchivos, archivo.getName());
        try {
            Files.move(archivo.toPath(), archivoDestino.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo archivado: " + archivo.getName());
        } catch (IOException e) {
            System.err.println("Error al mover el archivo: " + archivo.getName());
        }
    }
}
