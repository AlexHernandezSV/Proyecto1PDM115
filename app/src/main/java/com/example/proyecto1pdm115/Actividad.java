package com.example.proyecto1pdm115;

import java.util.Date;

public class Actividad {
    private Integer id_actividad;
    private Integer id_tipo_actividad;
    private Integer id_valoracion;
    private Integer id_reservante;
    private char grupo;
    private String descripcion;
    private String estado;
    private Date fecha_actividad;
    private Date desde_actividad;
    private Date hasta_actividad;

    public Actividad(){
    }

    public Actividad(char id_actividad, int id_tipo_actividad, int id_valoracion, int id_reservante, char grupo, char descripcion, char estado, int fecha_actividad, int desde_actividad, int hasta_actividad) {

    }

    public Integer getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(Integer id_actividad) {
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_actividad() {
        return fecha_actividad;
    }

    public void setFecha_actividad(Date fecha_actividad) {
        this.fecha_actividad = fecha_actividad;
    }

    public Date getDesde_actividad() {
        return desde_actividad;
    }

    public void setDesde_actividad(Date desde_actividad) {
        this.desde_actividad = desde_actividad;
    }

    public Date getHasta_actividad() {
        return hasta_actividad;
    }

    public void setHasta_actividad(Date hasta_actividad) {
        this.hasta_actividad = hasta_actividad;
    }
}
