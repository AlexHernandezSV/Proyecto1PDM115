package com.example.proyecto1pdm115;

public class OfertaAcademica {
    private String idMateriasActivas;
    private String idCiclo;
    private String idMateria;
    private String idCoordinador;
    private String nombreMateriasActivas;
    private String cicloMateriaActiva;

    public OfertaAcademica() {
    }

    public OfertaAcademica(String idMateriasActivas, String idCiclo, String idMateria, String idCoordinador, String nombreMateriasActivas, String cicloMateriaActiva) {
        this.idMateriasActivas = idMateriasActivas;
        this.idCiclo = idCiclo;
        this.idMateria = idMateria;
        this.idCoordinador = idCoordinador;
        this.nombreMateriasActivas = nombreMateriasActivas;
        this.cicloMateriaActiva = cicloMateriaActiva;
    }

    public String getIdMateriasActivas() {
        return idMateriasActivas;
    }

    public void setIdMateriasActivas(String idMateriasActivas) {
        this.idMateriasActivas = idMateriasActivas;
    }

    public String getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(String idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getIdCoordinador() {
        return idCoordinador;
    }

    public void setIdCoordinador(String idCoordinador) {
        this.idCoordinador = idCoordinador;
    }

    public String getNombreMateriasActivas() {
        return nombreMateriasActivas;
    }

    public void setNombreMateriasActivas(String nombreMateriasActivas) {
        this.nombreMateriasActivas = nombreMateriasActivas;
    }

    public String getCicloMateriaActiva() {
        return cicloMateriaActiva;
    }

    public void setCicloMateriaActiva(String cicloMateriaActiva) {
        this.cicloMateriaActiva = cicloMateriaActiva;
    }
}
