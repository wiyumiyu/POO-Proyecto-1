/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package wiyu.barberia_poo.interfaz;

import java.time.LocalDate;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import wiyu.barberia_poo.Clases.Administrador;

/**
 *
 * @author maria
 */
public class AgendaPanel extends javax.swing.JPanel {
    Administrador admin = new Administrador();
    /**
     * Creates new form AgendaPanel
     */
    public AgendaPanel() {
        initComponents();
        cargarMeses();
        cargarDias();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaCitas = new javax.swing.JList<>();
        BotonBuscar = new javax.swing.JButton();
        ComboMes = new javax.swing.JComboBox<>();
        ComboAno = new javax.swing.JComboBox<>();
        ComboDia = new javax.swing.JComboBox<>();
        BotonPorFecha = new javax.swing.JRadioButton();
        BotonMensual = new javax.swing.JRadioButton();
        BotonSemanal = new javax.swing.JRadioButton();
        LabelSolicitarDatos = new javax.swing.JLabel();
        LabelAno = new javax.swing.JLabel();
        LabelMes = new javax.swing.JLabel();
        LabelDia = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(ListaCitas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 610, -1));

        BotonBuscar.setText("Buscar");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 440, 90, 30));
        BotonBuscar.setVisible(false);

        jPanel1.add(ComboMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 140, 30));
        ComboMes.setVisible(false);

        ComboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024" }));
        jPanel1.add(ComboAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 90, 30));
        ComboAno.setVisible(false);

        jPanel1.add(ComboDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 130, 30));
        ComboDia.setVisible(false);

        buttonGroup1.add(BotonPorFecha);
        BotonPorFecha.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonPorFecha.setForeground(new java.awt.Color(255, 255, 255));
        BotonPorFecha.setText("APARTIR DE FECHA CONCRETA");
        BotonPorFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonPorFechaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonPorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        buttonGroup1.add(BotonMensual);
        BotonMensual.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonMensual.setForeground(new java.awt.Color(255, 255, 255));
        BotonMensual.setText("MENSUAL");
        BotonMensual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMensualActionPerformed(evt);
            }
        });
        jPanel1.add(BotonMensual, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        buttonGroup1.add(BotonSemanal);
        BotonSemanal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonSemanal.setForeground(new java.awt.Color(255, 255, 255));
        BotonSemanal.setText("SEMANAL");
        BotonSemanal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSemanalActionPerformed(evt);
            }
        });
        jPanel1.add(BotonSemanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        LabelSolicitarDatos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelSolicitarDatos.setForeground(new java.awt.Color(255, 255, 255));
        LabelSolicitarDatos.setText("INGRESE LA FECHA DESDE LA QUE DESEA CONSULTAR");
        jPanel1.add(LabelSolicitarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));
        LabelSolicitarDatos.setVisible(false);

        LabelAno.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelAno.setForeground(new java.awt.Color(255, 255, 255));
        LabelAno.setText("AÑO");
        jPanel1.add(LabelAno, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, -1, -1));
        LabelAno.setVisible(false);

        LabelMes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelMes.setForeground(new java.awt.Color(255, 255, 255));
        LabelMes.setText("MES");
        jPanel1.add(LabelMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, -1));
        LabelMes.setVisible(false);

        LabelDia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelDia.setForeground(new java.awt.Color(255, 255, 255));
        LabelDia.setText("DÍA");
        jPanel1.add(LabelDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, -1, -1));
        LabelDia.setVisible(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/Agenda.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 671, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        try{
            int ano = Integer.parseInt(ComboAno.getSelectedItem().toString());
            int mes = ComboMes.getSelectedIndex() + 1;
            int dia = Integer.parseInt(ComboDia.getSelectedItem().toString());
            LocalDate fecha = LocalDate.of(ano, mes, dia);
            actualizarModeDesdeFecha(fecha);
        }catch(Exception  e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR EN DATOS INGRESADOS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void BotonSemanalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSemanalActionPerformed
        LabelSolicitarDatos.setVisible(false);
        LabelDia.setVisible(false);
        LabelMes.setVisible(false);
        LabelAno.setVisible(false);
        ComboAno.setVisible(false);
        ComboMes.setVisible(false);
        ComboDia.setVisible(false);
        BotonBuscar.setVisible(false);
        actualizarModeSemanal();
    }//GEN-LAST:event_BotonSemanalActionPerformed

    private void BotonPorFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonPorFechaActionPerformed
        LabelSolicitarDatos.setVisible(true);
        LabelDia.setVisible(true);
        LabelMes.setVisible(true);
        LabelAno.setVisible(true);
        ComboAno.setVisible(true);
        ComboMes.setVisible(true);
        ComboDia.setVisible(true);
        BotonBuscar.setVisible(true);
    }//GEN-LAST:event_BotonPorFechaActionPerformed

    private void BotonMensualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMensualActionPerformed
        LabelSolicitarDatos.setVisible(false);
        LabelDia.setVisible(false);
        LabelMes.setVisible(false);
        LabelAno.setVisible(false);
        ComboAno.setVisible(false);
        ComboMes.setVisible(false);
        ComboDia.setVisible(false);
        BotonBuscar.setVisible(false);
        actualizarModeMensual();
    }//GEN-LAST:event_BotonMensualActionPerformed
    private void actualizarModeDesdeFecha(LocalDate fecha){
        try{
            DefaultListModel<Entry<Integer, String>> lista = new DefaultListModel();
            Map<Integer, String> citas = admin.getCitas();
            for (Entry <Integer, String> cita: citas.entrySet()){
                LocalDate fechaCita = admin.getDate(cita.getKey());
                if(fechaCita.getYear()>fecha.getYear())
                    lista.addElement(cita);
                else if(fechaCita.getYear()==fecha.getYear()){
                    if (fechaCita.getMonthValue()>fecha.getMonthValue())
                        lista.addElement(cita);
                    else if (fechaCita.getMonthValue()==fecha.getMonthValue()){
                        if (fechaCita.getDayOfMonth()>fecha.getDayOfMonth())
                            lista.addElement(cita);
                    }
                }
            }
            ListaCitas.setModel(lista);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void actualizarModeSemanal(){
        try{
            DefaultListModel<Entry<Integer, String>> lista = new DefaultListModel();
            Map<Integer, String> citas = admin.getCitas();
            for (Entry <Integer, String> cita: citas.entrySet()){
                LocalDate fechaCita = admin.getDate(cita.getKey());
                if (fechaCita.getDayOfMonth()>=LocalDate.now().getDayOfMonth() && fechaCita.getDayOfMonth()>=LocalDate.now().getDayOfMonth()+7)
                    lista.addElement(cita);
            }
            ListaCitas.setModel(lista);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void actualizarModeMensual(){
            try{
            DefaultListModel<Entry<Integer, String>> lista = new DefaultListModel();
            Map<Integer, String> citas = admin.getCitas();
            for (Entry <Integer, String> cita: citas.entrySet()){
                LocalDate fechaCita = admin.getDate(cita.getKey());
                if (fechaCita.getDayOfMonth()>=LocalDate.now().getDayOfMonth() && fechaCita.getMonthValue() == LocalDate.now().getMonthValue())
                    lista.addElement(cita);
            }
            ListaCitas.setModel(lista);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void cargarMeses(){
        ComboMes.addItem("Enero");
        ComboMes.addItem("Febrero");
        ComboMes.addItem("Marzo");
        ComboMes.addItem("Abril");
        ComboMes.addItem("Mayo");
        ComboMes.addItem("Junio");
        ComboMes.addItem("Julio");
        ComboMes.addItem("Agosto");
        ComboMes.addItem("Septiembre");
        ComboMes.addItem("Octubre");
        ComboMes.addItem("Noviembre");
        ComboMes.addItem("Diciembre");
    }
    private void cargarDias(){
        ComboDia.removeAllItems();
        int cantidad = 0;
        
        if(ComboMes.getSelectedItem() == "Febrero" ){
            cantidad = 29;
        }
        else if(ComboMes.getSelectedItem() == "Enero" || ComboMes.getSelectedItem() == "Marzo" || ComboMes.getSelectedItem() == "Mayo" || ComboMes.getSelectedItem() == "Julio" || ComboMes.getSelectedItem() == "Agosto" || ComboMes.getSelectedItem() == "Octubre" || ComboMes.getSelectedItem() == "Diciembre"){
            cantidad = 31;
        }
        else{
            cantidad = 30;
        }
        
        for(int i = 1; i <= cantidad; i++){
            ComboDia.addItem(String.valueOf(i));
        }
        
        ComboDia.setSelectedItem("1");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JRadioButton BotonMensual;
    private javax.swing.JRadioButton BotonPorFecha;
    private javax.swing.JRadioButton BotonSemanal;
    private javax.swing.JComboBox<String> ComboAno;
    private javax.swing.JComboBox<String> ComboDia;
    private javax.swing.JComboBox<String> ComboMes;
    private javax.swing.JLabel LabelAno;
    private javax.swing.JLabel LabelDia;
    private javax.swing.JLabel LabelMes;
    private javax.swing.JLabel LabelSolicitarDatos;
    private javax.swing.JList<Map.Entry<Integer, String>> ListaCitas;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
