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

    public void eliminarPedido(int idPedido) {
        try {
            servicioPedidos.eliminarPedido(idPedido);
        } catch (Exception e) {
            System.err.println("Ocurrió un error al eliminar el pedido: " + e.getMessage());
        }
    }

    public void actualizarPedido(int idPedido, String estado, float total, Date fechaPedido) {
        try {
            servicioPedidos.actualizarPedido(idPedido, estado, total, fechaPedido);
        } catch (SQLException e) {
            System.err.println("Error al actualizar el pedido: " + e.getMessage());
        }
    }

}
