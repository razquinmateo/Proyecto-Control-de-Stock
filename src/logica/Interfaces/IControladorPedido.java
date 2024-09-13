/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Interfaces;

import java.util.ArrayList;
import java.util.List;
import logica.Clases.Pedido;
import logica.Clases.Pedido.Estado;

/**
 *
 * @author Mateo
 */
public interface IControladorPedido {
    
    public abstract ArrayList<Pedido> getPedidos();
    public abstract String obtenerNombreVendedorPorId(int idVendedor); 
    public abstract String obtenerNombreClientePorId(int idCliente);
    public abstract boolean eliminarPedido(int idPedido);
    public abstract boolean actualizarPedido(int idPedido, Estado estado, float total);
    public abstract boolean agregarPedido(Pedido pedido);
    public abstract boolean validarVendedor(int idVendedor);
    public abstract boolean validarCliente(int idCliente); 
    public abstract List<String> obtenerNombresVendedores();
    public abstract List<String> obtenerNombresClientes();
}
