/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import java.sql.SQLException;
import java.util.ArrayList;
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

    public static ControladorPedido getInstance() {
        if (instancia == null) {
            instancia = new ControladorPedido();
        }
        return instancia;
    }
    
    public ArrayList<Pedido> listPedidos() {
        ArrayList<Pedido> pedidos = servicioPedidos.getPedidos();
        return pedidos;
    }
}
