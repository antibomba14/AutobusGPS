package captura;

import java.time.LocalDateTime;

public class DatosGPS {
    private String idAutobus;
    private LocalDateTime marcaTiempo;
    private double latitud;
    private double longitud;
    private double velocidad;

    public DatosGPS(String idAutobus, LocalDateTime marcaTiempo, double latitud, double longitud, double velocidad) {
        this.idAutobus = idAutobus;
        this.marcaTiempo = marcaTiempo;
        this.latitud = latitud;
        this.longitud = longitud;
        this.velocidad = velocidad;
    }

    public String getIdAutobus() {
        return idAutobus;
    }

    public LocalDateTime getMarcaTiempo() {
        return marcaTiempo;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setIdAutobus(String idAutobus) {
        this.idAutobus = idAutobus;
    }

    public void setMarcaTiempo(LocalDateTime marcaTiempo) {
        this.marcaTiempo = marcaTiempo;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return idAutobus + "," +
                marcaTiempo + "," +
                latitud + "," +
                longitud + "," +
                velocidad;
    }
}
