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
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logica.Clases.Cliente;

/**
 *
 * @author Jairo
 */
public class ClienteServicios {
    private Connection conexion = new ConexionDB().getConexion();
    
        public ArrayList<Cliente> getClientes() {
        ArrayList<Cliente> resultado = new ArrayList<Cliente>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                // Leer los datos del ResultSet y crear un objeto Cliente
                String nombre = rs.getString("nom_empresa");
                String email = rs.getString("correo_electronico");
                int rut = rs.getInt("num_rut");
                String telefono = rs.getString("telefono");
                Date fechaRegistro = rs.getDate("fecha_registro"); // Asumiendo que el campo en la DB es 'fecha_registro'
                
                Cliente cliente = new Cliente(nombre, email, rut, telefono, fechaRegistro);
                resultado.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
        
        public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nom_empresa, correo_electronico, num_rut, telefono, fecha_registro) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, cliente.getNom_empresa());
            stmt.setString(2, cliente.getCorreo_electronico());
            stmt.setInt(3, cliente.getNum_rut());
            stmt.setString(4, cliente.getTelefono());
            stmt.setTimestamp(5, new java.sql.Timestamp(cliente.getFecha_registro().getTime()));

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
        
    public boolean existeRut(int rut) {
    String sql = "SELECT COUNT(*) FROM cliente WHERE num_rut = ?";
    try {
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, rut);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return false;
}
    
    public boolean eliminarCliente(int rut) {
    String sql = "DELETE FROM cliente WHERE num_rut = ?";
    
    try {
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setInt(1, rut);
        
        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}

// Método para obtener un cliente por su RUT
    public Cliente getClientePorRut(int rut) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE num_rut = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, rut);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nom_empresa");
                String email = rs.getString("correo_electronico");
                String telefono = rs.getString("telefono");
                Date fechaRegistro = rs.getDate("fecha_registro");

                // Crear el objeto Cliente con los datos obtenidos
                cliente = new Cliente(nombre, email, rut, telefono, fechaRegistro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cliente;
    }
    
    // Método para actualizar los datos de un cliente
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nom_empresa = ?, correo_electronico = ?, telefono = ? WHERE num_rut = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, cliente.getNom_empresa());
            stmt.setString(2, cliente.getCorreo_electronico());
            stmt.setString(3, cliente.getTelefono());
            stmt.setInt(4, cliente.getNum_rut());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;  // Devuelve true si se actualizaron filas
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
       
      
    
}
