package com.mycompany.betappmaven.Modelo;

/**
 *
 * @author Nicolas
 */
public class Apuesta {
    
    private int marcadorLocal;
    private int marcadorVisitante;
    private String activa;

    public String getActiva() {
        return activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }
    private int IdApuesta;
    private int IDjugador;
    
    public int getIdApuesta() {
        return IdApuesta;
    }

    public int getIDjugador() {
        return IDjugador;
    }

    public void setIDjugador(int IDjugador) {
        this.IDjugador = IDjugador;
    }

    public void setIdApuesta(int IdApuesta) {
        this.IdApuesta = IdApuesta;
    }

    public int getMarcadorLocal() {
        return marcadorLocal;
    }

    public void setMarcadorLocal(int marcadorLocal) {
        this.marcadorLocal = marcadorLocal;
    }

    public int getMarcadorVisitante() {
        return marcadorVisitante;
    }

    public void setMarcadorVisitante(int marcadorVisitante) {
        this.marcadorVisitante = marcadorVisitante;
    }

    
}
