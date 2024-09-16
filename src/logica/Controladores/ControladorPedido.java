/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import logica.Clases.Pedido;
import logica.Clases.Pedido.Estado;
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

    @Override
    //Devuelve todos los pedidos
    public ArrayList<Pedido> getPedidos() {
        ArrayList<Pedido> pedidos = servicioPedidos.getPedidos();
        return pedidos;
    }

    @Override
    //Devuelve el nombre del vendedor
    public String obtenerNombreVendedorPorId(int idVendedor) {
        String nombreVendedor = "";

        try {
            nombreVendedor = servicioPedidos.getNombreVendedorPorId(idVendedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreVendedor;
    }
    
    @Override
    public String obtenerNombreClientePorId(int idCliente) {
        String nombreCliente = "";

        try {
            nombreCliente = servicioPedidos.getNombreClientePorId(idCliente);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nombreCliente;
    }

    @Override
    public boolean eliminarPedido(int idPedido) {
        return servicioPedidos.eliminarPedido(idPedido);
    }

    @Override
    public boolean actualizarPedido(int idPedido, Estado estado, float total) {
        return servicioPedidos.actualizarPedido(idPedido, estado, total);
    }
    
    @Override
    // Valida si el vendedor existe
    public boolean validarVendedor(int idVendedor) {
        try {
            return servicioPedidos.getNombreVendedorPorId(idVendedor) != null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    // Valida si el cliente existe
    public boolean validarCliente(int idCliente) {
        try {
            return servicioPedidos.getNombreClientePorId(idCliente) != null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    // Método para agregar un pedido
    @Override
    public boolean agregarPedido(Pedido pedido) {
        // Validar si el vendedor existe
        if (!validarVendedor(pedido.getIdVendedor())) {
            System.err.println("El VendedorID no existe.");
            return false;
        }

        // Validar si el cliente existe
        if (!validarCliente(pedido.getIdCliente())) {
            System.err.println("El ClienteID no existe.");
            return false;
        }

        // Si ambos son válidos, se procede a agregar el pedido
        boolean exito = servicioPedidos.agregarPedido(pedido);
        return exito;
    }
    
    @Override
    public List<String> obtenerNombresVendedores() {
        return servicioPedidos.obtenerNombresVendedores();
    }

    @Override
    public List<String> obtenerNombresClientes() {
        return servicioPedidos.obtenerNombresVendedores();
    }
    
    @Override
    public boolean actualizarEstadoPedido(int idPedido, String nuevoEstado){
        return servicioPedidos.actualizarEstadoPedido(idPedido, nuevoEstado);
    }

}
