package com.k1rard.java.jdbc.repository;

import com.k1rard.java.jdbc.model.Categoria;
import com.k1rard.java.jdbc.util.ConexionBaseDatos;

import javax.xml.stream.events.StartElement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositorioImpl implements CategoriaRepositorio{

    private Connection conexion;

    public CategoriaRepositorioImpl(Connection conexion) throws SQLException {
        this.conexion = ConexionBaseDatos.getConnection();
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias;";

        try(Statement stmt = conexion.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));

                categorias.add(categoria);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return categorias;
    }

    @Override
    public Categoria porId(Integer id) {
        Categoria categoria = new Categoria();

        String sql = "SELECT * FROM categorias WHERE id = " + id + ";";

        try(Statement stmt = conexion.createStatement()){
            ResultSet rs =  stmt.executeQuery(sql);

            if(rs.next()){
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }

        return categoria;
    }

    @Override
    public void guardar(Categoria categoria) {
        String sql = "";

        if(categoria.getId() != null && categoria.getId() > 0){
            sql = "UPDATE categorias SET nombre = ' " + categoria.getNombre() + "' WHERE id = " + categoria.getId() +";";
        }else{
             sql = "INSERT INTO categorias(nombre) VALUES(' " + categoria.getNombre() + "');";
        }

        try {
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            Statement stmt = conexion.createStatement();
            stmt.executeQuery(sql);
            conexion.commit();
        } catch (SQLException e) {
            try {
                conexion.rollback();
                e.printStackTrace(System.err);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    @Override
    public void eliminar(Integer id) {

        String sql = "DELETE FROM categorias WHERE id = " + id +";";

        try {
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            Statement stmt = conexion.createStatement();
            stmt.executeQuery(sql);
            conexion.commit();
        } catch (SQLException e) {
            try {
                conexion.rollback();
                e.printStackTrace(System.err);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    @Override
    public Categoria buscarPorIdYPorNombre(Integer id, String nombre) {
        Categoria categoria = new Categoria();

        String sql = "SELECT *  FROM categorias WHERE id = " + id +" AND nombre = '" + nombre +"';";

        try(Statement stmt = conexion.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            if(rs.next()){
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categoria;
    }

    @Override
    public List<Categoria> categoriasPorIds(Integer id, Integer id2, Integer id3) {
        List<Categoria> categorias = new ArrayList<>();

        String sql = "SELECT * FROM categorias WHERE id IN(" + id + ", " + id2 +", " + id3 +");";

        try(Statement stmt = conexion.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNombre(rs.getString("nombre"));

                categorias.add(categoria);
            }
        } catch (SQLException exception) {

             exception.printStackTrace(System.err);
        }
        return categorias;
    }
}
