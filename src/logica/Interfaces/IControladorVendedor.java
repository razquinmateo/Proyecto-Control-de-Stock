/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Interfaces;

import logica.Clases.Vendedor;
import java.util.ArrayList;
import java.util.List;

public interface IControladorVendedor {
    public abstract boolean altaVendedor(Vendedor vendedor);
    public abstract boolean modificarVendedor(int id, Vendedor vendedor);
    public abstract boolean deshabilitarVendedor(int id);
    public abstract ArrayList<Vendedor> listarVendedores();
    public abstract Vendedor buscarVendedor(int id);
    public abstract int obtenerIdVendedorPorNombre(String nombreVendedor);
    public abstract boolean cedulaEnUso(int cedula);
    public abstract boolean vendedorEstaAsociadoAPedido(int id);
    public abstract String obtenerNombreVendedorPorId(int idVendedor); 
    public abstract List<String> obtenerNombresVendedores();
    public abstract List<String> obtenerNombresVendedoresActivos();
    public abstract boolean validarCredenciales(String username, String password);
    public abstract Integer obtenerIdPorUsuario(String nombreUsuario);
    public abstract String getNombreVendedorPorId(int idVendedor);
    public abstract Vendedor obtenerVendedorPorUsuario(String username);
}
