/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Interfaces;

import java.util.ArrayList;
import java.util.List;
import logica.Clases.DetallePedido;
import logica.Clases.Pedido;
import logica.Clases.Pedido.Estado;

/**
 *
 * @author Mateo
 */
public interface IControladorPedido {
    
    public abstract ArrayList<Pedido> getPedidos();
    public abstract boolean eliminarPedido(int idPedido);
    public abstract boolean actualizarPedido(Pedido pedido);
    public abstract boolean agregarPedido(Pedido pedido);
    public abstract boolean actualizarEstadoPedido(int idPedido, String nuevoEstado);
    public abstract ArrayList<Pedido> getPedidosPorVendedor(int idVendedor);
    public abstract ArrayList<Pedido> getPedidosPorVendedorYFecha(int idVendedor, int mes, int año);
    public abstract ArrayList<Pedido> getPedidosPorVendedorClienteYFecha(int idVendedor, int clienteId, int mes, int año);
    public abstract ArrayList<Pedido> getPedidosPorVendedorCategoriaYFecha(int idVendedor, int mes, int año, Integer idCategoria);
    public abstract ArrayList<Pedido> getPedidosPorVendedorTodos(int idVendedor, int mes, int año, Integer idCategoria, Integer idCliente);
    public abstract boolean cancelarPedido(int idPedido);
    public abstract Pedido obtenerPedidoPorId(int idPedido);
    public abstract List<DetallePedido> obtenerDetallesPedido(int idPedido);
    public abstract boolean agregarPedido1(Pedido pedido);
}
