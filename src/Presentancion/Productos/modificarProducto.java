/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentancion.Productos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.JOptionPane;
import logica.Clases.Categoria;
import logica.Clases.Producto;
import logica.servicios.CategoriaServicios;
import logica.servicios.ProductoServicios;

/**
 *
 * @author UnwantedOpinion
 */
public class modificarProducto extends javax.swing.JFrame {

    private int id;
    /**
     * Creates new form modificarProducto
     */
    public modificarProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Modificar Producto");

            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //codigo que se ejecuta al cerrar la ventana
                    manejoCiereVentana();
                }
            });
            cargarCategorias();
        }

        private void manejoCiereVentana() {
           //cierra la ventana actual
           this.dispose();
        }
        
        public void setId(int id) {
        this.id = id;
        cargarProducto();
    }

    public void setNombre(String nombre) {
        txtNombre.setText(nombre);
    }

    public void setDescripcion(String descripcion) {
        txtDescripcion.setText(descripcion);
    }

    public void setSKU(String sku) {
        txtSKU.setText(sku);
    }

    public void setPrecioVenta(float precioVenta) {
        txtPrecioVenta.setText(String.valueOf(precioVenta));
    }

    public void setStock(int stock) {
        txtStock.setText(String.valueOf(stock));
    }

    public void setCategoria(Categoria categoria) {
        CbCategoria.setSelectedItem(categoria.getNombre());
    }
    
    private void cargarCategorias() {
        CategoriaServicios categoriaServicios = new CategoriaServicios();
        CbCategoria.removeAllItems();
        List<Categoria> categorias = categoriaServicios.listarCategorias();
        for (Categoria categoria : categorias) {
            CbCategoria.addItem(categoria.getNombre());
        }
    }
    
    private void cargarProducto() {
        ProductoServicios productoServicios = new ProductoServicios();
        Producto producto = productoServicios.buscarProducto(id);
        if (producto != null) {
            setNombre(producto.getNombre());
            setDescripcion(producto.getDescripcion());
            setSKU(producto.getSKU());
            setPrecioVenta(producto.getPrecioVenta());
            setStock(producto.getStock());
            setCategoria(producto.getCategoria());
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
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
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtSKU = new javax.swing.JTextField();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        CbCategoria = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("MODIFICAR PRODUCTO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Nombre:");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Descripcion:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("SKU:");

        txtSKU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSKUActionPerformed(evt);
            }
        });

        txtPrecioVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioVentaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Precio Venta:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Stock:");

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Categoria:");

        btnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-checkmark-32.png"))); // NOI18N
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-cancel-32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtSKU, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)))))
                .addGap(67, 67, 67))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSKU, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtSKUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSKUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSKUActionPerformed

    private void txtPrecioVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioVentaActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String nombre = txtNombre.getText().trim();
        String descripcion = txtDescripcion.getText().trim();
        String sku = txtSKU.getText().trim();
        String precioVentaStr = txtPrecioVenta.getText().trim();
        String stockStr = txtStock.getText().trim();
        String categoriaNombre = (String) CbCategoria.getSelectedItem();

        if (nombre.isEmpty() || descripcion.isEmpty() || sku.isEmpty() || precioVentaStr.isEmpty() || stockStr.isEmpty() || categoriaNombre == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float precioVenta;
        int stock;

        try {
            precioVenta = Float.parseFloat(precioVentaStr);
            stock = Integer.parseInt(stockStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Precio de venta y stock deben ser numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //creamos un objeto Producto
        Producto producto = new Producto();
        producto.setId(id);
        producto.setNombre(nombre);
        producto.setDescripcion(descripcion);
        producto.setSKU(sku);
        producto.setPrecioVenta(precioVenta);
        producto.setStock(stock);

        //obtenemos la categoría seleccionada
        CategoriaServicios categoriaServicios = new CategoriaServicios();
        Categoria categoriaSeleccionada = categoriaServicios.buscarCategoriaPorNombre(categoriaNombre);
        if (categoriaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Categoría seleccionada no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        producto.setCategoria(categoriaSeleccionada);

        //modificamos el producto en la base de datos
        ProductoServicios productoServicios = new ProductoServicios();
        boolean exito = productoServicios.modificarProducto(id, producto);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Producto modificado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Error al modificar el producto. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        int confirmar = JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de que deseas cancelar? Los cambios no guardados se perderán.",
            "Confirmar Cancelación",
            JOptionPane.YES_NO_OPTION);

        if(confirmar == JOptionPane.YES_OPTION) {
            //cerramos la ventana actual
            this.dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbCategoria;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtSKU;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

}