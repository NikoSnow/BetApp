/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.betappmaven.DAO;

import com.mycompany.betappmaven.DB.Pool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import com.mycompany.betappmaven.Modelo.ApuestaFinal;
import java.sql.ResultSet;
/**
 *
 * @author Labin
 */
public class DaoApuesta {
    Pool metodospool = new Pool();
    public void insertarApuesta(ApuestaFinal f){
        String query =("INSERT INTO Apuesta(idJugador, idPartido, marcadorLocal,marcadorVisitante)"+" VALUES (?,?,?,?);");
        Connection conect = null;
        
        try {
            
            conect = metodospool.dataSource.getConnection();
            Statement st = conect.createStatement();
            PreparedStatement ps = conect.prepareStatement(query);
            
            ps.setInt(1, f.getApostador());
            ps.setInt(2, f.getPartidoApostado());
            ps.setInt(3, f.getMarcadorLocalApostado());
            ps.setInt(4, f.getMarcadorVisitanteApostado());
            
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
    public void modificarApuesta(ApuestaFinal f){
        int idJugador=f.getApostador();
        int idPartido=f.getPartidoApostado();
        int marcL=f.getMarcadorLocalApostado();
        int marcV=f.getMarcadorVisitanteApostado();
        String query =("Update Apuesta set marcadorLocal='"+marcL+"',marcadorVisitante='"+marcV+"' where idJugador='"+idJugador+"' and idPartido='"+idPartido+"';");
        Connection conect = null;
        
        try {
            
            conect = metodospool.dataSource.getConnection();
            PreparedStatement st = conect.prepareStatement(query);
            st.executeUpdate();
           
            
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
