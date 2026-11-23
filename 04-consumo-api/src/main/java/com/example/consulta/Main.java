package com.example.consulta;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Atividade 04 - Consumo de API.
 * Menu em repetição: 1. Consultar  2. Listar  3. Sair
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsumoApi consumo = new ConsumoApi();
        ConverteDados conversor = new ConverteDados();
        RegistroLog log = new RegistroLog();

        int opcao = -1;
        while (opcao != 3) {
            System.out.println();
            System.out.println("===== RICK AND MORTY =====");
            System.out.println("1. Consultar");
            System.out.println("2. Listar");
            System.out.println("3. Sair");
            System.out.print("Escolha: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1 -> consultar(scanner, consumo, conversor, log);
                case 2 -> listar(log);
                case 3 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void consultar(Scanner scanner, ConsumoApi consumo,
                                  ConverteDados conversor, RegistroLog log) {
        System.out.print("Nome do personagem: ");
        String nome = scanner.nextLine();
        if (nome.isBlank()) {
            System.out.println("Informe um nome.");
            return;
        }

        try {
            Optional<String> json = consumo.buscarPorNome(nome);
            if (json.isEmpty()) {
                System.out.println("Nenhum personagem encontrado.");
                return;
            }

            DadosBusca busca = conversor.obterDados(json.get(), DadosBusca.class);
            System.out.println();
            for (DadosPersonagem personagem : busca.results()) {
                System.out.println(personagem);
                log.registrar(personagem); // toda entidade consultada vai para o .log
            }
        } catch (IOException e) {
            System.out.println("Falha ao acessar a API: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Consulta interrompida.");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listar(RegistroLog log) {
        List<String> registros = log.lerTudo();
        if (registros.isEmpty()) {
            System.out.println("Nenhuma consulta registrada ainda.");
            return;
        }
        System.out.println("\nConsultas registradas (consultas.log):");
        registros.forEach(System.out::println);
    }
}
