/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import logica.Clases.DetallePedido;
import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author UnwantedOpinion
 */
public class DetallePedidoServicios {
    private Connection conexion = new ConexionDB().getConexion();
    
    public boolean eliminarDetallesPedido(int idPedido) {
        String sql = "DELETE FROM pedido_producto WHERE PedidoID = ?";
        
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //agrega un detalle de pedido
    public boolean agregarDetallePedido(int idPedido, DetallePedido detalle) {
        String sql = "INSERT INTO pedido_producto (PedidoID, ProductoID, Cantidad, PrecioVenta) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, idPedido);
            preparedStatement.setInt(2, detalle.getProducto().getId());
            preparedStatement.setInt(3, detalle.getCantidad());
            preparedStatement.setFloat(4, detalle.getPrecioVenta());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    //agrega múltiples detalles del pedido
    public boolean agregarDetallePedido(int idPedido, List<DetallePedido> detalles) {
        boolean resultado = true;
        for (DetallePedido detalle : detalles) {
            if (!agregarDetallePedido(idPedido, detalle)) {
                resultado = false;
            }
        }
        return resultado;
    }
    
}
