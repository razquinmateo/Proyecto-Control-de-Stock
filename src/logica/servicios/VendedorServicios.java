/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import logica.Clases.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;

/**
 *
 * @author UnwantedOpinion
 */
public class VendedorServicios {

    private Connection conexion = new ConexionDB().getConexion();

    public boolean altaVendedor(Vendedor vendedor) {
        try {
            //consulta SQL para insertar el nuevo vendedor a la bd
            String sql = "INSERT INTO vendedor (nombre, cedula, correo_electronico, telefono, direccion, fecha_contratacion) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, vendedor.getNombre());
            ps.setInt(2, vendedor.getCedula());
            ps.setString(3, vendedor.getCorreo());
            ps.setString(4, vendedor.getTelefono());
            ps.setString(5, vendedor.getDireccion());
            ps.setTimestamp(6, new java.sql.Timestamp(vendedor.getFechaContratacion().getTime()));

            //ejecuta la consulta y retorna true si se inserta correctament
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean modificarVendedor(int id, Vendedor vendedor) {
        try {
            //consulta SQL para actualizar los datos del vendedor
            String sql = "UPDATE vendedor SET nombre = ?, correo_electronico = ?, telefono = ?, direccion = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, vendedor.getNombre());
            ps.setString(2, vendedor.getCorreo());
            ps.setString(3, vendedor.getTelefono());
            ps.setString(4, vendedor.getDireccion());
            ps.setInt(5, id);

            //ejecuta la consulta y retorna true si se actualiza correctamente
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarVendedor(int id) {
        try {
            //consulta SQL para eliminar un vendedor por su ID
            String sql = "DELETE FROM vendedor WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            //ejeucta la consulta y retornar true si se elimina correctamente
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Vendedor> listarVendedores() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        try {
            //consulta SQL para obtener todos los vendedores
            String sql = "SELECT id, nombre, cedula, correo_electronico, telefono, direccion, fecha_contratacion FROM vendedor";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //recorre el ResultSet y crea objetos Vendedor para cada registro
            while(rs.next()) {
                Vendedor vendedor = new Vendedor();
                vendedor.setId(rs.getInt("id"));
                vendedor.setNombre(rs.getString("nombre"));
                vendedor.setCedula(rs.getInt("cedula"));
                vendedor.setCorreo(rs.getString("correo_electronico"));
                vendedor.setTelefono(rs.getString("telefono"));
                vendedor.setDireccion(rs.getString("direccion"));
                Timestamp fechaContratacion = rs.getTimestamp("fecha_contratacion");
                vendedor.setFechaContratacion(new java.util.Date(fechaContratacion.getTime()));
                vendedores.add(vendedor);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vendedores;
    }
    
    public Vendedor buscarVendedor(int id) {
        Vendedor vendedor = null;
        try {
            String sql = "SELECT * FROM vendedor WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                vendedor = new Vendedor();
                vendedor.setId(rs.getInt("id"));
                vendedor.setNombre(rs.getString("nombre"));
                vendedor.setCedula(rs.getInt("cedula"));
                vendedor.setCorreo(rs.getString("correo_electronico"));
                vendedor.setTelefono(rs.getString("telefono"));
                vendedor.setDireccion(rs.getString("direccion"));
                Timestamp fechaContratacion = rs.getTimestamp("fecha_contratacion");
                vendedor.setFechaContratacion(new java.util.Date(fechaContratacion.getTime()));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vendedor;
    }
}
