package Presentancion;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logica.Clases.Pedido;
import logica.Controladores.ControladorPedido;
import logica.Fabrica;
import logica.Interfaces.IControladorPedido;
import logica.Interfaces.IControladorUsuario;
import logica.servicios.PedidosServicios;

public class GestorPedidosUI extends javax.swing.JFrame {

    private IControladorUsuario ICU;
    private IControladorPedido ICP;
    private ActualizarPedido actualizarPedido = new ActualizarPedido();
    private AddPedido agregarPedido = new AddPedido();

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

        // Crear un renderizador que centre el contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Centra la primera columna
        tblPedidos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        for (Pedido pedido : pedidosDeBaseDeDatos) {
            String nombreVendedor = ICP.obtenerNombreVendedorPorId(pedido.getIdVendedor());
            String nombreCliente = ICP.obtenerNombreClientePorId(pedido.getIdCliente());
            Object[] nuevaRow = {
                pedido.getIdentificador(),
                pedido.getFechaPedido(),
                pedido.getEstado(),
                nombreVendedor,
                nombreCliente
            };
            modelo.addRow(nuevaRow);

        }
    }

    private void limpiarTablaUsuarios() {
        DefaultTableModel modelo = (DefaultTableModel) this.tblPedidos.getModel();
        modelo.setRowCount(0);
    }

    public void recargarDatosDelPedido() {
        limpiarTablaUsuarios();
        cargarDatosDePedidos();
    }

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
        btnEliminarPedido = new javax.swing.JButton();
        btnActualizarPedido = new javax.swing.JButton();
        btnAddPedido = new javax.swing.JButton();
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
                "ID", "Fecha", "Estado", "Vendedor", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        btnRecargarPedidos.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mateo\\Downloads\\recargar (2).png")); // NOI18N
        btnRecargarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarPedidosActionPerformed(evt);
            }
        });

        btnEliminarPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEliminarPedido.setText("Eliminar");
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });

        btnActualizarPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnActualizarPedido.setText("Actualizar");
        btnActualizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPedidoActionPerformed(evt);
            }
        });

        btnAddPedido.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddPedido.setText("Añadir");
        btnAddPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPedidoActionPerformed(evt);
            }
        });
        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDatosVendedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatosClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatosProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDatosProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAddPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(btnActualizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(btnEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(layout.createSequentialGroup()
                .addGap(398, 398, 398)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRecargarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRecargarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        recargarDatosDelPedido();
    }//GEN-LAST:event_btnRecargarPedidosActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        eliminarPedidoSeleccionado();
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnActualizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPedidoActionPerformed
        int row = tblPedidos.getSelectedRow();

        if (row >= 0) {
            // Obtener el ID del pedido de la tabla
            int idPedido = (int) tblPedidos.getValueAt(row, 0);

            // Obtener el pedido desde el controlador
            ControladorPedido controlador = ControladorPedido.getInstance();
            Pedido pedido = controlador.listPedidos().stream()
                    .filter(p -> p.getIdentificador() == idPedido)
                    .findFirst()
                    .orElse(null);

            if (pedido != null) {
                //Se abre la ventana de detalles
                ActualizarPedido actualizarPedido = new ActualizarPedido();
                actualizarPedido.setPedido(pedido);
                actualizarPedido.setPedidoId(idPedido);
                actualizarPedido.setVisible(true);

                // Actualiza la tabla al cerrar la ventana
                actualizarPedido.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                        recargarDatosDelPedido();
                    }
                });

            } else {
                JOptionPane.showMessageDialog(null, "Pedido no encontrado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un pedido de la tabla");
        }
    }//GEN-LAST:event_btnActualizarPedidoActionPerformed

    private void btnAddPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPedidoActionPerformed
        this.agregarPedido.setVisible(true);

        agregarPedido.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                recargarDatosDelPedido();
            }
        });
    }//GEN-LAST:event_btnAddPedidoActionPerformed

    private void eliminarPedidoSeleccionado() {
        // Obtener la fila seleccionada
        int filaSeleccionada = tblPedidos.getSelectedRow();

        if (filaSeleccionada != -1) {

            // Obtener el ID del pedido de la primera columna
            int idPedido = (int) tblPedidos.getValueAt(filaSeleccionada, 0);

            // Mostrar cuadro de diálogo de confirmación
            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que deseas eliminar este pedido?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                // Llamar al servicio para eliminar el pedido
                this.ICP.eliminarPedido(idPedido);

                // Actualizar la tabla después de la eliminación
                recargarDatosDelPedido();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un pedido para eliminar.");
        }
    }

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
    private javax.swing.JButton btnDatosClientes;
    private javax.swing.JButton btnDatosProductos;
    private javax.swing.JButton btnDatosProveedores;
    private javax.swing.JButton btnDatosVendedores;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnRecargarPedidos;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables

}
