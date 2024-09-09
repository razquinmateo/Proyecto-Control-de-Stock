/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;
import logica.Interfaces.IControladorCliente;
import logica.Clases.Cliente;
import logica.servicios.ClienteServicios;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jairo
 */
public class ControladorCliente implements IControladorCliente {
    private ClienteServicios ClienteServicios;
    private static ControladorCliente instancia;

    public ControladorCliente() {
        this.ClienteServicios = new ClienteServicios();
    }

    public static ControladorCliente getInstance() {
        if (instancia == null) {
            instancia = new ControladorCliente();
        }
        return instancia;
    }

    public ArrayList<Cliente> listarClientes() {
        ArrayList<Cliente> clientes = ClienteServicios.getClientes();
        return clientes;
    }
    
    public boolean agregarCliente(String nombre, String email, int rut, String telefono, Date fechaRegistro) {
        Cliente cliente = new Cliente(nombre, email, rut, telefono, fechaRegistro);
        return ClienteServicios.agregarCliente(cliente);
    }
    
    public boolean existeRut(int rut) {
    return ClienteServicios.existeRut(rut);
}

    public boolean eliminarCliente(int rut) {
        // Verifica si el cliente con el RUT dado existe
        if (!ClienteServicios.existeRut(rut)) {
            return false; // Cliente no encontrado
        }
        // Realiza la eliminación del cliente
        return ClienteServicios.eliminarCliente(rut);
    }
    
    public DefaultTableModel cargarDatosEnTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("RUT");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Correo");

        ArrayList<Cliente> clientes = listarClientes();

        for (Cliente cliente : clientes) {
            Object[] fila = {
                cliente.getNum_rut(),
                cliente.getNom_empresa(),
                cliente.getTelefono(),
                cliente.getCorreo_electronico()
            };
            modeloTabla.addRow(fila);
        }
        return modeloTabla;
    }
    
    // Método para obtener un cliente por su RUT
    public Cliente obtenerClientePorRut(int rut) {
        return ClienteServicios.getClientePorRut(rut);
    }
    
    public boolean actualizarCliente(Cliente cliente) {
        return ClienteServicios.actualizarCliente(cliente);
    }

}
