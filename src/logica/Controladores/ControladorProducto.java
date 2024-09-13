/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import logica.Clases.Producto;
import logica.Interfaces.IControladorProducto;
import logica.servicios.ProductoServicios;
import java.util.ArrayList;

/**
 *
 * @author UnwantedOpinion
 */
public class ControladorProducto implements IControladorProducto {

    private static ControladorProducto instancia;
    private ProductoServicios productoServicios;

    private ControladorProducto() {
        productoServicios = new ProductoServicios();
    }

    public static ControladorProducto getInstance() {
        if (instancia == null) {
            instancia = new ControladorProducto();
        }
        return instancia;
    }

    @Override
    public boolean altaProducto(Producto producto) {
        return productoServicios.altaProducto(producto);
    }

    @Override
    public boolean modificarProducto(int id, Producto producto) {
        return productoServicios.modificarProducto(id, producto);
    }

    @Override
    public boolean eliminarProducto(int id) {
        return productoServicios.eliminarProducto(id);
    }

    @Override
    public ArrayList<Producto> listarProductos() {
        return productoServicios.listarProductos();
    }

    @Override
    public Producto buscarProducto(int id) {
        return productoServicios.buscarProducto(id);
    }
    
    @Override
    public ArrayList<String> obtenerNombresProductos(){
        return productoServicios.obtenerNombresProductos();
    }
    
    @Override
    public ArrayList<Float> obtenerPreciosProductos(){
        return productoServicios.obtenerPreciosProductos();
    }
    
    @Override
    public Producto buscarProductoPorNombre(String nombreProducto){
        return productoServicios.buscarProductoPorNombre(nombreProducto);
    }
}
