/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import logica.Controladores.ControladorUsuario;
import logica.Interfaces.IControladorUsuario;


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
        return ControladorU;
    }
    
}
