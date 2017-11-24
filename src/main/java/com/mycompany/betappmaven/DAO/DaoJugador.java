/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.betappmaven.DAO;

import com.mycompany.betappmaven.DB.Pool;
import com.mycompany.betappmaven.Modelo.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolas
 */
public class DaoJugador {
    
    Pool metodospool = new Pool();
    
    public void insertarJugador(Jugador j){
        
        String query =("INSERT INTO Jugador (correo, pass, apodo, puntaje)"+" VALUES(?,?,?,?)");
        Connection conect = null;
        
        try {
            
            conect = metodospool.dataSource.getConnection();
            Statement st = conect.createStatement();
            PreparedStatement ps = conect.prepareStatement(query);
            
            ps.setString(1, j.getCorreo());
            ps.setString(2, j.getPass());
            ps.setString(3, j.getApodo());
            ps.setInt(4, j.getPuntaje());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex, "Error en la conexion", JOptionPane.ERROR_MESSAGE);
            
        }finally{
            try {
                conect.close();
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, ex, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
}
