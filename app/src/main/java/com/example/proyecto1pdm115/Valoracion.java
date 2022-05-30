package com.example.proyecto1pdm115;

public class Valoracion {

    private String id_valoracion;
    private String valoracion;

    public Valoracion() {
    }

    public Valoracion(String id_valoracion, String valoracion) {
        this.id_valoracion = id_valoracion;
        this.valoracion = valoracion;
    }

    public String getId_valoracion() {
        return id_valoracion;
    }

    public void setId_valoracion(String id_valoracion) {
        this.id_valoracion = id_valoracion;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

}
