package com.example.proyecto1pdm115;

public class DetalleResponsable {
    private String id_detalle_responsable;
    private String id_coordinador;
    private String nomb_tipo_responsable;

    public DetalleResponsable(){

    }

    public DetalleResponsable(String id_detalle_responsable, String id_coordinador, String nomb_tipo_responsable) {
        this.id_detalle_responsable = id_detalle_responsable;
        this.id_coordinador = id_coordinador;
        this.nomb_tipo_responsable = nomb_tipo_responsable;
    }

    public String getId_detalle_responsable() {
        return id_detalle_responsable;
    }

    public void setId_detalle_responsable(String id_detalle_responsable) {
        this.id_detalle_responsable = id_detalle_responsable;
    }

    public String getId_coordinador() {
        return id_coordinador;
    }

    public void setId_coordinador(String id_coordinador) {
        this.id_coordinador = id_coordinador;
    }

    public String getNomb_tipo_responsable() {
        return nomb_tipo_responsable;
    }

    public void setNomb_tipo_responsable(String nomb_tipo_responsable) {
        this.nomb_tipo_responsable = nomb_tipo_responsable;
    }
}


