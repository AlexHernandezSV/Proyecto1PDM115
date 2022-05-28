package com.example.proyecto1pdm115;

public class DetalleActividad {

    private String id_detalle_actividad;
    private String id_aula;
    private String id_actividad;
    private Integer participantes;

    public DetalleActividad() {
    }

    public DetalleActividad(String id_detalle_actividad, String id_aula, String id_actividad, Integer participantes) {
        this.id_detalle_actividad = id_detalle_actividad;
        this.id_aula = id_aula;
        this.id_actividad = id_actividad;
        this.participantes = participantes;
    }

    public String getId_detalle_actividad() {
        return id_detalle_actividad;
    }

    public void setId_detalle_actividad(String id_detalle_actividad) {
        this.id_detalle_actividad = id_detalle_actividad;
    }

    public String getId_aula() {
        return id_aula;
    }

    public void setId_aula(String id_aula) {
        this.id_aula = id_aula;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }

    public Integer getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }
}
