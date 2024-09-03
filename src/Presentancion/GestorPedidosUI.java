package Presentancion;

import java.awt.Component;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logica.Clases.Pedido;
import logica.Fabrica;
import logica.Interfaces.IControladorPedido;
import logica.Interfaces.IControladorUsuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LucasCiceri
 */
public class GestorPedidosUI extends javax.swing.JFrame {

    private IControladorUsuario ICU;
    private IControladorPedido ICP;

    public GestorPedidosUI() {

        initComponents();
        this.ICU = Fabrica.getInstance().getIControladorUsuario();
        this.ICP = Fabrica.getInstance().getIControladorPedido();

        this.setTitle("Gestion de Pedidos");
        this.setLocationRelativeTo(null); // Centra la ventana

        this.cargarDatosDePedidos();

    }
    
    private void cargarDatosDePedidos() {
        ArrayList<Pedido> pedidosDeBaseDeDatos = this.ICP.listPedidos();
        DefaultTableModel modelo = (DefaultTableModel) this.tblPedidos.getModel();

        System.err.println("Pedidos Encontrados!!");

        for (Pedido pedido : pedidosDeBaseDeDatos) {
            String nombreVendedor = ICP.obtenerNombreVendedorPorId(pedido.getIdVendedor()); // Obtener el nombre del vendedor
            Object[] nuevaRow = {
                pedido.getFechaPedido(),
                pedido.getEstado(),
                nombreVendedor // Mostrar el nombre en lugar del ID
            };
            modelo.addRow(nuevaRow); // Agrega la fila al modelo
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDatosProveedores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        btnDatosClientes = new javax.swing.JButton();
        btnDatosVendedores = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnDatosProductos = new javax.swing.JButton();
        btnRecargarPedidos = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDatosProveedores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatosProveedores.setText("Proveedores");
        btnDatosProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosProveedoresActionPerformed(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Estado", "Vendedor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPedidos);

        btnDatosClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatosClientes.setText("Clientes");
        btnDatosClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosClientesActionPerformed(evt);
            }
        });

        btnDatosVendedores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatosVendedores.setText("Vendedores");
        btnDatosVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosVendedoresActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("TABLA DE PEDIDOS");

        btnDatosProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatosProductos.setText("Productos");
        btnDatosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosProductosActionPerformed(evt);
            }
        });

        btnRecargarPedidos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRecargarPedidos.setText("Recargar");
        btnRecargarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarPedidosActionPerformed(evt);
            }
        });
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDatosVendedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDatosClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDatosProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDatosProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnRecargarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(246, 246, 246))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDatosClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatosVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatosProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatosProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRecargarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatosProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosProveedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatosProveedoresActionPerformed

    private void btnDatosClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatosClientesActionPerformed

    private void btnDatosVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosVendedoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatosVendedoresActionPerformed

    private void btnDatosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDatosProductosActionPerformed

    private void btnRecargarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarPedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRecargarPedidosActionPerformed

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
            java.util.logging.Logger.getLogger(GestorPedidosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestorPedidosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestorPedidosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestorPedidosUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestorPedidosUI().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatosClientes;
    private javax.swing.JButton btnDatosProductos;
    private javax.swing.JButton btnDatosProveedores;
    private javax.swing.JButton btnDatosVendedores;
    private javax.swing.JButton btnRecargarPedidos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables

}
