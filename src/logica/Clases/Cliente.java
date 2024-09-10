/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.Clases;

import java.util.Date;

/**
 *
 * @author Jairo
 */
public class Cliente {
    private String nom_empresa;
    private String correo_electronico;
    private int num_rut;
    private String telefono;
    private Date fecha_registro;


    public Cliente(String nombre, String email, int rut, String telefono, Date fechaRegistro) {
        this.nom_empresa = nombre;
        this.correo_electronico = email;
        this.num_rut = rut;
        this.telefono = telefono;
        this.fecha_registro = fechaRegistro;
    }

    public Cliente() {
    }

    public String getNom_empresa() {
        return nom_empresa;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public int getNum_rut() {
        return num_rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setNom_empresa(String nom_empresa) {
        this.nom_empresa = nom_empresa;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setNum_rut(int num_rut) {
        this.num_rut = num_rut;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    
    
}