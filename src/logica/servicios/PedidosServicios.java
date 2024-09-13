/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import logica.Clases.Pedido;
import logica.Clases.Pedido.Estado;

/**
 *
 * @author Mateo
 */
public class PedidosServicios {

    private Connection conexion = new ConexionDB().getConexion();
    private DetallePedidoServicios detallePedidoServicios = new DetallePedidoServicios();
    
    //obtiene todos los datos de los pedidos y los devuelve en un ArrayList
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

                Pedido pedido = new Pedido(identificador, fechaPedido, estado, total, idVendedor, idCliente);
                pedidos.add(pedido);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    //obtiene el nombre de la tabla vendedor con el id del pedido, para mostrar el nombre del vendedor en lugar del id
    public String getNombreVendedorPorId(int idVendedor) throws SQLException {
        String sql = "SELECT nombre FROM vendedor WHERE id = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idVendedor);

        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString("nombre");
        }
        return null;
    }

    public String getNombreClientePorId(int idCliente) throws SQLException {
        String sql = "SELECT Nom_Empresa FROM cliente WHERE ID = ?";
        PreparedStatement ps = conexion.prepareStatement(sql);
        ps.setInt(1, idCliente);

        ResultSet resultSet = ps.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString("Nom_Empresa");
        }
        return null;
    }

    public boolean eliminarPedido(int idPedido) {
        boolean resultado = detallePedidoServicios.eliminarDetallesPedido(idPedido);
        if (resultado) {
            String sql = "DELETE FROM pedido WHERE Identificador = ?";
            try (PreparedStatement ps = conexion.prepareStatement(sql)) {
                ps.setInt(1, idPedido);
                int rowsAffected = ps.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public boolean actualizarPedido(int idPedido, Estado estado, float total) {
        String sql = "UPDATE pedido SET estado = ?, total = ? WHERE Identificador = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, estado.name());
            ps.setFloat(2, total);
            ps.setInt(3, idPedido);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean agregarPedido(Pedido pedido) {
        String sqlPedido = "INSERT INTO pedido (FechaPedido, Estado, Total, VendedorID, ClienteID) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmtPedido = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
            stmtPedido.setTimestamp(1, new java.sql.Timestamp(pedido.getFechaPedido().getTime()));
            stmtPedido.setString(2, pedido.getEstado().name());
            stmtPedido.setFloat(3, pedido.getTotal());
            stmtPedido.setInt(4, pedido.getIdVendedor());
            stmtPedido.setInt(5, pedido.getIdCliente());
            int rowsAffected = stmtPedido.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmtPedido.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int pedidoID = generatedKeys.getInt(1);
                    pedido.setIdentificador(pedidoID);
                    
                    //inserta los detalles del pedido asociados
                    return detallePedidoServicios.agregarDetallePedido(pedidoID, pedido.getDetallesPedidos());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public List<String> obtenerNombresVendedores() {
        List<String> nombres = new ArrayList<>();
        try{
            String sql = "SELECT nombre FROM vendedor";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

           while (rs.next()) {
               nombres.add(rs.getString("nombre"));
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return nombres;
    }

    public List<String> obtenerNombresClientes() {
        List<String> nombres = new ArrayList<>();
        try{
            String sql = "SELECT nom_empresa FROM cliente";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

           while (rs.next()) {
            nombres.add(rs.getString("nom_empresa"));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nombres;
    }

}
