/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.Interfaces;

import java.util.ArrayList;
import java.util.Date;
import logica.Clases.Cliente;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jairo
 */
public interface IControladorCliente {
    public abstract ArrayList<Cliente> listarClientes();
    public abstract boolean agregarCliente(String nombre, String email, int rut, String telefono, Date fechaRegistro);
    public abstract boolean existeRut(int rut);
    public abstract boolean eliminarCliente(int rut);
    public abstract DefaultTableModel cargarDatosEnTabla();
    public abstract Cliente obtenerClientePorRut(int rut);
    public abstract boolean actualizarCliente(Cliente cliente);
    public abstract int obtenerIdClientePorNombre(String nombreCliente);
    public abstract boolean existeNombreCliente(String nombre);
    public abstract String obtenerNombreClientePorId(int idCliente);
    public abstract List<String> obtenerNombresClientes();
    
}
