package com.example.proyecto1pdm115;

import java.util.Date;

public class Ciclo {
    public String getId_ciclo() {
        return id_ciclo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setId_ciclo(String id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    private String id_ciclo;
    private String ciclo;
    private String fecha_inicio;
    private String fecha_fin;

    public Ciclo() {
    }

    public Ciclo(String id_ciclo, String ciclo, String fecha_inicio, String fecha_fin) {
        this.id_ciclo = id_ciclo;
        this.ciclo = ciclo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
}
