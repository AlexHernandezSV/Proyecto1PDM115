package com.example.proyecto1pdm115;

import java.util.Date;

public class Actividad {
    private String id_actividad;
    private String id_tipo_actividad;
    private String id_valoracion;
    private String id_reservante;
    private String grupo;
    private String descripcion;
    private String estado;
    private String fecha_actividad;
    private String desde_actividad;
    private String hasta_actividad;

    public Actividad(){
    }

    public Actividad(String id_actividad, String id_tipo_actividad, String id_valoracion, String id_reservante, String grupo, String descripcion, String estado, String fecha_actividad, String desde_actividad, String hasta_actividad) {

    }

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

    public String getId_tipo_actividad() {
        return id_tipo_actividad;
    }

    public void setId_tipo_actividad(String id_tipo_actividad) {
        this.id_tipo_actividad = id_tipo_actividad;
    }

    public String getId_valoracion() {
        return id_valoracion;
    }

    public void setId_valoracion(String id_valoracion) {
        this.id_valoracion = id_valoracion;
    }

    public String getId_reservante() {
        return id_reservante;
    }

    public void setId_reservante(String id_reservante) {
        this.id_reservante = id_reservante;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
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

    public String getFecha_actividad() {
        return fecha_actividad;
    }

    public void setFecha_actividad(String fecha_actividad) {
        this.fecha_actividad = fecha_actividad;
    }

    public String getDesde_actividad() {
        return desde_actividad;
    }

    public void setDesde_actividad(String desde_actividad) {
        this.desde_actividad = desde_actividad;
    }

    public String getHasta_actividad() {
        return hasta_actividad;
    }

    public void setHasta_actividad(String hasta_actividad) {
        this.hasta_actividad = hasta_actividad;
    }
}
