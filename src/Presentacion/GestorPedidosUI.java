package Presentacion;

import logica.Fabrica;
import Presentancion.Clientes.ClientesPrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
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

    public GestorPedidosUI() {
        initComponents();
        this.ICU = Fabrica.getInstance().getIControladorUsuario();
    }
    
    private void cargarDatosDePedidos() {


    }
    
    private void limpiarTablaUsuarios() {
        DefaultTableModel modelo = (DefaultTableModel) this.tblPedidos.getModel();
        modelo.setRowCount(0);
    }

    public void recargarDatosDelPedido() {
        limpiarTablaUsuarios();
        cargarDatosDePedidos();
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
        btnDatosClientes = new javax.swing.JButton();
        btnDatosVendedores = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnDatosProductos = new javax.swing.JButton();
        btnDatosCategoria = new javax.swing.JButton();
        btnRecargarPedidos1 = new javax.swing.JButton();
        btnAddPedido = new javax.swing.JButton();
        btnActualizarPedido = new javax.swing.JButton();
        btnTerminarPedido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDatosProveedores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatosProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-supply-32.png"))); // NOI18N
        btnDatosProveedores.setText("Proveedores");
        btnDatosProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosProveedoresActionPerformed(evt);
            }
        });

        btnDatosClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatosClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-customers-32.png"))); // NOI18N
        btnDatosClientes.setText("Clientes");
        btnDatosClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosClientesActionPerformed(evt);
            }
        });

        btnDatosVendedores.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatosVendedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-resume-32.png"))); // NOI18N
        btnDatosVendedores.setText("Vendedores");
        btnDatosVendedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosVendedoresActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("TABLA DE PEDIDOS");

        btnDatosProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatosProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-inventory-32.png"))); // NOI18N
        btnDatosProductos.setText("Productos");
        btnDatosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosProductosActionPerformed(evt);
            }
        });

        btnDatosCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDatosCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-label-32.png"))); // NOI18N
        btnDatosCategoria.setText("Categorias");
        btnDatosCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosCategoriaActionPerformed(evt);
            }
        });

        btnRecargarPedidos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-update-24.png"))); // NOI18N
        btnRecargarPedidos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarPedidos1ActionPerformed(evt);
            }
        });

        btnAddPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-plus-32.png"))); // NOI18N
        btnAddPedido.setText("Añadir Pedido");
        btnAddPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPedidoActionPerformed(evt);
            }
        });

        btnActualizarPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-modify-32.png"))); // NOI18N
        btnActualizarPedido.setText("Modificar Pedido");
        btnActualizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPedidoActionPerformed(evt);
            }
        });

        btnTerminarPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTerminarPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-cancel-32.png"))); // NOI18N
        btnTerminarPedido.setText("Terminar Pedido");
        btnTerminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarPedidoActionPerformed(evt);
            }
        });

        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Estado", "Vendedor", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPedidos);
        if (tblPedidos.getColumnModel().getColumnCount() > 0) {
            tblPedidos.getColumnModel().getColumn(0).setMinWidth(50);
            tblPedidos.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRecargarPedidos1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(32, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDatosVendedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDatosClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDatosProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDatosProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDatosCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddPedido)
                                .addGap(55, 55, 55)
                                .addComponent(btnActualizarPedido)
                                .addGap(53, 53, 53)
                                .addComponent(btnTerminarPedido))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRecargarPedidos1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDatosClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatosVendedores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatosProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatosProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDatosCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTerminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDatosProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosProveedoresActionPerformed

    }//GEN-LAST:event_btnDatosProveedoresActionPerformed

    private void btnDatosClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosClientesActionPerformed
           //crea una nueva instancia de la ventana ClientesPrincipal
        ClientesPrincipal ventanaClientesPrincipal = new ClientesPrincipal();
    
        //hace que la ventana sea visible
        ventanaClientesPrincipal.setVisible(true);
    }//GEN-LAST:event_btnDatosClientesActionPerformed

    private void btnDatosVendedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosVendedoresActionPerformed

    }//GEN-LAST:event_btnDatosVendedoresActionPerformed

    private void btnDatosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosProductosActionPerformed

    }//GEN-LAST:event_btnDatosProductosActionPerformed

    private void btnDatosCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosCategoriaActionPerformed

    }//GEN-LAST:event_btnDatosCategoriaActionPerformed

    private void btnRecargarPedidos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarPedidos1ActionPerformed
        recargarDatosDelPedido();
    }//GEN-LAST:event_btnRecargarPedidos1ActionPerformed

    private void btnAddPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPedidoActionPerformed

    }//GEN-LAST:event_btnAddPedidoActionPerformed

    private void btnActualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPedidoActionPerformed
       
    }//GEN-LAST:event_btnActualizarPedidoActionPerformed

    private void btnTerminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarPedidoActionPerformed
  
    }//GEN-LAST:event_btnTerminarPedidoActionPerformed

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
    private javax.swing.JButton btnActualizarPedido;
    private javax.swing.JButton btnAddPedido;
    private javax.swing.JButton btnDatosCategoria;
    private javax.swing.JButton btnDatosClientes;
    private javax.swing.JButton btnDatosProductos;
    private javax.swing.JButton btnDatosProveedores;
    private javax.swing.JButton btnDatosVendedores;
    private javax.swing.JButton btnRecargarPedidos1;
    private javax.swing.JButton btnTerminarPedido;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables

}
