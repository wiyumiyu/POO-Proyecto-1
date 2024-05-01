/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package wiyu.barberia_poo.interfaz;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import wiyu.barberia_poo.Clases.Administrador;

/**
 *
 * @author maria
 */
public class EsperaPanel extends javax.swing.JPanel {
    Administrador admin = new Administrador();
    /**
     * Creates new form EsperaPanel
     */
    public EsperaPanel() {
        initComponents();
        actualizarListMode();
        actualizarComboClientes();
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
        ListaEspera = new javax.swing.JList<>();
        BotonConfirmar1 = new javax.swing.JButton();
        BotonAgregar = new javax.swing.JButton();
        ComboClientes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(ListaEspera);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 610, 160));

        BotonConfirmar1.setText("Eliminar");
        BotonConfirmar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonConfirmar1ActionPerformed(evt);
            }
        });
        jPanel1.add(BotonConfirmar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 90, 30));

        BotonAgregar.setText("Agregar");
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(BotonAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 90, 30));

        ComboClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboClientesActionPerformed(evt);
            }
        });
        jPanel1.add(ComboClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 610, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("AGREGAR CLIENTE A LISTA DE ESPERA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wiyu/barberia_poo/BancoImagen/ListasE.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void ComboClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboClientesActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        Entry<Integer,String> item = (Entry<Integer,String>) ComboClientes.getSelectedItem();
        try {
            admin.agregarClienteListaEspera(item.getKey());
            JOptionPane.showMessageDialog(null, "Cliente añadido con éxito a lista de espera", "AGREGACIÓN FINALIZADA", JOptionPane.INFORMATION_MESSAGE);
            int indice = ComboClientes.getSelectedIndex();
            ComboClientes.removeItemAt(indice);
            actualizarListMode();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR EN AGREGACIÓN", JOptionPane.ERROR);
        }
        
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void BotonConfirmar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonConfirmar1ActionPerformed
        if (ListaEspera.getSelectedIndex() != -1){
            Entry<Integer, String> cliente = ListaEspera.getSelectedValue();
            int codigoCliente = cliente.getKey();
            int eliminar = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este cliente de lista de espera?");
            if (eliminar == JOptionPane.YES_OPTION){
                try{
                    admin.borrarClienteListaEspera(codigoCliente);
                    JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito", "ELIMINACIÓN FINALIZADA", JOptionPane.INFORMATION_MESSAGE); 
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);  
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ningún cliente ha sido seleccionado", "ERROR DE SELECCIÓN", JOptionPane.ERROR_MESSAGE);
        }
        actualizarListMode();
    }//GEN-LAST:event_BotonConfirmar1ActionPerformed
    private void actualizarListMode(){
        DefaultListModel<Entry<Integer, String>> lista = new DefaultListModel();
        Map<Integer, String> clientes = admin.getListaEspera();
        for (Entry <Integer, String> cliente: clientes.entrySet()){
            lista.addElement(cliente);
        }
        ListaEspera.setModel(lista);
    }
    private void actualizarComboClientes(){
        Map<Integer, String> clientes = admin.getClientes();
        Map<Integer, String> listaEspera = admin.getListaEspera();
        boolean encontrado = false;
        for (Entry <Integer, String> cliente: clientes.entrySet()){
            for(Integer llave:listaEspera.keySet()){
                if (Objects.equals(cliente.getKey(), llave)){
                    encontrado = true;
                }
            }
            if (!encontrado)
                ComboClientes.addItem(cliente);
            encontrado = false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    private javax.swing.JButton BotonConfirmar1;
    private javax.swing.JComboBox<Entry<Integer, String>> ComboClientes;
    private javax.swing.JList<Entry<Integer, String>> ListaEspera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
