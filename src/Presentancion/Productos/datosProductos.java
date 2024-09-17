/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentancion.Productos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Clases.Producto;
import logica.servicios.ProductoServicios;


/**
 *
 * @author UnwantedOpinion
 */
public class datosProductos extends javax.swing.JFrame {

    /**
     * Creates new form datosProductos
     */
    public datosProductos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Datos de Productos");
        cargarDatos();//llama al método para llenar la tabla
       
        //manejamos el evento de cierre de la ventana
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //codigo que se ejecuta al cerrar la ventana
                manejoCiereVentana();
            }
        });
        
        //deshabilitamos los botones mod y elim
        btnModProducto.setEnabled(false);
        btnElimProducto.setEnabled(false);
        
        //agregamos un listener para la tabla que active los botones al seleccionar una fila
        tblListarProductos.getSelectionModel().addListSelectionListener(e -> {
            //si hay una fila seleccionada, habilitar los botones
            boolean seleccionValida = tblListarProductos.getSelectedRow() >= 0;
            btnModProducto.setEnabled(seleccionValida);
            btnElimProducto.setEnabled(seleccionValida);
        });
    }
     
    private void manejoCiereVentana() {
       //cierra la ventana actual (datosVendedores)
       this.dispose();
    }
    
    public void cargarDatos() {
        ProductoServicios productoServicios = new ProductoServicios();
        ArrayList<Producto> productos = productoServicios.listarProductos();

        //obtenemos el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblListarProductos.getModel();

        //limpiamos la tabla antes de agregar los nuevos datos
        modelo.setRowCount(0);

        //agregamos filas a la tabla
        for (Producto producto : productos) {
            modelo.addRow(new Object[]{
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getSKU(),
                producto.getPrecioVenta(),
                producto.getStock(),
                producto.getCategoria().getNombre()
            });
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListarProductos = new javax.swing.JTable();
        btnAltaProducto = new javax.swing.JButton();
        btnModProducto = new javax.swing.JButton();
        btnElimProducto = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TABLA DE PRODUCTOS");

        tblListarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "SKU", "Precio", "Stock", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListarProductos);
        if (tblListarProductos.getColumnModel().getColumnCount() > 0) {
            tblListarProductos.getColumnModel().getColumn(0).setMinWidth(50);
            tblListarProductos.getColumnModel().getColumn(0).setMaxWidth(60);
            tblListarProductos.getColumnModel().getColumn(2).setMinWidth(250);
            tblListarProductos.getColumnModel().getColumn(2).setMaxWidth(260);
            tblListarProductos.getColumnModel().getColumn(3).setMinWidth(100);
            tblListarProductos.getColumnModel().getColumn(3).setMaxWidth(110);
            tblListarProductos.getColumnModel().getColumn(4).setMinWidth(50);
            tblListarProductos.getColumnModel().getColumn(4).setMaxWidth(60);
            tblListarProductos.getColumnModel().getColumn(5).setMinWidth(60);
            tblListarProductos.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        btnAltaProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-plus-32.png"))); // NOI18N
        btnAltaProducto.setText("Añadir Producto");
        btnAltaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaProductoActionPerformed(evt);
            }
        });

        btnModProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-modify-32.png"))); // NOI18N
        btnModProducto.setText("Modificar Producto");
        btnModProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModProductoActionPerformed(evt);
            }
        });

        btnElimProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-cancel-32.png"))); // NOI18N
        btnElimProducto.setText("Eliminar Producto");
        btnElimProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElimProductoActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-update-24.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(btnActualizar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(btnAltaProducto)
                .addGap(83, 83, 83)
                .addComponent(btnModProducto)
                .addGap(72, 72, 72)
                .addComponent(btnElimProducto)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAltaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElimProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAltaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaProductoActionPerformed
        //crea una nueva instancia de la ventana aniadirProducto
        aniadirProducto ventanaAniadirProducto = new aniadirProducto();
    
        //hace que la ventana sea visible
        ventanaAniadirProducto.setVisible(true);
    }//GEN-LAST:event_btnAltaProductoActionPerformed

    private void btnModProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModProductoActionPerformed
        int filaSeleccionada = tblListarProductos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int id = (Integer) tblListarProductos.getValueAt(filaSeleccionada, 0);
            String nombre = (String) tblListarProductos.getValueAt(filaSeleccionada, 1);
            String descripcion = (String) tblListarProductos.getValueAt(filaSeleccionada, 2);
            String sku = (String) tblListarProductos.getValueAt(filaSeleccionada, 3);
            float precioVenta = (Float) tblListarProductos.getValueAt(filaSeleccionada, 4);
            int stock = (Integer) tblListarProductos.getValueAt(filaSeleccionada, 5);

        int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Está seguro de que desea modificar este vendedor?", 
                "Confirmar Modificación", 
                JOptionPane.YES_NO_OPTION);
        
        if (confirmacion == JOptionPane.YES_OPTION) {
            modificarProducto ventanaModificacion = new modificarProducto();
            ventanaModificacion.setId(id);
            ventanaModificacion.setNombre(nombre);
            ventanaModificacion.setDescripcion(descripcion);
            ventanaModificacion.setSKU(sku);
            ventanaModificacion.setPrecioVenta(precioVenta);
            ventanaModificacion.setStock(stock);
            ventanaModificacion.setVisible(true);
        }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un producto para modificar.");
        }
    }//GEN-LAST:event_btnModProductoActionPerformed

    private void btnElimProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElimProductoActionPerformed
        int selectedRow = tblListarProductos.getSelectedRow();
    
        if (selectedRow >= 0) {
            int id = (Integer) tblListarProductos.getValueAt(selectedRow, 0);
            
            ProductoServicios productoServicios = new ProductoServicios();
        
            //verificamos si el producto está asociado a algún pedido
            if (productoServicios.productoEnPedidos(id)) {
                JOptionPane.showMessageDialog(this, 
                        "No se puede eliminar el producto porque está asociado a uno o más pedidos.", 
                        "Advertencia", 
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmar = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de que desea eliminar este producto?", 
                    "Confirmar Eliminación", 
                    JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION) {
                ProductoServicios servicios = new ProductoServicios();
                boolean exito = servicios.eliminarProducto(id);

                if (exito) {
                    JOptionPane.showMessageDialog(this, 
                            "Producto eliminado exitosamente.", 
                            "Éxito", 
                            JOptionPane.INFORMATION_MESSAGE);
                    cargarDatos();
                } else {
                    JOptionPane.showMessageDialog(this, 
                            "Error al eliminar el producto.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un producto para eliminar.", 
                    "Advertencia", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnElimProductoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
            java.util.logging.Logger.getLogger(datosProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datosProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datosProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datosProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datosProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAltaProducto;
    private javax.swing.JButton btnElimProducto;
    private javax.swing.JButton btnModProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListarProductos;
    // End of variables declaration//GEN-END:variables
}
