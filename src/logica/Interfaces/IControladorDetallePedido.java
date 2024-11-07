/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.Interfaces;

import java.util.List;
import logica.Clases.DetallePedido;

/**
 *
 * @author UnwantedOpinion
 */
public interface IControladorDetallePedido {
    public abstract boolean eliminarDetallesPedido(int idPedido);
    public abstract boolean agregarDetallePedido(int idPedido, DetallePedido detalle);
    public abstract List<DetallePedido> obtenerDetallesPedido(int idPedido);
    public abstract boolean actualizarDetallesPedido(int idPedido, List<DetallePedido> detalles);
}