/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentancion.Productos;

import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import logica.Clases.Categoria;
import logica.Clases.Producto;
import logica.Clases.Proveedor;
import logica.Fabrica;
import logica.Interfaces.IControladorCategoria;
import logica.Interfaces.IControladorProducto;
import logica.Interfaces.IControladorProveedor;

/**
 *
 * @author UnwantedOpinion
 */
public class modificarProducto extends javax.swing.JFrame {

    private int id;
    private DefaultListModel<String> listModel;
    private IControladorProveedor ICP;
    private IControladorProducto ICPr;
    private IControladorCategoria ICC;
    private Producto producto;
    /**
     * Creates new form modificarProducto
     */
    public modificarProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        listModel = new DefaultListModel<>();
        jListProveedores.setModel(listModel);
        this.ICC = Fabrica.getInstance().getIControladorCategoria();
        this.ICP = Fabrica.getInstance().getIControladorProveedor();
        this.ICPr = Fabrica.getInstance().getIControladorProducto();
        this.setTitle("Modificar Producto");
        
        producto = new Producto();

            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //codigo que se ejecuta al cerrar la ventana
                    manejoCiereVentana();
                }
            });
            cargarCategorias();
            cargarProveedores();
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
        CbCategoria.removeAllItems();
        CbCategoria.addItem("--Selecciona una categoria--");
        List<Categoria> categorias = this.ICC.listarCategorias();
        for (Categoria categoria : categorias) {
            CbCategoria.addItem(categoria.getNombre());
        }
    }
    
    private void cargarProducto() {
        Producto producto = this.ICPr.buscarProducto(id);
        if (producto != null) {
            setNombre(producto.getNombre());
            setDescripcion(producto.getDescripcion());
            setSKU(producto.getSKU());
            setPrecioVenta(producto.getPrecioVenta());
            setStock(producto.getStock());
            setCategoria(producto.getCategoria());
            
            //cargamos la imagen en lblImagen
            if (producto.getImagen() != null) {
                ImageIcon icon = new ImageIcon(producto.getImagen());
                Image scaledImage = icon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(scaledImage));
            } else {
                lblImagen.setIcon(null);//limpiamo la imagen si no se encuentra
            }
            
            cargarProveedoresAsociados();
        } else {
            JOptionPane.showMessageDialog(this, "Producto no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cargarProveedores() {
        List<Proveedor> proveedoresActivos = this.ICP.listarProveedoresActivos();
        CbProveedor.removeAllItems();
        CbProveedor.addItem("--Selecciona un proveedor--");

        for (Proveedor proveedor : proveedoresActivos) {
            CbProveedor.addItem(proveedor.getNombre());
        }
    }

    
    private void cargarProveedoresAsociados() {
        //obtenemos los IDs de los proveedores asociados al producto
        List<Integer> proveedorIDs = this.ICPr.obtenerProveedoresPorProductoID(id);

        //kimpiamos el modelo de la lista
        listModel.clear();

        //obtenemos los nombres de los proveedores basados en los IDs
        for (int proveedorID : proveedorIDs) {
            String nombreProveedor = this.ICP.obtenerNombreProveedorPorID(proveedorID);
            if (nombreProveedor != null) {
                listModel.addElement(nombreProveedor);
            }
        }
    }

    private byte[] obtenerImagenBytes() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Imagen");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));

        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                return Files.readAllBytes(file.toPath());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer la imagen: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return null;
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
        jLabel8 = new javax.swing.JLabel();
        CbProveedor = new javax.swing.JComboBox<>();
        btnAñadirProveedor = new javax.swing.JButton();
        btnLimpiarProveedores = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListProveedores = new javax.swing.JList<>();
        lblImagen = new javax.swing.JLabel();
        btnSubirImg = new javax.swing.JButton();

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

        CbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbCategoriaActionPerformed(evt);
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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Proveedor(es):");

        CbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbProveedorActionPerformed(evt);
            }
        });

        btnAñadirProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-plus-24.png"))); // NOI18N
        btnAñadirProveedor.setText("Añadir");
        btnAñadirProveedor.setBorderPainted(false);
        btnAñadirProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirProveedorActionPerformed(evt);
            }
        });

        btnLimpiarProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-delete-24.png"))); // NOI18N
        btnLimpiarProveedores.setText("Limpiar");
        btnLimpiarProveedores.setBorderPainted(false);
        btnLimpiarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProveedoresActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jListProveedores);

        lblImagen.setBackground(new java.awt.Color(255, 255, 255));
        lblImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btnSubirImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-upload-24.png"))); // NOI18N
        btnSubirImg.setText("Subir Imagen");
        btnSubirImg.setBorderPainted(false);
        btnSubirImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(30, 30, 30)
                        .addComponent(CbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnAñadirProveedor)
                            .addGap(18, 18, 18)
                            .addComponent(btnLimpiarProveedores)))
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
                                .addComponent(txtNombre)
                                .addComponent(txtSKU)
                                .addComponent(txtStock)
                                .addComponent(txtPrecioVenta)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSubirImg)
                        .addGap(70, 70, 70)))
                .addGap(12, 12, 12))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(213, 213, 213))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(CbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubirImg)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAñadirProveedor)
                    .addComponent(btnLimpiarProveedores))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
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
        
        //verificamos que el nombre solo contenga letras
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this, "El nombre del producto solo debe contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
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
        
        byte[] imagenNueva = producto.getImagen();
        byte[] imagenAntigua = this.ICPr.buscarProducto(id).getImagen();

        //solo actualizar imagenAntigua si hay una imagen nueva
        if (imagenNueva != null) {
            imagenAntigua = imagenNueva;
        }
        //verificamos si el nombre o el SKU ya están en uso
        Producto productoExistentePorNombre = this.ICPr.buscarProductoPorNombre(nombre);
        Producto productoExistentePorSKU = this.ICPr.buscarProductoPorSKU(sku);

        //verificamos si el nombre o el SKU ya están en uso y no corresponden al producto actual
        if ((productoExistentePorNombre != null && productoExistentePorNombre.getId() != id) || 
        (productoExistentePorSKU != null && productoExistentePorSKU.getId() != id)) {
            JOptionPane.showMessageDialog(this, "El nombre o el SKU ya están en uso por otro producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //creamos un objeto Producto
        Producto productoModificado = new Producto();
        productoModificado.setId(id);
        productoModificado.setNombre(nombre);
        productoModificado.setDescripcion(descripcion);
        productoModificado.setSKU(sku);
        productoModificado.setPrecioVenta(precioVenta);
        productoModificado.setStock(stock);
        productoModificado.setImagen(imagenAntigua);

        //obtenemos la categoría seleccionada
        Categoria categoriaSeleccionada = this.ICC.buscarCategoriaPorNombre(categoriaNombre);
        if (categoriaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Categoría seleccionada no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        productoModificado.setCategoria(categoriaSeleccionada);

        //modificamos el producto en la base de datos
        boolean exito = this.ICPr.modificarProducto(id, productoModificado);

        if (exito) {
            //nos aseguramos que el JList de proveedores no esté vacío
            if (listModel.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //limpiamos las filas existentes en producto_proveedor
            this.ICPr.eliminarProveedoresPorProductoID(id);

            //agregamos las nuevas filas en producto_proveedor
            for (int i = 0; i < listModel.size(); i++) {
                String nombreProveedor = listModel.getElementAt(i);
                int proveedorID = this.ICP.obtenerProveedorIDPorNombre(nombreProveedor);
                if (proveedorID != -1) {
                    this.ICPr.agregarProductoProveedor(id, proveedorID);
                }
            }
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

    private void CbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbCategoriaActionPerformed

    private void CbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbProveedorActionPerformed

    private void btnAñadirProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirProveedorActionPerformed
        String proveedorSeleccionado = (String) CbProveedor.getSelectedItem();

        if(proveedorSeleccionado != "--Selecciona un proveedor--"){
            if (proveedorSeleccionado != null && !proveedorSeleccionado.isEmpty()) {
                if (!listModel.contains(proveedorSeleccionado)) {
                    listModel.addElement(proveedorSeleccionado);
                } else {
                    JOptionPane.showMessageDialog(this, "El proveedor ya está en la lista.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor selecciona un proveedor.");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor selecciona un proveedor.");
        }

    }//GEN-LAST:event_btnAñadirProveedorActionPerformed

    private void btnLimpiarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProveedoresActionPerformed
        listModel.clear();
    }//GEN-LAST:event_btnLimpiarProveedoresActionPerformed

    private void btnSubirImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirImgActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar Imagen");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "jpeg", "png", "gif"));

        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                byte[] imagenBytes = Files.readAllBytes(selectedFile.toPath());
                producto.setImagen(imagenBytes);
                ImageIcon icon = new ImageIcon(imagenBytes);
                Image scaledImage = icon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                lblImagen.setIcon(new ImageIcon(scaledImage));
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSubirImgActionPerformed

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
    private javax.swing.JComboBox<String> CbProveedor;
    private javax.swing.JButton btnAñadirProveedor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnLimpiarProveedores;
    private javax.swing.JButton btnSubirImg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JList<String> jListProveedores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioVenta;
    private javax.swing.JTextField txtSKU;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

}
