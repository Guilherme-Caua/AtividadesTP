package com.example.pokemon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Conexão JDBC com o banco H2 (arquivo local em ./data/pokemon.mv.db).
 * O arquivo é criado automaticamente na primeira execução.
 */
public class Database {

    private static final String URL = "jdbc:h2:./data/pokemon;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /** Cria a tabela de favoritos, se ainda não existir. */
    public static void criarTabelas() throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS favorito (
                    id               INT AUTO_INCREMENT PRIMARY KEY,
                    usuario          VARCHAR(60)  NOT NULL,
                    pokemon_id       INT          NOT NULL,
                    nome             VARCHAR(80)  NOT NULL,
                    altura           INT          NOT NULL,
                    peso             INT          NOT NULL,
                    tipos            VARCHAR(120) NOT NULL,
                    habilidades      VARCHAR(255) NOT NULL,
                    experiencia_base INT          NOT NULL,
                    CONSTRAINT uk_usuario_pokemon UNIQUE (usuario, pokemon_id)
                )
                """;
        try (Connection conn = conectar(); Statement st = conn.createStatement()) {
            st.execute(sql);
        }
    }
}
