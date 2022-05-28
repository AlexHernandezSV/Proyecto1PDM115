package com.example.proyecto1pdm115;

public class DetalleOferta {
    private String grupo;
    private String id_materias_activas;
    private String id_aula;
    private Integer cant_inscritos;

    public DetalleOferta(){
    }

    public DetalleOferta(String grupo, String id_materias_activas, String id_aula, Integer cant_inscritos) {
        this.grupo = grupo;
        this.id_materias_activas = id_materias_activas;
        this.id_aula = id_aula;
        this.cant_inscritos = cant_inscritos;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getId_materias_activas() {
        return id_materias_activas;
    }

    public void setId_materias_activas(String id_materias_activas) {
        this.id_materias_activas = id_materias_activas;
    }

    public String getId_aula() {
        return id_aula;
    }

    public void setId_aula(String id_aula) {
        this.id_aula = id_aula;
    }

    public Integer getCant_inscritos() {
        return cant_inscritos;
    }

    public void setCant_inscritos(Integer cant_inscritos) {
        this.cant_inscritos = cant_inscritos;
    }
}
