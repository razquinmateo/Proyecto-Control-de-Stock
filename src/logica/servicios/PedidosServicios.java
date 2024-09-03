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
import logica.Clases.Pedido;

/**
 *
 * @author Mateo
 */
public class PedidosServicios {
    
    private Connection conexion = new ConexionDB().getConexion();
    
    public Pedido getPedidoById(int idPedido) throws SQLException {
        String sql = "SELECT * FROM pedidos WHERE idPedido = ?";
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setInt(1, idPedido);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String identificador = resultSet.getString("identificador");
            String fechaPedido = resultSet.getString("fecha_pedido");
            String estado = resultSet.getString("estado");
            float total = resultSet.getFloat("total");
            int idVendedor = resultSet.getInt("id_vendedor");

            return new Pedido(idPedido, identificador, fechaPedido, estado, total, idVendedor);
        }

        return null;
    }
    
    public ArrayList<Pedido> getPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM pedidos";
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int idPedido = resultSet.getInt("id_pedido");
                String identificador = resultSet.getString("identificador");
                String fechaPedido = resultSet.getString("fecha_pedido");
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
    
}
