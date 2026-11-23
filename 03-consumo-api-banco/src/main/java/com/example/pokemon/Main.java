package com.example.pokemon;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Atividade 03 - Consumo de API + Banco.
 *
 * a) Visualizar todos os pokémons disponíveis
 * b) Cadastrar no banco (JDBC) os favoritos do usuário
 * c) Exibir 3 informações complementares do Pokémon favorito
 * d) Excluir cadastrados
 */
public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final PokeApiClient api = new PokeApiClient();
    private static final FavoritoDao dao = new FavoritoDao();

    public static void main(String[] args) {
        try {
            Database.criarTabelas();
        } catch (SQLException e) {
            System.out.println("Não foi possível preparar o banco de dados: " + e.getMessage());
            return;
        }

        System.out.print("Digite seu nome de usuário: ");
        String usuario = scanner.nextLine().trim();
        if (usuario.isEmpty()) {
            usuario = "visitante";
        }
        System.out.println("Olá, " + usuario + "!");

        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            try {
                switch (opcao) {
                    case 1 -> visualizarTodos();
                    case 2 -> cadastrarFavorito(usuario);
                    case 3 -> listarFavoritos(usuario);
                    case 4 -> exibirInformacoes(usuario);
                    case 5 -> excluirFavorito(usuario);
                    case 0 -> System.out.println("Até logo!");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (IOException | SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Operação interrompida.");
                return;
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("===== POKÉMONS FAVORITOS =====");
        System.out.println("1 - Visualizar todos os pokémons disponíveis");
        System.out.println("2 - Cadastrar um favorito");
        System.out.println("3 - Listar meus favoritos");
        System.out.println("4 - Exibir informações de um favorito");
        System.out.println("5 - Excluir um favorito");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private static int lerOpcao() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // a) Visualizar todos
    private static void visualizarTodos() throws IOException, InterruptedException {
        List<String> nomes = api.listarTodos();
        System.out.println("\nPokémons disponíveis (" + nomes.size() + "):");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.printf("%4d - %s%n", i + 1, nomes.get(i));
        }
    }

    // b) Cadastrar favorito no banco
    private static void cadastrarFavorito(String usuario)
            throws IOException, InterruptedException, SQLException {
        System.out.print("Nome ou número do pokémon: ");
        String busca = scanner.nextLine();
        if (busca.isBlank()) {
            System.out.println("Informe um nome ou número.");
            return;
        }

        Optional<Pokemon> pokemon = api.buscar(busca);
        if (pokemon.isEmpty()) {
            System.out.println("Pokémon não encontrado na API.");
            return;
        }

        Pokemon p = pokemon.get();
        if (dao.inserir(usuario, p)) {
            System.out.println(p.getNome() + " foi adicionado aos seus favoritos!");
        } else {
            System.out.println(p.getNome() + " já está nos seus favoritos.");
        }
    }

    private static void listarFavoritos(String usuario) throws SQLException {
        List<Pokemon> favoritos = dao.listar(usuario);
        if (favoritos.isEmpty()) {
            System.out.println("Você ainda não tem favoritos.");
            return;
        }
        System.out.println("\nSeus favoritos:");
        favoritos.forEach(p -> System.out.println(" - " + p));
    }

    // c) 3 informações complementares: altura, peso e tipos
    private static void exibirInformacoes(String usuario) throws SQLException {
        System.out.print("Nome do favorito: ");
        Optional<Pokemon> favorito = dao.buscar(usuario, scanner.nextLine());

        if (favorito.isEmpty()) {
            System.out.println("Esse pokémon não está nos seus favoritos.");
            return;
        }

        Pokemon p = favorito.get();
        System.out.println("\n" + p);
        // A API entrega altura em decímetros e peso em hectogramas.
        System.out.printf("Altura: %.1f m%n", p.getAltura() / 10.0);
        System.out.printf("Peso:   %.1f kg%n", p.getPeso() / 10.0);
        System.out.println("Tipos:  " + p.getTipos());
    }

    // d) Excluir
    private static void excluirFavorito(String usuario) throws SQLException {
        System.out.print("Nome do favorito a excluir: ");
        if (dao.excluir(usuario, scanner.nextLine())) {
            System.out.println("Favorito excluído.");
        } else {
            System.out.println("Esse pokémon não está nos seus favoritos.");
        }
    }
}
