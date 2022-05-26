package com.example.proyecto1pdm115;

import java.util.Date;

public class Horario {
    private String id_horario;
    private String desde_horario;
    private String hasta_horario;

    public Horario(){
    }

    public Horario(String id_horario, String desde_horario, String hasta_horario) {
        this.id_horario = id_horario;
        this.desde_horario = desde_horario;
        this.hasta_horario = hasta_horario;
    }

    public String getId_horario() {
        return id_horario;
    }

    public void setId_horario(String id_horario) {
        this.id_horario = id_horario;
    }

    public String getDesde_horario() {
        return desde_horario;
    }

    public void setDesde_horario(String desde_horario) {
        this.desde_horario = desde_horario;
    }

    public String getHasta_horario() {
        return hasta_horario;
    }

    public void setHasta_horario(String hasta_horario) {
        this.hasta_horario = hasta_horario;
    }
}
