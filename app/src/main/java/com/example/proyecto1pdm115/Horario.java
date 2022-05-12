package com.example.proyecto1pdm115;

import java.util.Date;

public class Horario {
    private Integer id_horario;
    private Date desde_horario;
    private Date hasta_horario;

    public Horario(){
    }

    public Horario(Integer id_horario, Date desde_horario, Date hasta_horario) {
        this.id_horario = id_horario;
        this.desde_horario = desde_horario;
        this.hasta_horario = hasta_horario;
    }

    public Integer getId_horario() {
        return id_horario;
    }

    public void setId_horario(Integer id_horario) {
        this.id_horario = id_horario;
    }

    public Date getDesde_horario() {
        return desde_horario;
    }

    public void setDesde_horario(Date desde_horario) {
        this.desde_horario = desde_horario;
    }

    public Date getHasta_horario() {
        return hasta_horario;
    }

    public void setHasta_horario(Date hasta_horario) {
        this.hasta_horario = hasta_horario;
    }
}
