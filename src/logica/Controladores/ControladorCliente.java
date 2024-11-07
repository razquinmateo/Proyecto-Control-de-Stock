/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import java.sql.SQLException;
import logica.Interfaces.IControladorCliente;
import logica.Clases.Cliente;
import logica.servicios.ClienteServicios;
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
    
    public boolean agregarCliente(String nombre, String email, String identificador, String telefono, String direccion, Date fechaRegistro) {
        Cliente cliente = new Cliente(nombre, email, identificador, telefono, direccion, fechaRegistro);
        return ClienteServicios.agregarCliente(cliente);
    }
    
    public boolean existeIdentificador(String identificador) {
    return ClienteServicios.existeIdentificador(identificador);
}

    public boolean deshabilitarCliente(String identificador) {
        // Verifica si el cliente con el Identificador dado existe
        if (!ClienteServicios.existeIdentificador(identificador)) {
            return false; // Cliente no encontrado
        }
        // Realiza la eliminación del cliente
        return ClienteServicios.deshabilitarCliente(identificador);
    }
    
    public DefaultTableModel cargarDatosEnTabla() {
    DefaultTableModel modeloTabla = new DefaultTableModel();
    modeloTabla.addColumn("Identificador");
    modeloTabla.addColumn("Nombre");
    modeloTabla.addColumn("Teléfono");
    modeloTabla.addColumn("Dirección");
    modeloTabla.addColumn("Correo");
    modeloTabla.addColumn("Activo");

    ArrayList<Cliente> clientes = listarClientes();

    for (Cliente cliente : clientes) {
        Object[] fila = {
            cliente.getIdentificador(),
            cliente.getNom_empresa(),
            cliente.getTelefono(),
            cliente.getDireccion(),
            cliente.getCorreo_electronico(),
            (cliente.getActivo() != null && cliente.getActivo()) ? "Sí" : "No"
        };
        modeloTabla.addRow(fila);
    }
    return modeloTabla;
}
    
    // Método para obtener un cliente por su Identificador
    public Cliente getClientePorIdentificador(String identificador) {
        return ClienteServicios.getClientePorIdentificador(identificador);
    }
    
    public boolean actualizarCliente(Cliente cliente) {
        return ClienteServicios.actualizarCliente(cliente);
    }
    
    @Override
    public int obtenerIdClientePorNombre(String nombreCliente){
        return ClienteServicios.obtenerIdClientePorNombre(nombreCliente);
    }
    
    @Override
    public boolean existeNombreCliente(String nombre){
        return ClienteServicios.existeNombreCliente(nombre);
    }

    @Override
    public String obtenerNombreClientePorId(int idCliente) {
        String nombreCliente = "";
        return nombreCliente = ClienteServicios.getNombreClientePorId(idCliente);
    }

    @Override
    public List<String> obtenerNombresClientes() {
        return ClienteServicios.obtenerNombresClientes();
    }
    
    @Override
    public List<String> obtenerNombresClientesActivos(){
        return ClienteServicios.obtenerNombresClientesActivos();
    }
    
    @Override
    public ArrayList<Cliente> getClientesActivos(){
        return ClienteServicios.getClientesActivos();
    }
    
    @Override
    public String getNombreClientePorId(int idCliente){
        return ClienteServicios.getNombreClientePorId(idCliente);
    }
    
    @Override
    public int obtenerIdPorNombre(String nombreCliente){
        return ClienteServicios.obtenerIdPorNombre(nombreCliente);
    }
}
