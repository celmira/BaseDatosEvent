package com.example.celmiramedina.drawerlayout_15.Modelo;

/**
 * Created by Celmira Medina on 27/11/2017.
 */

public class Usuario_guia {

    String nombre, genero,correo,descripcionPerfil,foto;
    Integer id,cedula,fechaNacimiento;

    public Usuario_guia(String nombre, String genero, String correo, String descripcionPerfil,
                        String foto, Integer id, Integer cedula, Integer fechaNacimiento) {
        this.nombre = nombre;
        this.genero = genero;
        this.correo = correo;
        this.descripcionPerfil = descripcionPerfil;
        this.foto = foto;
        this.id = id;
        this.cedula = cedula;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcionPerfil() {
        return descripcionPerfil;
    }

    public void setDescripcionPerfil(String descripcionPerfil) {
        this.descripcionPerfil = descripcionPerfil;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
