package com.example.proyecto1pdm115;

public class DetalleActividadHorario {
    private int id_horario;
    private int id_actividad;

    public DetalleActividadHorario() {
    }

    public DetalleActividadHorario(int id_horario, int id_actividad) {
        this.id_horario = id_horario;
        this.id_actividad = id_actividad;
    }

    public int getId_horario() {
        return id_horario;
    }

    public int getId_actividad() {
        return id_actividad;
    }

    public void setId_horario(int id_horario) {
        this.id_horario = id_horario;
    }

    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
    }
}
