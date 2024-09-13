/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

/**
 *
 * @author UnwantedOpinion
 */
public class DetallePedido {
    private int cantidad;
    private float precioVenta;
    private Producto producto;
    private Pedido pedido;
    
    public DetallePedido(int cantidad, float precioVenta, Producto producto, Pedido pedido) {
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.producto = producto;
        this.pedido = pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public float subTotal() {
        return cantidad * precioVenta;
    }
}
