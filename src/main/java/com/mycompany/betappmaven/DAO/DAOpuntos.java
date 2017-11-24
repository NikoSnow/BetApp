/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.betappmaven.DAO;
import com.mycompany.betappmaven.DB.Pool;
import com.mysql.jdbc.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class DAOpuntos {
    Pool metodospool = new Pool();
    public int calcularPuntos(int id){
        
        String query ="SELECT jugador.idJugador,partido.idPartido,partido.localia, partido.visitante, partido.jugado, partido.horaInicio, Apuesta.marcadorLocal, Apuesta.marcadorVisitante,partido.marcadorLocal,partido.marcadorVisitante FROM Partido right join Apuesta using(idPartido) right join Jugador using(idJugador) where idjugador='"+id+"';";
        
        Connection conect = null;
        int total=0;
        
        try {
            
            conect = metodospool.dataSource.getConnection();
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(query);
            int locala;
            int visia;
            int localb;
            int visib;
            int diferenciaA;
            int diferenciaB;
            while(rs.next()){
            locala=rs.getInt(7);
            visia=rs.getInt(8);
            localb=rs.getInt(9);
            visib=rs.getInt(10);
            diferenciaA=locala-visia;
            diferenciaB=localb-visib;
            
            if(locala==localb && visia==visib){
                total=total+5;
            }else if(locala==localb || visia==visib){
                total=total+2;
            }else if(diferenciaA==diferenciaB && locala>visia && localb>visib && locala!=localb && visia!=visib ){
                total=total+3;
            }else if(diferenciaA==diferenciaB && locala<visia && localb<visib && locala!=localb && visia!=visib){
                total=total+3;
            }
            }
            String query2= "update jugador set puntaje='"+total+"'where idJugador='"+id+"'";
            PreparedStatement at = conect.prepareStatement(query2);
            at.executeUpdate();
                               
                
                        
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex, "Error en la conexion", JOptionPane.ERROR_MESSAGE);
            
        }finally{
            try {
                conect.close();
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, ex, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        
        
        
        return total;
    }
}
