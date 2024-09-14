/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Interfaces;

import logica.Clases.Vendedor;
import java.util.ArrayList;

public interface IControladorVendedor {
    public abstract boolean altaVendedor(Vendedor vendedor);
    public abstract boolean modificarVendedor(int id, Vendedor vendedor);
    public abstract boolean eliminarVendedor(int id);
    public abstract ArrayList<Vendedor> listarVendedores();
    public abstract Vendedor buscarVendedor(int id);
    public abstract int obtenerIdVendedorPorNombre(String nombreVendedor);
}
