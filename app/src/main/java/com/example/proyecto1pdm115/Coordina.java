package com.example.proyecto1pdm115;

public class Coordina {
    private int id_actividad;
    private int id_coordinador;

    public Coordina() {
    }

    public Coordina(int id_actividad, int id_coordinador) {
        this.id_actividad = id_actividad;
        this.id_coordinador = id_coordinador;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public int getId_coordinador() {
        return id_coordinador;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }

    public void setId_coordinador(int id_coordinador) {
        this.id_coordinador = id_coordinador;
    }
}
