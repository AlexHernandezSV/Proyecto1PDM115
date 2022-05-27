package com.example.proyecto1pdm115;

public class TipoActividad {
    private String id_tipo_actividad;
    private String nombre_tipo_actividad;

    public TipoActividad(){

    }
    public TipoActividad(String id_tipo_actividad, String nombre_tipo_actividad) {
        this.id_tipo_actividad = id_tipo_actividad;
        this.nombre_tipo_actividad = nombre_tipo_actividad;
    }

    public String getId_tipo_actividad() {
        return id_tipo_actividad;
    }

    public void setId_tipo_actividad(String id_tipo_actividad) {
        this.id_tipo_actividad = id_tipo_actividad;
    }

    public String getNombre_tipo_actividad() {
        return nombre_tipo_actividad;
    }

    public void setNombre_tipo_actividad(String nombre_tipo_actividad) {
        this.nombre_tipo_actividad = nombre_tipo_actividad;
    }
}
