package br.edu.fatecpg.jdbc.dao;

import br.edu.fatecpg.jdbc.banco.Banco;
import br.edu.fatecpg.jdbc.model.StatusTarefa;
import br.edu.fatecpg.jdbc.model.Tarefa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {

    public void inserir(Tarefa tarefa) {
        var query = "INSERT INTO tb_tarefa (titulo, descricao, categoria, status) VALUES (?, ?, ?, ?)";
        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getCategoria());
            stmt.setString(4, tarefa.getStatus().name());
            stmt.execute();
            System.out.println("Tarefa criada com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir tarefa: " + e.getMessage());
        }
    }

    public List<Tarefa> listarTodas() {
        List<Tarefa> tarefas = new ArrayList<>();
        var query = "SELECT id, titulo, descricao, categoria, status FROM tb_tarefa ORDER BY id";

        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                tarefas.add(mapearTarefa(rs));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar tarefas: " + e.getMessage());
        }

        return tarefas;
    }

    public List<Tarefa> listarPorCategoria(String categoria) {
        List<Tarefa> tarefas = new ArrayList<>();
        var query = "SELECT id, titulo, descricao, categoria, status FROM tb_tarefa WHERE categoria = ? ORDER BY id";

        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, categoria);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    tarefas.add(mapearTarefa(rs));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao filtrar tarefas por categoria: " + e.getMessage());
        }

        return tarefas;
    }

    public List<Tarefa> listarPorStatus(StatusTarefa status) {
        List<Tarefa> tarefas = new ArrayList<>();
        var query = "SELECT id, titulo, descricao, categoria, status FROM tb_tarefa WHERE status = ? ORDER BY id";

        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, status.name());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    tarefas.add(mapearTarefa(rs));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao filtrar tarefas por status: " + e.getMessage());
        }

        return tarefas;
    }

    public List<Tarefa> listarPorCategoriaEStatus(String categoria, StatusTarefa status) {
        List<Tarefa> tarefas = new ArrayList<>();
        var query = "SELECT id, titulo, descricao, categoria, status FROM tb_tarefa WHERE categoria = ? AND status = ? ORDER BY id";

        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, categoria);
            stmt.setString(2, status.name());

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    tarefas.add(mapearTarefa(rs));
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao filtrar tarefas: " + e.getMessage());
        }

        return tarefas;
    }

    private Tarefa mapearTarefa(ResultSet rs) throws SQLException {
        return new Tarefa(
                rs.getInt("id"),
                rs.getString("titulo"),
                rs.getString("descricao"),
                rs.getString("categoria"),
                StatusTarefa.valueOf(rs.getString("status"))
        );
    }

    public void editar(Tarefa tarefa) {
        var query = "UPDATE tb_tarefa SET titulo = ?, descricao = ?, categoria = ? WHERE id = ?";
        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getCategoria());
            stmt.setInt(4, tarefa.getId());

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Tarefa atualizada com sucesso!");
            } else {
                System.out.println("Nenhuma tarefa encontrada com o ID " + tarefa.getId());
            }

        } catch (SQLException e) {
            System.err.println("Erro ao editar tarefa: " + e.getMessage());
        }
    }

    public void marcarComoConcluida(int id) {
        var query = "UPDATE tb_tarefa SET status = ? WHERE id = ?";
        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, StatusTarefa.CONCLUIDA.name());
            stmt.setInt(2, id);

            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Tarefa marcada como concluída!");
            } else {
                System.out.println("Nenhuma tarefa encontrada com o ID " + id);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao concluir tarefa: " + e.getMessage());
        }
    }

    public void deletar(int id) {
        var query = "DELETE FROM tb_tarefa WHERE id = ?";
        try (Connection connection = Banco.connect();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Tarefa deletada com sucesso!");
            } else {
                System.out.println("Nenhuma tarefa encontrada com o ID " + id);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao deletar tarefa: " + e.getMessage());
        }
    }
}
