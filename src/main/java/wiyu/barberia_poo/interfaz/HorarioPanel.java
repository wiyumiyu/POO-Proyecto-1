/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package wiyu.barberia_poo.interfaz;

import java.util.ArrayList;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import wiyu.barberia_poo.Clases.Administrador;

/**
 *
 * @author maria
 */
public class HorarioPanel extends javax.swing.JPanel {
    Administrador admin = new Administrador();
    
    /**
     * Creates new form HorarioPanel
     */
    public HorarioPanel() {
        initComponents();    
        cargarHorarioDia();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaHorario = new javax.swing.JList<>();
        ComboDia = new javax.swing.JComboBox<>();
        ComboInicio = new javax.swing.JComboBox<>();
        ComboFin = new javax.swing.JComboBox<>();
        botonEliminar = new javax.swing.JButton();
        agregarHorario = new javax.swing.JButton();
        LabelAgregarHorario = new javax.swing.JLabel();
        LabelCierre = new javax.swing.JLabel();
        LabelInicio = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(ListaHorario);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 560, 140));

        ComboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" }));
        ComboDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboDiaActionPerformed(evt);
            }
        });
        jPanel1.add(ComboDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 130, 30));

        ComboInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00" }));
        jPanel1.add(ComboInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 90, 30));

        ComboFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00", "24:00" }));
        jPanel1.add(ComboFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 80, 30));

        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 240, 100, 30));

        agregarHorario.setText("Agregar");
        agregarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarHorarioActionPerformed(evt);
            }
        });
        jPanel1.add(agregarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 80, 30));

        LabelAgregarHorario.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelAgregarHorario.setForeground(new java.awt.Color(255, 255, 255));
        LabelAgregarHorario.setText("AGREGAR HORARIO DE ATENCIÓN");
        jPanel1.add(LabelAgregarHorario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        LabelCierre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelCierre.setForeground(new java.awt.Color(255, 255, 255));
        LabelCierre.setText("HORA DE CIERRE");
        jPanel1.add(LabelCierre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, -1, -1));

        LabelInicio.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelInicio.setForeground(new java.awt.Color(255, 255, 255));
        LabelInicio.setText("HORA DE INICIO");
        jPanel1.add(LabelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DÍA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/Horario.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboDiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboDiaActionPerformed

    private void agregarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarHorarioActionPerformed
        try{
            int dia = ComboDia.getSelectedIndex() + 1;
            int inicio = ComboInicio.getSelectedIndex();
            int fin = ComboFin.getSelectedIndex() + 1;
            admin.establecerHorarioAtencion(dia, inicio, fin);
            JOptionPane.showMessageDialog(null, "Horario de atención creado con éxito", "CREACIÓN FINALIZADA", JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception  e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR EN DATOS INGRESADOS", JOptionPane.ERROR_MESSAGE);
        }
        cargarHorarioDia();
    }//GEN-LAST:event_agregarHorarioActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        if (ListaHorario.getSelectedIndex() != -1){
            Map.Entry<Integer, String> horario = ListaHorario.getSelectedValue();
            int codigoDia = horario.getKey();
            int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este horario de forma permanente?");
            if (eliminar == JOptionPane.YES_OPTION){
                try{
                    admin.borrarHorarioAtencion(codigoDia);
                    JOptionPane.showMessageDialog(null, "Horario eliminado con éxito", "ELIMINACIÓN FINALIZADA", JOptionPane.INFORMATION_MESSAGE); 
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);  
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ningún servicio ha sido seleccionado", "ERROR DE SELECCIÓN", JOptionPane.ERROR_MESSAGE);
        }
        cargarHorarioDia();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void cargarHorarioDia(){
        DefaultListModel<Map.Entry<Integer, String>> lista = new DefaultListModel();
        Map<Integer, String> horarios = admin.getHorarios();
        for (Map.Entry <Integer, String> horario: horarios.entrySet()){
            lista.addElement(horario);
        }
        ListaHorario.setModel(lista);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboDia;
    private javax.swing.JComboBox<String> ComboFin;
    private javax.swing.JComboBox<String> ComboInicio;
    private javax.swing.JLabel LabelAgregarHorario;
    private javax.swing.JLabel LabelCierre;
    private javax.swing.JLabel LabelInicio;
    private javax.swing.JList<Map.Entry<Integer, String>> ListaHorario;
    private javax.swing.JButton agregarHorario;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
