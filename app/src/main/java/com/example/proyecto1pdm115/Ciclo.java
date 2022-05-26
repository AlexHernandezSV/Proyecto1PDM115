package com.example.proyecto1pdm115;

import java.util.Date;

public class Ciclo {
    public int getId_ciclo() {
        return id_ciclo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setId_ciclo(int id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    private int id_ciclo;
    private String ciclo;
    private Date fecha_inicio;
    private Date fecha_fin;

    public Ciclo() {
    }

    public Ciclo(int id_ciclo, String ciclo, Date fecha_inicio, Date fecha_fin) {
        this.id_ciclo = id_ciclo;
        this.ciclo = ciclo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
}
