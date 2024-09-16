/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.Interfaces;

import logica.Clases.Producto;
import java.util.ArrayList;

/**
 *
 * @author UnwantedOpinion
 */
public interface IControladorProducto {
    public abstract boolean altaProducto(Producto producto);
    public abstract boolean modificarProducto(int id, Producto producto);
    public abstract boolean eliminarProducto(int id);
    public abstract ArrayList<Producto> listarProductos();
    public abstract Producto buscarProducto(int id);
    public abstract ArrayList<String> obtenerNombresProductos();
    public abstract ArrayList<Float> obtenerPreciosProductos();
    public abstract Producto buscarProductoPorNombre(String nombreProducto);
    public abstract boolean nombreProductoExiste(String nombre);
    public abstract boolean skuProductoExiste(String sku);
    public abstract Producto buscarProductoPorSKU(String sku);
    public abstract boolean productoEnPedidos(int idProducto);
}
