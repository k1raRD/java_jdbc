package com.k1rard.java.jdbc;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.repository.CategoriaRepositorio;
import com.k1rard.java.jdbc.repository.CategoriaRepositorioImpl;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import java.sql.SQLException;
import java.util.List;

public class EjemploCategorias {
    public static void main(String[] args) throws SQLException {

        CategoriaRepositorio repositorio = new CategoriaRepositorioImpl(ConexionBaseDatos.getConnection());

        List<Categoria> todasCategorias = repositorio.listar();

        todasCategorias.forEach(System.out::println);

        for(Categoria c : todasCategorias){
            System.out.println(c);
        }
    }
}
