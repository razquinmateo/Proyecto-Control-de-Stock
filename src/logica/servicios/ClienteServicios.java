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
import java.util.List;
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
                String identificador = rs.getString("identificador");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                Date fechaRegistro = rs.getDate("fecha_registro");
                Boolean activo = rs.getBoolean("Activo");
                
                Cliente cliente = new Cliente(nombre, email, identificador, telefono, direccion, fechaRegistro, activo);
                resultado.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
        
        public boolean agregarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nom_empresa, correo_electronico, identificador, telefono, direccion, fecha_registro) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, cliente.getNom_empresa());
            stmt.setString(2, cliente.getCorreo_electronico());
            stmt.setString(3, cliente.getIdentificador());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.setTimestamp(6, new java.sql.Timestamp(cliente.getFecha_registro().getTime()));

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
        
    public boolean existeIdentificador(String identificador) {
    String sql = "SELECT COUNT(*) FROM cliente WHERE identificador = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, identificador);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deshabilitarCliente(String identificador) {
    String sql = "UPDATE cliente SET activo = 0 WHERE identificador = ?";

    try {
        PreparedStatement stmt = conexion.prepareStatement(sql);
        stmt.setString(1, identificador);

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    }
}

// Método para obtener un cliente por su identificador
    public Cliente getClientePorIdentificador(String identificador) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE identificador = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, identificador);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nom_empresa");
                String email = rs.getString("correo_electronico");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                Date fechaRegistro = rs.getDate("fecha_registro");

                // Crear el objeto Cliente con los datos obtenidos
                cliente = new Cliente(nombre, email, identificador, telefono, direccion, fechaRegistro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cliente;
    }
    
    // Método para actualizar los datos de un cliente
    public boolean actualizarCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nom_empresa = ?, correo_electronico = ?, telefono = ?, direccion = ? WHERE identificador = ?";
        try {
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, cliente.getNom_empresa());
            stmt.setString(2, cliente.getCorreo_electronico());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getIdentificador());

            int filasActualizadas = stmt.executeUpdate();
            return filasActualizadas > 0;  // Devuelve true si se actualizaron filas
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public int obtenerIdClientePorNombre(String nombreCliente) {
        String sql = "SELECT ID FROM cliente WHERE Nom_Empresa = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombreCliente);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("ID");
                } else {
                    throw new SQLException("No se encontró un cliente con el nombre: " + nombreCliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public boolean existeNombreCliente(String nombre) {
        String sql = "SELECT COUNT(*) FROM cliente WHERE nom_empresa = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public String getNombreClientePorId(int idCliente) {
        String nombre = null;
        String sql = "SELECT Nom_Empresa FROM cliente WHERE ID = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idCliente);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                nombre = resultSet.getString("Nom_Empresa");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener el nombre del cliente: " + e.getMessage());
        }

        return nombre;
    }
    
    public List<String> obtenerNombresClientes() {
        List<String> nombres = new ArrayList<>();
        try {
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
    
    public List<String> obtenerNombresClientesActivos() {
        List<String> nombres = new ArrayList<>();
        try {
            String sql = "SELECT nom_empresa FROM cliente WHERE Activo = 1";
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
    
    public ArrayList<Cliente> getClientesActivos() {
        ArrayList<Cliente> resultado = new ArrayList<Cliente>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM cliente WHERE Activo = 1");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                // Leer los datos del ResultSet y crear un objeto Cliente
                String nombre = rs.getString("nom_empresa");
                String email = rs.getString("correo_electronico");
                String identificador = rs.getString("identificador");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                Date fechaRegistro = rs.getDate("fecha_registro");
                Boolean activo = rs.getBoolean("Activo");
                
                Cliente cliente = new Cliente(nombre, email, identificador, telefono, direccion, fechaRegistro, activo);
                resultado.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public int obtenerIdPorNombre(String nombreCliente) {
        String sql = "SELECT ID FROM cliente WHERE nom_empresa = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            // Asegúrate de que el nombreCliente está correctamente limpiado y sin espacios
            ps.setString(1, nombreCliente.trim()); // Usa trim() para limpiar espacios

            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("ID");
                } else {
                    throw new SQLException("No se encontró un cliente con el nombre: " + nombreCliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Retorna -1 en caso de error
        }
    }


}
