/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.Controladores.ControladorUsuario;
import logica.Interfaces.IControladorUsuario;
import logica.Controladores.ControladorPedido;
import logica.Interfaces.IControladorPedido;
import logica.Controladores.ControladorVendedor;
import logica.Interfaces.IControladorVendedor;

/**
 *
 * @author Santiago.S
 */
public class Fabrica {

    private static Fabrica instancia;
    
    private Fabrica() {
    }
    
    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IControladorUsuario getIControladorUsuario() {
        IControladorUsuario ControladorU = ControladorUsuario.getInstance();
        return ControladorU; //To change body of generated methods, choose Tools | Templates.
    }

    public IControladorPedido getIControladorPedido() {
        IControladorPedido ControladorP = ControladorPedido.getInstance();
        return ControladorP; 
    }
     
    public IControladorVendedor getIControladorVendedor() {
        return ControladorVendedor.getInstance();
    }

}
