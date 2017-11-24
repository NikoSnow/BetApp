
package com.mycompany.betappmaven.Modelo;

/**
 *
 * @author Nicolas
 */
public class Jugador {
    
    private String apodo;
    private String correo;
    private String pass;
    private int puntaje;
   
    public Jugador(String apodo, String correo, String pass, int puntaje) {
        this.apodo = apodo;
        this.correo = correo;
        this.pass = pass;
        this.puntaje = puntaje;
        
    }

       
    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    
    
    
}
