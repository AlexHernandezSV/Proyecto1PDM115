package com.example.proyecto1pdm115;

public class Escuela {
    private String id_escuela;
    private String id_carrera;
    private String nombre_escuela;

    public Escuela(){

    }

    public Escuela(String id_escuela, String id_carrera, String nombre_escuela) {
        this.id_escuela = id_escuela;
        this.id_carrera = id_carrera;
        this.nombre_escuela = nombre_escuela;
    }

    public String getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(String id_escuela) {
        this.id_escuela = id_escuela;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getNombre_escuela() {
        return nombre_escuela;
    }

    public void setNombre_escuela(String nombre_escuela) {
        this.nombre_escuela = nombre_escuela;
    }
}
