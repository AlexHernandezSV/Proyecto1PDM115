package com.example.proyecto1pdm115;

public class Coordina {
    private String id_actividad;
    private String id_coordinador;

    public Coordina() {
    }

    public Coordina(String id_actividad, String id_coordinador) {
        this.id_actividad = id_actividad;
        this.id_coordinador = id_coordinador;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public String getId_coordinador() {
        return id_coordinador;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

    public void setId_coordinador(String id_coordinador) {
        this.id_coordinador = id_coordinador;
    }
}
