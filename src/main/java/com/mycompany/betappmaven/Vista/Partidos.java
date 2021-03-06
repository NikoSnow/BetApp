/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.betappmaven.Vista;

import com.mycompany.betappmaven.DB.Pool;
import com.mycompany.betappmaven.Modelo.Apuesta;
import com.mycompany.betappmaven.Modelo.Partido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicolas
 */
public class Partidos extends javax.swing.JFrame {

    /**
     * Creates new form Partidos
     */
    public Partidos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPartidos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        cargar = new javax.swing.JButton();
        jBApostar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaPartidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Local", "Visitante", "Disponible", "Hora de Inicio", "MarcadorLocal", "MarcadorVisitante"
            }
        ));
        tablaPartidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tablaPartidos);
        if (tablaPartidos.getColumnModel().getColumnCount() > 0) {
            tablaPartidos.getColumnModel().getColumn(1).setPreferredWidth(95);
            tablaPartidos.getColumnModel().getColumn(2).setPreferredWidth(95);
            tablaPartidos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tablaPartidos.getColumnModel().getColumn(5).setResizable(false);
            tablaPartidos.getColumnModel().getColumn(5).setPreferredWidth(90);
            tablaPartidos.getColumnModel().getColumn(6).setResizable(false);
            tablaPartidos.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cargar.setText("Cargar Datos");
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });

        jBApostar.setText("Apostar");
        jBApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBApostarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(cargar)
                .addGap(64, 64, 64)
                .addComponent(jBApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBApostar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    Pool metodospool = new Pool();
    
    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
        
        Connection conect = null; 
        String query =("SELECT  idPartido,localia, visitante, jugado, horaInicio, marcadorLocal, marcadorVisitante FROM Partido");
        try {
            
            conect = metodospool.dataSource.getConnection();
            DefaultTableModel dtm = new DefaultTableModel();
            tablaPartidos.setModel(dtm);
         
            PreparedStatement ps = conect.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            int columnas = rsm.getColumnCount();
            
            dtm.addColumn("idPartido");
            dtm.addColumn("localia");
            dtm.addColumn("visitante");
            dtm.addColumn("jugado");
            dtm.addColumn("horaInicio");
            dtm.addColumn("marcadorLocal");
            dtm.addColumn("marcadorVisitante");
            
            tablaPartidos.getColumnModel().getColumn(1).setPreferredWidth(95);
            tablaPartidos.getColumnModel().getColumn(2).setPreferredWidth(95);
            tablaPartidos.getColumnModel().getColumn(4).setPreferredWidth(150);

            
            while(rs.next()){
                Object[] filas = new Object[columnas];
                for(int i=0; i<columnas; i++){
                    filas[i] = rs.getObject(i + 1);
                }
                dtm.addRow(filas);
            }
            
        } catch (SQLException ex) {
            System.err.println(ex.toString());
        }
        
    }//GEN-LAST:event_cargarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBApostarActionPerformed
      int seleccion;
      seleccion=tablaPartidos.getSelectedRow();
      Partido part=new Partido();
      Apuesta apu=new Apuesta();
      Menu menu=new Menu();
      if(seleccion==-1){
          JOptionPane.showMessageDialog(null, "no ha seleccionado nada");
          
      }else{
          part.setLocal(tablaPartidos.getValueAt(seleccion, 1).toString());
          part.setVisitante(tablaPartidos.getValueAt(seleccion, 2).toString());
          apu.setIdApuesta(Integer.valueOf(tablaPartidos.getValueAt(seleccion, 0).toString()));
          apu.setActiva(tablaPartidos.getValueAt(seleccion, 3).toString());
          ApuestaV apuesta=new ApuestaV();
          apuesta.setVisible(true);
          apuesta.jLabelVisitante.setText(part.getVisitante());
          apuesta.jLabelLocal.setText(part.getLocal());
          apuesta.jLabelActivo.setText(apu.getActiva());
          apuesta.jLabelidPartido.setText(tablaPartidos.getValueAt(seleccion, 0).toString());
      }
    }//GEN-LAST:event_jBApostarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Partidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Partidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Partidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Partidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Partidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cargar;
    public javax.swing.JButton jBApostar;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaPartidos;
    // End of variables declaration//GEN-END:variables
}
