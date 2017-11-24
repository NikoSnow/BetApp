package com.mycompany.betappmaven.DAO;

import com.mycompany.betappmaven.DB.Pool;
import com.mycompany.betappmaven.Modelo.Apuesta;
import com.mycompany.betappmaven.Vista.Acceso;
import com.mycompany.betappmaven.Vista.Menu;
import com.mysql.jdbc.Util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Login {
    
    Pool metodospool = new Pool();
    
    public int acceder(){
        
        String apodo = Acceso.usuario.getText();
        String pass = Acceso.pass.getText();
        Apuesta apu=new Apuesta();
        Menu men=new Menu();
        
        String query ="SELECT * FROM Jugador WHERE apodo='"+apodo+"' AND pass='"+pass+"'";
        Connection conect = null;
        int resultado=0;
        try {
            
            conect = metodospool.dataSource.getConnection();
            Statement st = conect.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next()){
                resultado=Integer.valueOf(rs.getString("idJugador"));
                               
                
            }else{
                JOptionPane.showMessageDialog(null, "Datos de jugador incorrectos");
            }
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, ex, "Error en la conexion", JOptionPane.ERROR_MESSAGE);
            
        }finally{
            try {
                conect.close();
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, ex, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
            }
        }
        return resultado;
    }
    
    public int accesoAdmin(){
    
        
        String cedula = Acceso.usuario.getText();
        String pass = Acceso.pass.getText();
        
        int resultado=0;
        String query ="SELECT * FROM Admin WHERE cedula='"+cedula+"' AND pass='"+pass+"'";
        Connection conect = null;
        
            try {

                conect = metodospool.dataSource.getConnection();
                Statement st = conect.createStatement();
                ResultSet rs = st.executeQuery(query);

                if(rs.next()){
                    resultado=1;
                }else{
                    JOptionPane.showMessageDialog(null, "Datos de Administrador incorrectos");
                }

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, ex, "Error en la conexion", JOptionPane.ERROR_MESSAGE);

            }finally{
                try {
                    conect.close();
                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, ex, "Error de desconexion", JOptionPane.ERROR_MESSAGE);
                }
            }
        return resultado;
        
        }
    }

