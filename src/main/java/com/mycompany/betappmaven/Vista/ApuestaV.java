/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.betappmaven.Vista;

import com.mycompany.betappmaven.DAO.DaoApuesta;
import com.mycompany.betappmaven.DAO.Login;
import com.mycompany.betappmaven.Modelo.Apuesta;
import com.mycompany.betappmaven.Modelo.ApuestaFinal;
import javax.swing.JOptionPane;

/**
 *
 * @author Erik
 */
public class ApuestaV extends javax.swing.JFrame {

    /**
     * Creates new form Apuesta
     */
    public ApuestaV() {
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

        jBapuesta = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jTextLocal = new javax.swing.JTextField();
        jTextVisitante = new javax.swing.JTextField();
        jLabelLocal = new javax.swing.JLabel();
        jLabelVisitante = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelActivo = new javax.swing.JLabel();
        jLabelidPartido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBapuesta.setText("Apostar");
        jBapuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBapuestaActionPerformed(evt);
            }
        });

        jBCancelar.setText("Volver");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jLabelLocal.setText("jLabel1");

        jLabelVisitante.setText("jLabel2");

        jLabel1.setText("Activo");

        jLabelActivo.setText("jLabel2");

        jLabelidPartido.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jTextLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabelLocal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelVisitante)
                .addGap(96, 96, 96))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jBapuesta)
                        .addGap(54, 54, 54)
                        .addComponent(jBCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelActivo)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelidPartido)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelActivo)
                    .addComponent(jLabelidPartido))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLocal)
                    .addComponent(jLabelVisitante))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBapuesta)
                    .addComponent(jBCancelar))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        Login log = new Login();
    private void jBapuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBapuestaActionPerformed
        try{
        int apuestaLocal,apuestaVisitante;
        Apuesta apu=new Apuesta();
        apuestaLocal=Integer.valueOf(jTextLocal.getText());
        apuestaVisitante=Integer.valueOf(jTextVisitante.getText());
        apu.setMarcadorLocal(apuestaLocal);
        apu.setMarcadorVisitante(apuestaVisitante);
        int idJ=log.acceder();
        int idP=Integer.valueOf(jLabelidPartido.getText());
        
        String activo=jLabelActivo.getText();
        if(activo.equals("N") && apu.getMarcadorLocal()>=0 && apu.getMarcadorVisitante()>=0){
            ApuestaFinal f=new ApuestaFinal(idJ,idP,apu.getMarcadorLocal(),apu.getMarcadorVisitante());
            f.setApostador(idJ);
            f.setPartidoApostado(idP);
            f.setMarcadorLocalApostado(apu.getMarcadorLocal());
            f.setMarcadorVisitanteApostado(apu.getMarcadorVisitante());
            DaoApuesta daoa=new DaoApuesta();
            daoa.insertarApuesta(f);
            JOptionPane.showMessageDialog(null, "se han insertado los datos correctamente");
            jTextLocal.setText("");
            jTextVisitante.setText("");
        }else if(activo.equals("S")){
            JOptionPane.showMessageDialog(null, "el partido no se encuentra activo");
        }else if(apu.getMarcadorLocal()<0 || apu.getMarcadorVisitante()<0){
            JOptionPane.showMessageDialog(null, "uno o dos de los campos están negativos");
        }else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
        }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Uno de los espacios está en blanco o incorrecto");
        }
    }//GEN-LAST:event_jBapuestaActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ApuestaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApuestaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApuestaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApuestaV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApuestaV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBCancelar;
    public javax.swing.JButton jBapuesta;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabelActivo;
    public javax.swing.JLabel jLabelLocal;
    public javax.swing.JLabel jLabelVisitante;
    public javax.swing.JLabel jLabelidPartido;
    public javax.swing.JTextField jTextLocal;
    public javax.swing.JTextField jTextVisitante;
    // End of variables declaration//GEN-END:variables
}
