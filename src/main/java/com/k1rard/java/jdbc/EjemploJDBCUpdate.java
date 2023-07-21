package com.k1rard.java.jdbc;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.model.Producto;
import com.k1rard.java.jdbc.repository.ProductoRepositorioImpl;
import com.k1rard.java.jdbc.repository.Repositorio;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBCUpdate {
    public static void main(String[] args) {

        try ( Connection conn = ConexionBaseDatos.getConnection();) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("================= Listar =================");
            repositorio.listar().forEach(System.out::println);

            System.out.println("================= Obtener por id =================");
            System.out.println(repositorio.porId(2));

            System.out.println("================= Editar nuevo producto =================");
            Producto producto = new Producto();
            producto.setId(4);
            producto.setNombre("Teclado corsair mecanico");
            producto.setPrecio(700);
            Categoria categoria = new Categoria();
            categoria.setId(3);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto actualizado con exito");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }


    }
}
