package Presentancion.Proveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import logica.Fabrica;
import logica.Interfaces.IControladorUsuario;
import javax.swing.table.DefaultTableModel;
import logica.Clases.Proveedor;
import logica.Interfaces.IControladorProveedor;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableRowSorter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LucasCiceri
 */
public class datosProveedor extends javax.swing.JFrame {

    private Timer timer;
    private TableRowSorter<DefaultTableModel> sorter;
    
    private IControladorUsuario ICU;
    private IControladorProveedor ICPE;
    private AñadirProveedor añadirProveedor = new AñadirProveedor();
    private ModificarProveedor modificarProveedor = new ModificarProveedor();
    public static int idProveedor;
    
    /*private javax.swing.JTextField txtIdentificador;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtCorreo;*/
    public datosProveedor() {
        initComponents();
        this.setTitle("Datos de Proveedor");
        this.setLocationRelativeTo(null);
        this.ICU = Fabrica.getInstance().getIControladorUsuario();
        this.ICPE = Fabrica.getInstance().getIControladorProveedor();
        this.cargarDatosDelUsuario();
        
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
            btnMProveedor.setEnabled(false);
            btnDesProveedor.setEnabled(false);
            
            //agregamos un listener para la tabla que active los botones al seleccionar una fila
            tablaProveedor.getSelectionModel().addListSelectionListener(e -> {
                //si hay una fila seleccionada, habilitar los botones
                boolean seleccionValida = tablaProveedor.getSelectedRow() >= 0;
                btnMProveedor.setEnabled(seleccionValida);
                btnDesProveedor.setEnabled(seleccionValida);
            });
            
            // Inicializar el Timer
            timer = new Timer(4000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Solo actualiza si el filtro "Todos" está seleccionado y no hay texto en el JTextField
                    if (cbFiltros.getSelectedIndex() == 0 && txtBBusqueda.getText().trim().isEmpty()) {
                        cargarDatosDelUsuario(); // Llama al método para recargar datos
                    }
                }
            });
            timer.start(); // Iniciar el timer

            // Agregar filtros
            agregarFiltros();
        }
    
    private void agregarFiltros() {
        txtBBusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                pausarActualizacion(); // Pausa el timer al buscar
                aplicarFiltro();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                pausarActualizacion(); // Pausa el timer al buscar
                aplicarFiltro();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                pausarActualizacion(); // Pausa el timer al buscar
                aplicarFiltro();
            }
        });

        cbFiltros.addActionListener(e -> {
            pausarActualizacion(); // Pausa el timer al cambiar el filtro
            aplicarFiltro();
        });
    }

    private void pausarActualizacion() {
        timer.stop(); // Detener el timer
    }

    private void reanudarActualizacion() {
        // Comprobar las condiciones antes de reiniciar el timer
        if (cbFiltros.getSelectedIndex() == 0 && txtBBusqueda.getText().trim().isEmpty()) {
            timer.start(); // Reiniciar el timer solo si las condiciones son adecuadas
        }
    }
    
    // Este método debe estar fuera de los Listeners para que sea accesible desde ambos
    private void aplicarFiltro() {
        String texto = txtBBusqueda.getText().trim();
        int filtroSeleccionado = cbFiltros.getSelectedIndex();  // Índice de la opción seleccionada en el ComboBox

        if (filtroSeleccionado == 0) {
            // Buscar en todas las columnas de manera sensible a mayúsculas y minúsculas
            sorter.setRowFilter(RowFilter.regexFilter(texto));
        } else {
            // Buscar en una columna específica de manera sensible a mayúsculas y minúsculas
            int columna = filtroSeleccionado - 1;  // Restar 1 porque el índice "Todos" es 0
            sorter.setRowFilter(RowFilter.regexFilter(texto, columna));
        }
    }
    
    private void manejoCiereVentana() {
           //cierra la ventana actual (datosVendedores)
           this.dispose();
    }
    
     private void cargarDatosDelUsuario() {
        // Limpiar los datos existentes en la tabla
    DefaultTableModel modelo = (DefaultTableModel) this.tablaProveedor.getModel();
    modelo.setRowCount(0);
    
    //configuramos el TableRowSorter
        sorter = new TableRowSorter<>(modelo);
        tablaProveedor.setRowSorter(sorter);

        //creamos un renderizador que centre el contenido
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tablaProveedor.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

    // Cargar los nuevos datos desde la base de datos
    ArrayList<Proveedor> proveedorDeBaseDeDatos = this.ICPE.listarProveedores();

    for (Proveedor proveedor : proveedorDeBaseDeDatos) {
        Object[] nuevaRow = {
            proveedor.getId(),
            proveedor.getNombre(),
            proveedor.getTelefono(),
            proveedor.getDireccion(),
            proveedor.getCorreoElectronico(),
            proveedor.getActivo()  == true ? "Sí" : "No"
        };
        modelo.addRow(nuevaRow);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProveedor = new javax.swing.JTable();
        btnAProvedor = new javax.swing.JButton();
        btnMProveedor = new javax.swing.JButton();
        btnDesProveedor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBBusqueda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbFiltros = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaProveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Teléfono", "Dirección", "Correo Electronico", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProveedor);
        if (tablaProveedor.getColumnModel().getColumnCount() > 0) {
            tablaProveedor.getColumnModel().getColumn(0).setMinWidth(50);
            tablaProveedor.getColumnModel().getColumn(0).setMaxWidth(60);
            tablaProveedor.getColumnModel().getColumn(2).setMinWidth(100);
            tablaProveedor.getColumnModel().getColumn(2).setMaxWidth(110);
            tablaProveedor.getColumnModel().getColumn(5).setMinWidth(30);
            tablaProveedor.getColumnModel().getColumn(5).setMaxWidth(50);
        }

        btnAProvedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-plus-32.png"))); // NOI18N
        btnAProvedor.setText("Añadir Proveedor");
        btnAProvedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAProvedorActionPerformed(evt);
            }
        });

        btnMProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-modify-32.png"))); // NOI18N
        btnMProveedor.setText("Modificar Proveedor");
        btnMProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMProveedorActionPerformed(evt);
            }
        });

        btnDesProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-cancel-32.png"))); // NOI18N
        btnDesProveedor.setText("Deshabilitar Proveedor");
        btnDesProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesProveedorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("TABLA DE PROVEEDORES");

        jLabel2.setText("Buscar:");

        txtBBusqueda.setToolTipText("");
        txtBBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBBusquedaActionPerformed(evt);
            }
        });

        jLabel3.setText("Filtrar:");

        cbFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Nombre", "Teléfono", "Dirección", "Correo Electronico", "Activo" }));
        cbFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFiltrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(btnAProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnMProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDesProveedor)
                .addGap(29, 29, 29))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(235, 235, 235))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDesProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAProvedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAProvedorActionPerformed
        AñadirProveedor añadirProveedor = new AñadirProveedor(); 
        añadirProveedor.setVisible(true);
    }//GEN-LAST:event_btnAProvedorActionPerformed

    private void btnDesProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesProveedorActionPerformed
        int filaSeleccionada = tablaProveedor.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int id = (Integer) tablaProveedor.getValueAt(filaSeleccionada, 0);

            //confirmamos la deshabilitación
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de que desea deshabilitar este proveedor?", 
                    "Confirmar Deshabilitación", 
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                boolean exito = this.ICPE.deshabilitarProveedor(id);

                if (exito) {
                    JOptionPane.showMessageDialog(this, 
                            "Proveedor deshabilitado exitosamente.", 
                            "Éxito", 
                            JOptionPane.INFORMATION_MESSAGE);
                    actualizarTablaProveedores();
                } else {
                    JOptionPane.showMessageDialog(this, 
                            "No se pudo deshabilitar el proveedor.", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                    "Debe seleccionar un proveedor para deshabilitar.", 
                    "Advertencia", 
                    JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDesProveedorActionPerformed

    private void btnMProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMProveedorActionPerformed
        int filaSeleccionada = tablaProveedor.getSelectedRow();
        
        if (filaSeleccionada >= 0) {
            int id = (Integer) tablaProveedor.getValueAt(filaSeleccionada, 0);
            String nombre = (String) tablaProveedor.getValueAt(filaSeleccionada, 1);
            String telefono = (String) tablaProveedor.getValueAt(filaSeleccionada, 2);
            String direccion = (String) tablaProveedor.getValueAt(filaSeleccionada, 3);
            String correo = (String) tablaProveedor.getValueAt(filaSeleccionada, 4);
            String activoStr = (String) tablaProveedor.getValueAt(filaSeleccionada, 5);
            
            //comparamos con equals() y convertimos a boolean
            Boolean activo = activoStr.equals("Sí");

            int confirmacion = JOptionPane.showConfirmDialog(this, 
                    "¿Está seguro de que desea modificar este vendedor?", 
                    "Confirmar Modificación", 
                    JOptionPane.YES_NO_OPTION);


            if (confirmacion == JOptionPane.YES_OPTION) {
                ModificarProveedor modificarProveedor = new ModificarProveedor();
                modificarProveedor.setId(id);
                modificarProveedor.setNombre(nombre);
                modificarProveedor.setTelefono(telefono);
                modificarProveedor.setDireccion(direccion);
                modificarProveedor.setCorreo(correo);
                modificarProveedor.setActivo(activo);
                modificarProveedor.setVisible(true);

            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un vendedor para modificar.");
        }
    }//GEN-LAST:event_btnMProveedorActionPerformed

    private void txtBBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBBusquedaActionPerformed

    private void cbFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFiltrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFiltrosActionPerformed
    
    private void actualizarTablaProveedores() {
    DefaultTableModel modelo = (DefaultTableModel) tablaProveedor.getModel();
    modelo.setRowCount(0); // Limpia las filas actuales
    
    // Recarga los datos de los proveedores
    cargarDatosDelUsuario();
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
            java.util.logging.Logger.getLogger(datosProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(datosProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(datosProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(datosProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new datosProveedor().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAProvedor;
    private javax.swing.JButton btnDesProveedor;
    private javax.swing.JButton btnMProveedor;
    private javax.swing.JComboBox<String> cbFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProveedor;
    private javax.swing.JTextField txtBBusqueda;
    // End of variables declaration//GEN-END:variables

}
