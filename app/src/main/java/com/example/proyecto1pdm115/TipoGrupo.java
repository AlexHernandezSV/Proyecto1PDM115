package com.example.proyecto1pdm115;

public class TipoGrupo {

    private String id_tipo_grupo;
    private String grupo;
    private String nombre_tipo_grupo;

    public TipoGrupo() {
    }

    public TipoGrupo(String id_tipo_grupo, String grupo, String nombre_tipo_grupo) {
        this.id_tipo_grupo = id_tipo_grupo;
        this.grupo = grupo;
        this.nombre_tipo_grupo = nombre_tipo_grupo;
    }

    public String getId_tipo_grupo() {
        return id_tipo_grupo;
    }

    public void setId_tipo_grupo(String id_tipo_grupo) {
        this.id_tipo_grupo = id_tipo_grupo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNombre_tipo_grupo() {
        return nombre_tipo_grupo;
    }

    public void setNombre_tipo_grupo(String nombre_tipo_grupo) {
        this.nombre_tipo_grupo = nombre_tipo_grupo;
    }
}
