package com.example.celmiramedina.drawerlayout_15.Modelo;

/**
 * Created by Celmira Medina on 19/11/2017.
 */

public class Evento {
    String nombre, descripcion, puntoEncuentro;
    Integer id, subcategoria, fechaInicio, fechaFin, precio,guia;

    public Evento(String nombre, String descripcion, String puntoEncuentro,
                  Integer id, Integer subcategoria, Integer fechaInicio,
                  Integer fechaFin, Integer precio, Integer guia)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntoEncuentro = puntoEncuentro;
        this.id = id;
        this.subcategoria = subcategoria;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precio = precio;
        this.guia = guia;
    }



    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPuntoEncuentro() {
        return puntoEncuentro;
    }

    public void setPuntoEncuentro(String puntoEncuentro) {
        this.puntoEncuentro = puntoEncuentro;
    }

    public Integer getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Integer subcategoria) {
        this.subcategoria = subcategoria;
    }

    public Integer getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Integer fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Integer fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGuia() {
        return guia;
    }

    public void setGuia(Integer guia) {
        this.guia = guia;
    }
}
