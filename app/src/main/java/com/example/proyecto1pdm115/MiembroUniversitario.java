package com.example.proyecto1pdm115;

public class MiembroUniversitario {
    private Integer id_coordinador;
    private String nombre_coordinador;
    private String tipo_miembro;

    public MiembroUniversitario(){
    }

    public MiembroUniversitario(Integer id_coordinador, String nombre_coordinador, String tipo_miembro) {
        this.id_coordinador = id_coordinador;
        this.nombre_coordinador = nombre_coordinador;
        this.tipo_miembro = tipo_miembro;
    }

    public Integer getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(Integer id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getNombre_coordinador() {
        return nombre_coordinador;
    }

    public void setNombre_coordinador(String nombre_coordinador) {
        this.nombre_coordinador = nombre_coordinador;
    }

    public String getTipo_miembro() {
        return tipo_miembro;
    }

    public void setTipo_miembro(String tipo_miembro) {
        this.tipo_miembro = tipo_miembro;
    }
}
