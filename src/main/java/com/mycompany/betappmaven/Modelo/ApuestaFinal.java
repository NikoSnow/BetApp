/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.betappmaven.Modelo;

/**
 *
 * @author Erik
 */
public class ApuestaFinal {
    private int apostador;
    private int partidoApostado;
    private int marcadorLocalApostado;
    private int marcadorVisitanteApostado;
    

    public int getApostador() {
        return apostador;
    }

    public void setApostador(int apostador) {
        this.apostador = apostador;
    }

    public int getPartidoApostado() {
        return partidoApostado;
    }

    public void setPartidoApostado(int partidoApostado) {
        this.partidoApostado = partidoApostado;
    }

    public int getMarcadorLocalApostado() {
        return marcadorLocalApostado;
    }

    public void setMarcadorLocalApostado(int marcadorLocalApostado) {
        this.marcadorLocalApostado = marcadorLocalApostado;
    }

    public int getMarcadorVisitanteApostado() {
        return marcadorVisitanteApostado;
    }

    public void setMarcadorVisitanteApostado(int marcadorVisitanteApostado) {
        this.marcadorVisitanteApostado = marcadorVisitanteApostado;
    }

    public ApuestaFinal(int apostador, int partidoApostado, int marcadorLocalApostado, int marcadorVisitanteApostado) {
        this.apostador = apostador;
        this.partidoApostado = partidoApostado;
        this.marcadorLocalApostado = marcadorLocalApostado;
        this.marcadorVisitanteApostado = marcadorVisitanteApostado;
    }

    
    
}
