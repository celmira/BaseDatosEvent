package com.example.celmiramedina.drawerlayout_15.Modelo;

import java.util.Date;

/**
 * Created by Celmira Medina on 04/11/2017.
 */

public class Usuario_asistente {
    String name, genero,correo,intereses,foto,eps;
    //Date fechaNacimiento;
    Integer id,cedula,fechaNacimiento;

    public Usuario_asistente(String name, Integer fechaNacimiento, Integer cedula, String eps, Integer id, String correo, String genero, String intereses, String foto) {
        this.name = name;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.eps = eps;
        this.id = id;
        this.correo = correo;
        this.genero = genero;
        this.intereses = intereses;
        this.foto = foto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append("Nombre: ").append(this.name).append("  Fecha de nacimiento: ").append(this.fechaNacimiento).append("  Genero: ").append(this.genero).append("  Correo Electrónico: ").append(this.correo).append("  Eps: ").append(this.eps).append("  Intereses: ").append(this.intereses).append(" Imagen:").append(this.foto).toString();
    }
}
