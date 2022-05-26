package com.example.proyecto1pdm115;

public class DetalleResponsable {
    private char id_detalle_responsable;
    private char id_coordinador;
    private char nomb_tipo_responsable;

    public DetalleResponsable(){

    }

    public DetalleResponsable(char id_detalle_responsable, char id_coordinador, char nomb_tipo_responsable) {
        this.id_detalle_responsable = id_detalle_responsable;
        this.id_coordinador = id_coordinador;
        this.nomb_tipo_responsable = nomb_tipo_responsable;
    }

    public char getId_detalle_responsable() {
        return id_detalle_responsable;
    }

    public void setId_detalle_responsable(char id_detalle_responsable) {
        this.id_detalle_responsable = id_detalle_responsable;
    }

    public char getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(char id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public char getNomb_tipo_responsable() {
        return nomb_tipo_responsable;
    }

    public void setNomb_tipo_responsable(char nomb_tipo_responsable) {
        this.nomb_tipo_responsable = nomb_tipo_responsable;
    }
}


