package com.example.proyecto1pdm115;

public class DetalleActividadHorario {
    private String id_horario;
    private String id_actividad;

    public DetalleActividadHorario() {
    }

    public DetalleActividadHorario(String id_horario, String id_actividad) {
        this.id_horario = id_horario;
        this.id_actividad = id_actividad;
    }

    public String getId_horario() {
        return id_horario;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public void setId_horario(String id_horario) {
        this.id_horario = id_horario;
    }

    public void setId_actividad(String id_actividad) {
        this.id_actividad = id_actividad;
    }
}
