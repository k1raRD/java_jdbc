package com.k1rard.java.jdbc.repository;

import com.k1rard.java.jdbc.model.Categoria;

import java.util.List;

public interface CategoriaRepositorio extends Repositorio<Categoria>{
    Categoria buscarPorIdYPorNombre(Integer id, String nombre);

    List<Categoria> categoriasPorIds(Integer id, Integer id2, Integer id3);
}
