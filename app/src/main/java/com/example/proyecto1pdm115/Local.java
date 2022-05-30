package com.example.proyecto1pdm115;

public class Local {
    private String idAula;
    private String idReservante;
    private String nombreAula;
    private int cupo;


    public Local() {
    }

    public Local(String idAula, String idReservante, String nombreAula, int cupo) {
        this.idAula = idAula;
        this.idReservante = idReservante;
        this.nombreAula = nombreAula;
        this.cupo = cupo;
    }

    public String getIdAula() {
        return idAula;
    }

    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }

    public String getIdReservante() {
        return idReservante;
    }

    public void setIdReservante(String idReservante) {
        this.idReservante = idReservante;
    }

    public String getNombreAula() {
        return nombreAula;
    }

    public void setNombreAula(String nombreAula) {
        this.nombreAula = nombreAula;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }
}
