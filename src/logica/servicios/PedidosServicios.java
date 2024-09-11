/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import logica.Clases.Pedido;

/**
 *
 * @author Mateo
 */
public class PedidosServicios {

    private Connection conexion = new ConexionDB().getConexion();

    //Obtiene todos los datos de los pedidos y los devuelve en un ArrayList
    public ArrayList<Pedido> getPedidos() {

        ArrayList<Pedido> pedidos = new ArrayList<>();

        try {

            String sql = "SELECT * FROM pedido";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int idPedido = resultSet.getInt("id_pedido");
                String identificador = resultSet.getString("identificador");
                Date fechaPedido = resultSet.getDate("fecha_pedido");
                String estado = resultSet.getString("estado");
                float total = resultSet.getFloat("total");
                int idVendedor = resultSet.getInt("id_vendedor");

                Pedido pedido = new Pedido(idPedido, identificador, fechaPedido, estado, total, idVendedor);
                pedidos.add(pedido);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pedidos;
    }

    //Obtiene el nombre de la tabla vendedor con el id del pedido, para mostrar el nombre del vendedor en lugar del id
    public String getNombreVendedorById(int idVendedor) throws SQLException {

        String sql = "SELECT nombre FROM vendedor WHERE id = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setInt(1, idVendedor);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString("nombre");
        }

        return null;
    }

    public void eliminarPedido(int idPedido) {
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, idPedido);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPedido(int idPedido, String estado, float total, Date fechaPedido) throws SQLException {
        String sql = "UPDATE pedido SET estado = ?, total = ?, fecha_pedido = ? WHERE id_pedido = ?";
        
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            
            preparedStatement.setString(1, estado);
            preparedStatement.setFloat(2, total);
            preparedStatement.setDate(3, new java.sql.Date(fechaPedido.getTime())); 
            preparedStatement.setInt(4, idPedido);
            preparedStatement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al actualizar el pedido.");
        }
    }

}
