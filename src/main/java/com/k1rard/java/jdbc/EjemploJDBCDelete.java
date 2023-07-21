package com.k1rard.java.jdbc;

import com.k1rard.java.jdbc.model.Producto;
import com.k1rard.java.jdbc.repository.ProductoRepositorioImpl;
import com.k1rard.java.jdbc.repository.Repositorio;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import java.sql.Connection;
import java.sql.SQLException;

public class EjemploJDBCDelete {
    public static void main(String[] args) {

        try ( Connection conn = ConexionBaseDatos.getConnection();) {
            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("================= Listar =================");
            repositorio.listar().forEach(System.out::println);

            System.out.println("================= Obtener por id =================");
            System.out.println(repositorio.porId(2));

            System.out.println("================= Eliminar nuevo producto =================");
            Producto producto = new Producto();
            producto.setId(3);
            repositorio.eliminar(producto.getId());
            System.out.println("Producto eliminado con exito");
            repositorio.listar().forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }


    }
}
