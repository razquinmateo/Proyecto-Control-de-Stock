/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

/**
 *
 * @author LucasCiceri
 */
public class Usuario {

    private String nombre;
    private String apellido;
    private String password;

    private String email;
    
    public Usuario() {
    }
    
    public Usuario(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
    }

    public Usuario(String email, String nombre, String apellido, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.email = email;
    }

    public Usuario(String string, String string0, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
