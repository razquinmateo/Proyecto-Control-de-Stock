/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Interfaces;

import java.util.ArrayList;
import java.util.Date;
import logica.Clases.Pedido;

/**
 *
 * @author Mateo
 */
public interface IControladorPedido {
    
    public abstract ArrayList<Pedido> listPedidos();
    public abstract String obtenerNombreVendedorPorId(int idVendedor); 
    public abstract void eliminarPedido(int idPedido);
    public abstract void actualizarPedido(int idPedido, String estado, float total, Date fechaPedido);
}
