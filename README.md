# INTRODUCCION
He creado un proyecto para el Grado Superior de DAM, para la asignatura Digitalización como proyecto final de curso, de un sistema de red de autobuses por GPS, con velocidades medias y paradas.

# ESTRUCTURA DEL PROYECTO 
principal
└── Principal.java               // Método main

captura
├── DatosGPS.java                // Clase que representa un registro de GPS
└── GeneradorDatosGPS.java       // Generador de datos GPS simulados

almacenamiento
└── AlmacenamientoDatos.java     // Guardado/carga de datos desde CSV

procesamiento
├── ProcesadorDatos.java         // Validación y filtrado de datos
└── CalculadoraEstadisticas.java// Cálculos como velocidad media y paradas

distribucion
└── ExportadorDatos.java         // Exportación de última posición en JSON

visualizacion
└── VisorConsola.java            // Mostrar trayectos y estadísticas por consola

mantenimiento
└── ActualizadorDatos.java       // Modificar registros simulando cambios de recorrido

archivado
└── ArchivadorDatos.java         // Archivado de CSV antiguos y eliminación de >7 días


