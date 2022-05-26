package com.example.proyecto1pdm115;

public class Actividad {
    private char id_actividad;
    private int id_tipo_actividad;
    private int id_valoracion;
    private int id_reservante;
    private char grupo;
    private char descripcion;
    private char estado;
    private int fecha_actividad;
    private int desde_actividad;
    private int hasta_actividad;

    public Actividad(){
    }

    public Actividad(char id_actividad, int id_tipo_actividad, int id_valoracion, int id_reservante, char grupo, char descripcion, char estado, int fecha_actividad, int desde_actividad, int hasta_actividad) {

    }

    public char getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(char id_actividad) {
        this.id_actividad = id_actividad;
    }

    public int getId_tipo_actividad() {
        return id_tipo_actividad;
    }

    public void setId_tipo_actividad(int id_tipo_actividad) {
        this.id_tipo_actividad = id_tipo_actividad;
    }

    public int getId_valoracion() {
        return id_valoracion;
    }

    public void setId_valoracion(int id_valoracion) {
        this.id_valoracion = id_valoracion;
    }

    public int getId_reservante() {
        return id_reservante;
    }

    public void setId_reservante(int id_reservante) {
        this.id_reservante = id_reservante;
    }

    public char getGrupo() {
        return grupo;
    }

    public void setGrupo(char grupo) {
        this.grupo = grupo;
    }

    public char getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(char descripcion) {
        this.descripcion = descripcion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getFecha_actividad() {
        return fecha_actividad;
    }

    public void setFecha_actividad(int fecha_actividad) {
        this.fecha_actividad = fecha_actividad;
    }

    public int getDesde_actividad() {
        return desde_actividad;
    }

    public void setDesde_actividad(int desde_actividad) {
        this.desde_actividad = desde_actividad;
    }

    public int getHasta_actividad() {
        return hasta_actividad;
    }

    public void setHasta_actividad(int hasta_actividad) {
        this.hasta_actividad = hasta_actividad;
    }
}
