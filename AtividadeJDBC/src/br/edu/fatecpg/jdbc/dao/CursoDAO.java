package br.edu.fatecpg.jdbc.dao;

import br.edu.fatecpg.jdbc.banco.Banco;
import br.edu.fatecpg.jdbc.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {

    public void inserir(Curso curso) {
        var query = "INSERT INTO tb_curso (nome, periodo) VALUES (?, ?)";
        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getPeriodo());
            stmt.execute();
            System.out.println("Curso inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir curso: " + e.getMessage());
        }
    }

    public List<Curso> listar() {
        List<Curso> cursos = new ArrayList<>();
        var query = "SELECT id, nome, periodo FROM tb_curso ORDER BY id";

        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Curso curso = new Curso(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("periodo")
                );
                cursos.add(curso);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar cursos: " + e.getMessage());
        }

        return cursos;
    }

    public void atualizar(Curso curso) {
        var query = "UPDATE tb_curso SET nome = ?, periodo = ? WHERE id = ?";
        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, curso.getNome());
            stmt.setString(2, curso.getPeriodo());
            stmt.setInt(3, curso.getId());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Curso atualizado com sucesso!");
            } else {
                System.out.println("Nenhum curso encontrado com o ID " + curso.getId());
            }

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar curso: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        var query = "DELETE FROM tb_curso WHERE id = ?";
        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Curso deletado com sucesso!");
            } else {
                System.out.println("Nenhum curso encontrado com o ID " + id);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar curso: " + e.getMessage());
        }
    }
}
