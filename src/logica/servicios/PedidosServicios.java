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
import logica.Clases.Pedido.Estado;

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

            String sql = "SELECT p.Identificador, p.FechaPedido, p.Estado, p.Total, "
                    + "p.VendedorID, p.ClienteID, c.Nom_Empresa as nombre_cliente, "
                    + "v.Nombre as nombre_vendedor, v.Cedula as cedula_vendedor, v.Telefono as telefono_vendedor "
                    + "FROM pedido p "
                    + "JOIN cliente c ON p.ClienteID = c.ID "
                    + "JOIN vendedor v ON p.VendedorID = v.ID";

            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                int identificador = resultSet.getInt("Identificador");
                Date fechaPedido = resultSet.getDate("FechaPedido");
                String estadoStr = resultSet.getString("Estado");
                Estado estado = Estado.valueOf(estadoStr); 
                float total = resultSet.getFloat("Total");
                int idVendedor = resultSet.getInt("VendedorID");
                int idCliente = resultSet.getInt("ClienteID");
                String nombreVendedor = resultSet.getString("nombre_vendedor");
                String nombreCliente = resultSet.getString("nombre_cliente");

                Pedido pedido = new Pedido(identificador, fechaPedido, estado, total, idVendedor, idCliente);
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

    public String getNombreClienteById(int idCliente) throws SQLException {
        String sql = "SELECT Nom_Empresa FROM cliente WHERE ID = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setInt(1, idCliente);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString("Nom_Empresa");
        }

        return null; // Si no se encuentra el cliente
    }

    public void eliminarPedido(int idPedido) {
        String sql = "DELETE FROM pedido WHERE Identificador = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, idPedido);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPedido(int idPedido, String estado, float total) throws SQLException {
        String sql = "UPDATE pedido SET estado = ?, total = ? WHERE Identificador = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setInt(1, idPedido);
            preparedStatement.setString(2, estado);
            preparedStatement.setFloat(3, total);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al actualizar el pedido.");
        }
    }

    public void agregarPedido(Pedido pedido) {
 
        String sql = "INSERT INTO pedido (FechaPedido, Estado, Total, VendedorID, ClienteID) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {

            preparedStatement.setDate(1, new java.sql.Date(pedido.getFechaPedido().getTime()));
            preparedStatement.setString(2, pedido.getEstado().name());
            preparedStatement.setFloat(3, pedido.getTotal());
            preparedStatement.setInt(4, pedido.getIdVendedor());
            preparedStatement.setInt(5, pedido.getIdCliente());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
