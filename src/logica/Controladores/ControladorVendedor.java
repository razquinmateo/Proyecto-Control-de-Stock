/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Controladores;

import logica.Clases.Vendedor;
import logica.Interfaces.IControladorVendedor;
import logica.servicios.VendedorServicios;
import java.util.ArrayList;
/**
 *
 * @author UnwantedOpinion
 */
public class ControladorVendedor implements IControladorVendedor  {
    
    private static ControladorVendedor instancia;
    private VendedorServicios vendedorServicios;
    
    private ControladorVendedor() {
        vendedorServicios = new VendedorServicios();
    }

    public static ControladorVendedor getInstance() {
        if (instancia == null) {
            instancia = new ControladorVendedor();
        }
        return instancia;
    }
    
    @Override
    public boolean altaVendedor(Vendedor vendedor) {
        return vendedorServicios.altaVendedor(vendedor);
    }

    @Override
    public boolean modificarVendedor(int id, Vendedor vendedor) {
        return vendedorServicios.modificarVendedor(id, vendedor);
    }

    @Override
    public boolean eliminarVendedor(int id) {
        return vendedorServicios.eliminarVendedor(id);
    }

    @Override
    public ArrayList<Vendedor> listarVendedores() {
        return vendedorServicios.listarVendedores();
    }
    
    @Override
    public Vendedor buscarVendedor(int id) {
        return vendedorServicios.buscarVendedor(id);
    }
    
    @Override
    public int obtenerIdVendedorPorNombre(String nombreVendedor){
        return vendedorServicios.obtenerIdVendedorPorNombre(nombreVendedor);
    }
}