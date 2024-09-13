/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

import java.util.Date;

public class Pedido {
    
    public enum Estado {
        EN_PREPARACION, EN_VIAJE, ENTREGADO, CANCELADO
    }
    
    private int identificador;
    private Date fechaPedido;
    private Estado estado;
    private float total;
    private int idVendedor;
    private int idCliente;

    // Constructor
    public Pedido(int identificador, Date fechaPedido, Estado estado, float total, int idVendedor, int idCliente) {
        this.identificador = identificador;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.total = total;
        this.idVendedor = idVendedor;
        this.idCliente = idCliente;
    }

    // Getters y Setters

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
