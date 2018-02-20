package com.example.manolo.requestvolleyweather;

/**
 * Created by Manolo on 20/02/2018.
 */

public class DatosMeteorologicos {
    private String temperatura;
    private String presion;
    private String humedad;
    private String nubosidad;
    private String icono;
    private String velocidadViento;
    private String direccionViento;
    private String aspecto;
    private String fechaHora;

    public DatosMeteorologicos(String temperatura, String presion, String humedad, String nubosidad, String icono, String velocidadViento, String direccionViento, String aspecto, String fechaHora) {
        this.temperatura = temperatura;
        this.presion = presion;
        this.humedad = humedad;
        this.nubosidad = nubosidad;
        this.icono = icono;
        this.velocidadViento = velocidadViento;
        this.direccionViento = direccionViento;
        this.aspecto = aspecto;
        this.fechaHora = fechaHora;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getNubosidad() {
        return nubosidad;
    }

    public void setNubosidad(String nubosidad) {
        this.nubosidad = nubosidad;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getVelocidadViento() {
        return velocidadViento;
    }

    public void setVelocidadViento(String velocidadViento) {
        this.velocidadViento = velocidadViento;
    }

    public String getDireccionViento() {
        return direccionViento;
    }

    public void setDireccionViento(String direccionViento) {
        this.direccionViento = direccionViento;
    }

    public String getAspecto() {
        return aspecto;
    }

    public void setAspecto(String aspecto) {
        this.aspecto = aspecto;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }
}
