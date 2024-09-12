/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import logica.Clases.Pedido;
import logica.Interfaces.IControladorPedido;
import logica.servicios.PedidosServicios;

/**
 *
 * @author Mateo
 */
public class ControladorPedido implements IControladorPedido {

    private Map<String, Pedido> Pedidos;
    private PedidosServicios servicioPedidos;
    private static ControladorPedido instancia;

    public ControladorPedido() {
        this.servicioPedidos = new PedidosServicios();
    }

    //Metodo Singleton
    public static ControladorPedido getInstance() {
        if (instancia == null) {
            instancia = new ControladorPedido();
        }
        return instancia;
    }

    //Devuelve todos los pedidos
    public ArrayList<Pedido> listPedidos() {
        ArrayList<Pedido> pedidos = servicioPedidos.getPedidos();
        return pedidos;
    }

    //Devuelve el nombre del vendedor
    public String obtenerNombreVendedorPorId(int idVendedor) {
        String nombreVendedor = "";

        try {
            nombreVendedor = servicioPedidos.getNombreVendedorById(idVendedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreVendedor;
    }
    
    public String obtenerNombreClientePorId(int idCliente) {
        String nombreCliente = "";

        try {
            nombreCliente = servicioPedidos.getNombreClienteById(idCliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreCliente;
    }

    public void eliminarPedido(int idPedido) {
        try {
            servicioPedidos.eliminarPedido(idPedido);
        } catch (Exception e) {
            System.err.println("Ocurrió un error al eliminar el pedido: " + e.getMessage());
        }
    }

    public void actualizarPedido(int idPedido, String estado, float total) {
        try {
            servicioPedidos.actualizarPedido(idPedido, estado, total);
        } catch (SQLException e) {
            System.err.println("Error al actualizar el pedido: " + e.getMessage());
        }
    }
    
    // Valida si el vendedor existe
    public boolean validarVendedor(int idVendedor) {
        try {
            return servicioPedidos.getNombreVendedorById(idVendedor) != null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Valida si el cliente existe
    public boolean validarCliente(int idCliente) {
        try {
            return servicioPedidos.getNombreClienteById(idCliente) != null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Método para agregar un pedido
    @Override
    public void agregarPedido(Pedido pedido) {
        // Validar si el vendedor existe
        if (!validarVendedor(pedido.getIdVendedor())) {
            System.err.println("El VendedorID no existe.");
            return;
        }

        // Validar si el cliente existe
        if (!validarCliente(pedido.getIdCliente())) {
            System.err.println("El ClienteID no existe.");
            return;
        }

        // Si ambos son válidos, se procede a agregar el pedido
        servicioPedidos.agregarPedido(pedido);
    }

}
