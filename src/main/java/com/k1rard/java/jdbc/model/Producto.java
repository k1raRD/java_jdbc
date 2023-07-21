package com.k1rard.java.jdbc.model;

import java.util.Date;

/**
 * @author K1rard
 * Clase que representa una entidad de Producto en la base de datos
 */
public class Producto {
    private Integer id;
    private String nombre;
    private Integer precio;
    private Date fechaRegistro;
    private Categoria categoria;

    public Producto() {
    }

    public Producto(Integer id, String nombre, Integer precio, Date fechaRegistro, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return   "|"+ id + "|" +
                 nombre + '|' +
                 precio + '|' +
                 fechaRegistro + '|' +
                  categoria.getNombre() + '|';
    }
}
