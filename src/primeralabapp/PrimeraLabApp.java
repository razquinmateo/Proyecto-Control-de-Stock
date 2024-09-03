package primeralabapp;

import logica.Clases.Vendedor;
import logica.Controladores.ControladorVendedor;

import java.util.ArrayList;
import java.util.Date;

public class PrimeraLabApp {

    public static void main(String[] args) {
        // Obtener la instancia del controlador de vendedores
        ControladorVendedor controlador = ControladorVendedor.getInstance();
        
        // Crear y configurar un nuevo vendedor
        Vendedor nuevoVendedor1 = new Vendedor();
        nuevoVendedor1.setNombre("Ceciley Ugoni");
        nuevoVendedor1.setCedula(51202150);
        nuevoVendedor1.setCorreo("cugoni0@yelp.com");
        nuevoVendedor1.setDireccion("038 Farwell Way");
        nuevoVendedor1.setFechaContratacion(new Date());

        // Alta del nuevo vendedor y mostrar el resultado
        boolean altaExitosa1 = controlador.altaVendedor(nuevoVendedor1);
        System.out.println("Alta de vendedor 1 exitosa: " + altaExitosa1);
    }
}
