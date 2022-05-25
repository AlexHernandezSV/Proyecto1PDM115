package com.example.proyecto1pdm115;

public class DetalleActividad {

    private Integer id_detalle_actividad;
    private Integer id_aula;
    private Integer id_actividad;
    private Integer participantes;

    public DetalleActividad() {
    }

    public DetalleActividad(Integer id_detalle_actividad, Integer id_aula, Integer id_actividad, Integer participantes) {
        this.id_detalle_actividad = id_detalle_actividad;
        this.id_aula = id_aula;
        this.id_actividad = id_actividad;
        this.participantes = participantes;
    }

    public Integer getId_detalle_actividad() {
        return id_detalle_actividad;
    }

    public void setId_detalle_actividad(Integer id_detalle_actividad) {
        this.id_detalle_actividad = id_detalle_actividad;
    }

    public Integer getId_aula() {
        return id_aula;
    }

    public void setId_aula(Integer id_aula) {
        this.id_aula = id_aula;
    }

    public Integer getId_actividad() {
        return id_actividad;
    }

    public void setId_actividad(Integer id_actividad) {
        this.id_actividad = id_actividad;
    }

    public Integer getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Integer participantes) {
        this.participantes = participantes;
    }
}
