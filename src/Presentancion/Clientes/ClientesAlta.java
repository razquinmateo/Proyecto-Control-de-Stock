/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentancion.Clientes;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import logica.Controladores.ControladorCliente;

/**
 *
 * @author UnwantedOpinion
 */
public class ClientesAlta extends javax.swing.JFrame {

    /**
     * Creates new form ClientesAlta
     */
    public ClientesAlta() {
        initComponents();
        this.setTitle("Añadir Cliente");
        this.setLocationRelativeTo(null);

            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    //codigo que se ejecuta al cerrar la ventana
                    manejoCiereVentana();
                }
            });
        }

        private void manejoCiereVentana() {
           //cierra la ventana actual (aniadirVendedor)
           this.dispose();
        }
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        JLabel11 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        JLabel12 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        JLabel13 = new javax.swing.JLabel();
        JLabel14 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnCancelar1 = new javax.swing.JButton();
        btnAgregar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("AÑADIR CLIENTE");

        JLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel11.setText("RUT:");

        JLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel12.setText("Nombre:");

        JLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel13.setText("Telefono:");

        JLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        JLabel14.setText("Correo:");

        btnCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-cancel-32.png"))); // NOI18N
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        btnAgregar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Presentancion/Iconos/icons8-checkmark-32.png"))); // NOI18N
        btnAgregar1.setText("Confirmar");
        btnAgregar1.setPreferredSize(new java.awt.Dimension(112, 39));
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel11))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel13))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel14))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
    String nombre = txtNombre1.getText().trim();
    String email = txtCorreo.getText().trim();
    String telefono = txtTelefono.getText().trim();
    
    int rut;
        try {
            rut = Integer.parseInt(txtRut.getText().trim());
            //verificar si el RUT ya existe
            ControladorCliente controlador = ControladorCliente.getInstance();
            if (controlador.existeRut(rut)) {
                JOptionPane.showMessageDialog(this, "El RUT ya está registrado","Error", JOptionPane.ERROR_MESSAGE);
                txtRut.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            //manejar el caso en que el RUT no sea un número válido
            JOptionPane.showMessageDialog(this, "RUT inválido. Debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //obtenemos la fecha actual en el formato yyyy-MM-dd
            Date fecha = Calendar.getInstance().getTime();
            java.sql.Date fechaRegistro = new java.sql.Date(fecha.getTime());

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Nombre' está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            txtNombre1.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Correo' está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            txtCorreo.requestFocus();
            return;
        }

        if (telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Teléfono' está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            txtTelefono.requestFocus();
            return;
        }

        String rutText = txtRut.getText().trim(); //convertimos a String
        if(rutText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'RUT' está vacío", "Error", JOptionPane.ERROR_MESSAGE);
            txtRut.requestFocus();
            return;
        }

        //obtenemos la instancia del controlador
        ControladorCliente controlador = ControladorCliente.getInstance();

        //llamamos al método para agregar cliente
        boolean exito = controlador.agregarCliente(nombre, email, rut, telefono, fechaRegistro);

        //mostramos mensaje según el resultado
        if (exito) {
            JOptionPane.showMessageDialog(this, "Cliente agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            //limpiamos los campos si es necesario
            txtNombre1.setText("");
            txtCorreo.setText("");
            txtRut.setText("");
            txtTelefono.setText("");
            txtNombre1.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Error al agregar cliente. Inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        this.dispose();
    }//GEN-LAST:event_btnAgregar1ActionPerformed

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
            java.util.logging.Logger.getLogger(ClientesAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientesAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientesAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientesAlta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientesAlta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel11;
    private javax.swing.JLabel JLabel12;
    private javax.swing.JLabel JLabel13;
    private javax.swing.JLabel JLabel14;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
