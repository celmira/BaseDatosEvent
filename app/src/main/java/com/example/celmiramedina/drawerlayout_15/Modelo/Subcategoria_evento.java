package com.example.celmiramedina.drawerlayout_15.Modelo;

/**
 * Created by Celmira Medina on 27/11/2017.
 */

public class Subcategoria_evento {

    String nombre;
    Integer id, id_evento;

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

    public Integer getId_evento() {
        return id_evento;
    }

    public void setId_evento(Integer id_evento) {
        this.id_evento = id_evento;
    }

    public Subcategoria_evento(String nombre, Integer id, Integer id_evento) {
        this.nombre = nombre;
        this.id = id;
        this.id_evento = id_evento;
    }
}
