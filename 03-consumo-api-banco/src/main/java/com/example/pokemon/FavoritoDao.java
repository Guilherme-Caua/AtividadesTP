package com.example.pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Acesso ao banco (JDBC puro) para a tabela de favoritos.
 */
public class FavoritoDao {

    /** Cadastra o favorito. Retorna false se o usuário já o tinha favoritado. */
    public boolean inserir(String usuario, Pokemon p) throws SQLException {
        if (buscar(usuario, p.getNome()).isPresent()) {
            return false;
        }
        String sql = """
                INSERT INTO favorito
                    (usuario, pokemon_id, nome, altura, peso, tipos, habilidades, experiencia_base)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try (Connection conn = Database.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setInt(2, p.getId());
            ps.setString(3, p.getNome());
            ps.setInt(4, p.getAltura());
            ps.setInt(5, p.getPeso());
            ps.setString(6, p.getTipos());
            ps.setString(7, p.getHabilidades());
            ps.setInt(8, p.getExperienciaBase());
            ps.executeUpdate();
        }
        return true;
    }

    public List<Pokemon> listar(String usuario) throws SQLException {
        String sql = "SELECT * FROM favorito WHERE usuario = ? ORDER BY nome";
        List<Pokemon> lista = new ArrayList<>();
        try (Connection conn = Database.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(mapear(rs));
                }
            }
        }
        return lista;
    }

    public Optional<Pokemon> buscar(String usuario, String nome) throws SQLException {
        String sql = "SELECT * FROM favorito WHERE usuario = ? AND LOWER(nome) = LOWER(?)";
        try (Connection conn = Database.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, nome.trim());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(mapear(rs)) : Optional.empty();
            }
        }
    }

    /** Exclui o favorito pelo nome. Retorna true se algo foi removido. */
    public boolean excluir(String usuario, String nome) throws SQLException {
        String sql = "DELETE FROM favorito WHERE usuario = ? AND LOWER(nome) = LOWER(?)";
        try (Connection conn = Database.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, nome.trim());
            return ps.executeUpdate() > 0;
        }
    }

    private Pokemon mapear(ResultSet rs) throws SQLException {
        return new Pokemon(
                rs.getInt("pokemon_id"),
                rs.getString("nome"),
                rs.getInt("altura"),
                rs.getInt("peso"),
                rs.getString("tipos"),
                rs.getString("habilidades"),
                rs.getInt("experiencia_base"));
    }
}
