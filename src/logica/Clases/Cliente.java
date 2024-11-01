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
    private String identificador;
    private String telefono;
    private String direccion;
    private Date fecha_registro;
    private Boolean activo;


    public Cliente(String nombre, String email, String rut, String telefono, String direccion, Date fechaRegistro, Boolean activo) {
        this.nom_empresa = nombre;
        this.correo_electronico = email;
        this.identificador = rut;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_registro = fechaRegistro;
        this.activo = activo;
    }
    
    public Cliente(String nombre, String email, String rut, String telefono, String direccion, Date fechaRegistro) {
        this.nom_empresa = nombre;
        this.correo_electronico = email;
        this.identificador = rut;
        this.telefono = telefono;
        this.direccion = direccion;
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

    public String getIdentificador() {
        return identificador;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}
