package com.example.proyecto1pdm115;

public class Materia {
    private char id_materia;
    private int id_escuela;
    private String nombre_materia;
    private int ciclo_materia;

    public Materia() {
    }

    public Materia(char id_materia, int id_escuela, String nombre_materia, int ciclo_materia) {
        this.id_materia = id_materia;
        this.id_escuela = id_escuela;
        this.nombre_materia = nombre_materia;
        this.ciclo_materia = ciclo_materia;
    }

    public char getId_materia() {
        return id_materia;
    }

    public void setId_materia(char id_materia) {
        this.id_materia = id_materia;
    }

    public int getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(int id_escuela) {
        this.id_escuela = id_escuela;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

    public int getCiclo_materia() {
        return ciclo_materia;
    }

    public void setCiclo_materia(int ciclo_materia) {
        this.ciclo_materia = ciclo_materia;
    }
}
