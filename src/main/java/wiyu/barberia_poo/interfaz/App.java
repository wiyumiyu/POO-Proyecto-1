/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package wiyu.barberia_poo.interfaz;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author maria
 */
public class App extends javax.swing.JFrame {

    /**
     * Creates new form App
     */
    public App() {
        initComponents();
        
        AgendaPanel p1 = new AgendaPanel();
        ShowPanel(p1);
    }
    
    private void ShowPanel(JPanel p){
        p.setSize(671,480);
        p.setLocation(0,0);
        content.removeAll();
        content.add(p,BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        BototonNotificar = new javax.swing.JButton();
        BotonClientes = new javax.swing.JButton();
        BotonServicios = new javax.swing.JButton();
        BotonCitas = new javax.swing.JButton();
        BotonListaEspera = new javax.swing.JButton();
        BotonHorario = new javax.swing.JButton();
        BotonAgenda = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 510));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BototonNotificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/Notificar.png"))); // NOI18N
        BototonNotificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BototonNotificarActionPerformed(evt);
            }
        });
        jPanel3.add(BototonNotificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 180, 57));

        BotonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/Clientes.png"))); // NOI18N
        BotonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonClientesActionPerformed(evt);
            }
        });
        jPanel3.add(BotonClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 180, 43));

        BotonServicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/Servicios.png"))); // NOI18N
        BotonServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonServiciosActionPerformed(evt);
            }
        });
        jPanel3.add(BotonServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 180, 43));

        BotonCitas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/Citas.png"))); // NOI18N
        BotonCitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCitasActionPerformed(evt);
            }
        });
        jPanel3.add(BotonCitas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 180, 43));

        BotonListaEspera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/ListaEspera.png"))); // NOI18N
        BotonListaEspera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonListaEsperaActionPerformed(evt);
            }
        });
        jPanel3.add(BotonListaEspera, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 180, 43));

        BotonHorario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/HorarioAtencion.png"))); // NOI18N
        BotonHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonHorarioActionPerformed(evt);
            }
        });
        jPanel3.add(BotonHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 180, 43));

        BotonAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/Agenda-1.png"))); // NOI18N
        BotonAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgendaActionPerformed(evt);
            }
        });
        jPanel3.add(BotonAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 180, 43));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/Barberia.png"))); // NOI18N
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonServiciosActionPerformed
        ServiciosPanel p3 = new ServiciosPanel();
        ShowPanel(p3);
    }//GEN-LAST:event_BotonServiciosActionPerformed

    private void BotonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonClientesActionPerformed
        ClientesPanel p4 = new ClientesPanel();
        ShowPanel(p4);
    }//GEN-LAST:event_BotonClientesActionPerformed

    private void BotonHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonHorarioActionPerformed
        HorarioPanel p2 = new HorarioPanel();
        ShowPanel(p2);
    }//GEN-LAST:event_BotonHorarioActionPerformed

    private void BotonAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgendaActionPerformed
        AgendaPanel p1 = new AgendaPanel();
        ShowPanel(p1);
    }//GEN-LAST:event_BotonAgendaActionPerformed

    private void BotonListaEsperaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonListaEsperaActionPerformed
        EsperaPanel p5 = new EsperaPanel();
        ShowPanel(p5);
    }//GEN-LAST:event_BotonListaEsperaActionPerformed

    private void BototonNotificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BototonNotificarActionPerformed
        NotificacionesPanel p6 = new NotificacionesPanel();
        ShowPanel(p6);
    }//GEN-LAST:event_BototonNotificarActionPerformed

    private void BotonCitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCitasActionPerformed
        CitasPanel p7 = new CitasPanel();
        ShowPanel(p7);
    }//GEN-LAST:event_BotonCitasActionPerformed

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
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgenda;
    private javax.swing.JButton BotonCitas;
    private javax.swing.JButton BotonClientes;
    private javax.swing.JButton BotonHorario;
    private javax.swing.JButton BotonListaEspera;
    private javax.swing.JButton BotonServicios;
    private javax.swing.JButton BototonNotificar;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
