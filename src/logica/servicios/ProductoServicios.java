/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.servicios;

import Persistencia.ConexionDB;
import logica.Clases.Producto;
import logica.Clases.Categoria;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author UnwantedOpinion
 */
public class ProductoServicios {
    private Connection conexion = new ConexionDB().getConexion();

    public boolean altaProducto(Producto producto) {
        try {
            String sql = "INSERT INTO producto (nombre, descripcion, SKU, stock, precioVenta, CategoriaID) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getSKU());
            ps.setInt(4, producto.getStock());
            ps.setFloat(5, producto.getPrecioVenta());
            ps.setInt(6, producto.getCategoria().getId());

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean modificarProducto(int id, Producto producto) {
        try {
            String sql = "UPDATE producto SET nombre = ?, descripcion = ?, SKU = ?, stock = ?, precioVenta = ?, CategoriaID = ? WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setString(3, producto.getSKU());
            ps.setInt(4, producto.getStock());
            ps.setFloat(5, producto.getPrecioVenta());
            ps.setInt(6, producto.getCategoria().getId());
            ps.setInt(7, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(int id) {
        try {
            String sql = "DELETE FROM producto WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Producto> listarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setSKU(rs.getString("SKU"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecioVenta(rs.getFloat("precioVenta"));
                producto.setCategoria(buscarCategoriaPorId(rs.getInt("CategoriaID")));
                productos.add(producto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }
    
    public Producto buscarProducto(int id) {
        Producto producto = null;
        try {
            String sql = "SELECT * FROM producto WHERE id = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setSKU(rs.getString("SKU"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecioVenta(rs.getFloat("precioVenta"));
                producto.setCategoria(buscarCategoriaPorId(rs.getInt("CategoriaID")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return producto;
    }
    
    // auxiliar para buscar la categoría asociada al producto
    private Categoria buscarCategoriaPorId(int id) {
        CategoriaServicios categoriaServicios = new CategoriaServicios();
        return categoriaServicios.buscarCategoria(id);
    }
    
    //auxiliar para obtener los nombres de los productos
    public ArrayList<String> obtenerNombresProductos() {
        ArrayList<String> nombres = new ArrayList<>();
        try {
            String sql = "SELECT nombre FROM producto";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                nombres.add(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return nombres;
    }
    
    //auxiliar para obtener los precios de los productos
    public ArrayList<Float> obtenerPreciosProductos() {
        ArrayList<Float> precios = new ArrayList<>();
        try {
            String sql = "SELECT precioVenta FROM producto";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                precios.add(rs.getFloat("precioVenta"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return precios;
    }
    
    //auxiliar para buscar producto por nombre
    public Producto buscarProductoPorNombre(String nombreProducto) {
        Producto producto = null;
        try {
            String sql = "SELECT * FROM producto WHERE nombre = ?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreProducto);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setSKU(rs.getString("SKU"));
                producto.setStock(rs.getInt("stock"));
                producto.setPrecioVenta(rs.getFloat("precioVenta"));
                producto.setCategoria(buscarCategoriaPorId(rs.getInt("CategoriaID")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return producto;
}
}
