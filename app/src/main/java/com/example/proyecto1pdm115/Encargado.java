package com.example.proyecto1pdm115;

public class Encargado {

    private Integer id_reservante;
    private char id_usuario;
    private String nombre_reservante;
    private  String tipo_reservante;

    public Encargado() {
    }

    public Encargado(Integer id_reservante, char id_usuario, String nombre_reservante, String tipo_reservante) {
        this.id_reservante = id_reservante;
        this.id_usuario = id_usuario;
        this.nombre_reservante = nombre_reservante;
        this.tipo_reservante = tipo_reservante;
    }

    public Integer getId_reservante() {
        return id_reservante;
    }

    public void setId_reservante(Integer id_reservante) {
        this.id_reservante = id_reservante;
    }

    public char getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(char id_usuario) {
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

