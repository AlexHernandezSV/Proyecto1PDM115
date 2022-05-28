package com.example.proyecto1pdm115;

public class Encargado {

    private String id_reservante;
    private String id_usuario;
    private String nombre_reservante;
    private  String tipo_reservante;

    public Encargado() {
    }

    public Encargado(String id_reservante, String id_usuario, String nombre_reservante, String tipo_reservante) {
        this.id_reservante = id_reservante;
        this.id_usuario = id_usuario;
        this.nombre_reservante = nombre_reservante;
        this.tipo_reservante = tipo_reservante;
    }

    public String getId_reservante() {
        return id_reservante;
    }

    public void setId_reservante(String id_reservante) {
        this.id_reservante = id_reservante;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_reservante() {
        return nombre_reservante;
    }

    public void setNombre_reservante(String nombre_reservante) {
        this.nombre_reservante = nombre_reservante;
    }

    public String getTipo_reservante() {
        return tipo_reservante;
    }

    public void setTipo_reservante(String tipo_reservante) {
        this.tipo_reservante = tipo_reservante;
    }
}

