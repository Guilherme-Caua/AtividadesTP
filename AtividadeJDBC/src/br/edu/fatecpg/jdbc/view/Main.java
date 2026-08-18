package br.edu.fatecpg.jdbc.view;

import br.edu.fatecpg.jdbc.dao.CursoDAO;
import br.edu.fatecpg.jdbc.dao.TarefaDAO;
import br.edu.fatecpg.jdbc.model.Curso;
import br.edu.fatecpg.jdbc.model.StatusTarefa;
import br.edu.fatecpg.jdbc.model.Tarefa;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static CursoDAO cursoDAO = new CursoDAO();
    static TarefaDAO tarefaDAO = new TarefaDAO();

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenuPrincipal();
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> menuCursos();
                case 2 -> menuTarefas();
                case 0 -> System.out.println("Encerrando aplicação...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    static void exibirMenuPrincipal() {
        System.out.println("\n===== ATIVIDADE JDBC =====");
        System.out.println("1 - Gestão de cursos");
        System.out.println("2 - Gestão de tarefas");
        System.out.println("0 - Sair");
    }

    // ===================== CURSOS =====================

    static void menuCursos() {
        int opcao;

        do {
            exibirMenuCursos();
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> inserirCurso();
                case 2 -> listarCursos();
                case 3 -> atualizarCurso();
                case 4 -> deletarCurso();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    static void exibirMenuCursos() {
        System.out.println("\n===== GESTÃO DE CURSOS =====");
        System.out.println("1 - Inserir curso");
        System.out.println("2 - Listar cursos");
        System.out.println("3 - Atualizar curso");
        System.out.println("4 - Deletar curso");
        System.out.println("0 - Voltar");
    }

    static void inserirCurso() {
        System.out.println("\n--- INSERIR CURSO ---");
        String nome = lerString("Nome do curso: ");
        String periodo = lerString("Período (matutino/vespertino/noturno): ");

        Curso curso = new Curso(nome, periodo);
        cursoDAO.inserir(curso);
    }

    static void listarCursos() {
        System.out.println("\n--- LISTA DE CURSOS ---");
        List<Curso> cursos = cursoDAO.listar();

        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
        } else {
            cursos.forEach(System.out::println);
        }
    }

    static void atualizarCurso() {
        System.out.println("\n--- ATUALIZAR CURSO ---");
        int id = lerInt("ID do curso a atualizar: ");
        String nome = lerString("Novo nome: ");
        String periodo = lerString("Novo período: ");

        Curso curso = new Curso(id, nome, periodo);
        cursoDAO.atualizar(curso);
    }

    static void deletarCurso() {
        System.out.println("\n--- DELETAR CURSO ---");
        int id = lerInt("ID do curso a deletar: ");
        cursoDAO.deletar(id);
    }

    // ===================== TAREFAS =====================

    static void menuTarefas() {
        int opcao;

        do {
            exibirMenuTarefas();
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> criarTarefa();
                case 2 -> listarTodasTarefas();
                case 3 -> editarTarefa();
                case 4 -> deletarTarefa();
                case 5 -> marcarComoConcluida();
                case 6 -> filtrarPorCategoria();
                case 7 -> filtrarPorStatus();
                case 8 -> filtrarPorCategoriaEStatus();
                case 0 -> System.out.println("Voltando ao menu principal...");
                default -> System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    static void exibirMenuTarefas() {
        System.out.println("\n===== GESTÃO DE TAREFAS =====");
        System.out.println("1 - Criar tarefa");
        System.out.println("2 - Listar todas as tarefas");
        System.out.println("3 - Editar tarefa");
        System.out.println("4 - Deletar tarefa");
        System.out.println("5 - Marcar tarefa como concluída");
        System.out.println("6 - Filtrar por categoria");
        System.out.println("7 - Filtrar por status");
        System.out.println("8 - Filtrar por categoria e status");
        System.out.println("0 - Voltar");
    }

    static void criarTarefa() {
        System.out.println("\n--- CRIAR TAREFA ---");
        String titulo = lerString("Título: ");
        String descricao = lerString("Descrição: ");
        String categoria = lerString("Categoria: ");

        Tarefa tarefa = new Tarefa(titulo, descricao, categoria);
        tarefaDAO.inserir(tarefa);
    }

    static void listarTodasTarefas() {
        System.out.println("\n--- TODAS AS TAREFAS ---");
        exibirLista(tarefaDAO.listarTodas());
    }

    static void editarTarefa() {
        System.out.println("\n--- EDITAR TAREFA ---");
        int id = lerInt("ID da tarefa a editar: ");
        String titulo = lerString("Novo título: ");
        String descricao = lerString("Nova descrição: ");
        String categoria = lerString("Nova categoria: ");

        Tarefa tarefa = new Tarefa(id, titulo, descricao, categoria, StatusTarefa.PENDENTE);
        tarefaDAO.editar(tarefa);
    }

    static void deletarTarefa() {
        System.out.println("\n--- DELETAR TAREFA ---");
        int id = lerInt("ID da tarefa a deletar: ");
        tarefaDAO.deletar(id);
    }

    static void marcarComoConcluida() {
        System.out.println("\n--- CONCLUIR TAREFA ---");
        int id = lerInt("ID da tarefa concluída: ");
        tarefaDAO.marcarComoConcluida(id);
    }

    static void filtrarPorCategoria() {
        System.out.println("\n--- FILTRAR POR CATEGORIA ---");
        String categoria = lerString("Categoria: ");
        exibirLista(tarefaDAO.listarPorCategoria(categoria));
    }

    static void filtrarPorStatus() {
        System.out.println("\n--- FILTRAR POR STATUS ---");
        StatusTarefa status = lerStatus();
        exibirLista(tarefaDAO.listarPorStatus(status));
    }

    static void filtrarPorCategoriaEStatus() {
        System.out.println("\n--- FILTRAR POR CATEGORIA E STATUS ---");
        String categoria = lerString("Categoria: ");
        StatusTarefa status = lerStatus();
        exibirLista(tarefaDAO.listarPorCategoriaEStatus(categoria, status));
    }

    static StatusTarefa lerStatus() {
        System.out.println("1 - PENDENTE");
        System.out.println("2 - CONCLUIDA");
        int op = lerInt("Status: ");
        return op == 2 ? StatusTarefa.CONCLUIDA : StatusTarefa.PENDENTE;
    }

    static void exibirLista(List<Tarefa> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            tarefas.forEach(System.out::println);
        }
    }

    // ===================== UTIL =====================

    static String lerString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido. " + mensagem);
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
}
