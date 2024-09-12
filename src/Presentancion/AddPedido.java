/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentancion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import logica.Clases.Pedido;
import logica.Fabrica;
import logica.Interfaces.IControladorPedido;
import logica.servicios.PedidosServicios;

/**
 *
 * @author Mateo
 */
public class AddPedido extends javax.swing.JFrame {

    private PedidosServicios pedidosServicios;
    private IControladorPedido ICP;

    public AddPedido() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.pedidosServicios = new PedidosServicios();
        this.ICP = Fabrica.getInstance().getIControladorPedido();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFechaPedido = new javax.swing.JTextField();
        txtEstado = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtVendedorID = new javax.swing.JTextField();
        txtClienteID = new javax.swing.JTextField();
        btnAñadirPedido = new javax.swing.JButton();
        btnCancelarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("AÑADIR PEDIDO");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("FechaPedido");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Estado");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Total");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("VendedorID");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("ClienteID");

        btnAñadirPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAñadirPedido.setText("Añadir");
        btnAñadirPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirPedidoActionPerformed(evt);
            }
        });

        btnCancelarPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancelarPedido.setText("Cancelar");
        btnCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1)
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClienteID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtVendedorID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnAñadirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnCancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtVendedorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtClienteID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAñadirPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed

    private void btnAñadirPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirPedidoActionPerformed

        // Da formato a la fecha dia/mes/año
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaPedido = null;
        try {
            fechaPedido = sdf.parse(txtFechaPedido.getText());
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use dd/MM/yyyy", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String estado = txtEstado.getText();
        float total = Float.parseFloat(txtTotal.getText());
        int vendedor_id = Integer.parseInt(txtVendedorID.getText());
        int cliente_id = Integer.parseInt(txtClienteID.getText());

        // Validar si el vendedor y cliente existen
        if (!ICP.validarVendedor(vendedor_id) && !ICP.validarCliente(cliente_id)) {
            JOptionPane.showMessageDialog(this, "El Vendedor y Cliente no existen.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!ICP.validarVendedor(vendedor_id)) {
            JOptionPane.showMessageDialog(this, "El Vendedor no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!ICP.validarCliente(cliente_id)) {
            JOptionPane.showMessageDialog(this, "El Cliente no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Llamar al controlador para añadir el pedido
        Pedido nuevoPedido = new Pedido(0, fechaPedido, estado, total, vendedor_id, cliente_id);
        this.pedidosServicios.agregarPedido(nuevoPedido);
        JOptionPane.showMessageDialog(this, "El pedido ha sido agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        // Cerrar la ventana después de añadir el pedido
        this.dispose();
    }//GEN-LAST:event_btnAñadirPedidoActionPerformed

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
            java.util.logging.Logger.getLogger(AddPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirPedido;
    private javax.swing.JButton btnCancelarPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtClienteID;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFechaPedido;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtVendedorID;
    // End of variables declaration//GEN-END:variables
}
