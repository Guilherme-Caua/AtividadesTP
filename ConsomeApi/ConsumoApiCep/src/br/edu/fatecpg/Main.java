package br.edu.fatecpg;

import br.edu.fatecpg.model.Endereco;
import br.edu.fatecpg.model.HistoricoEndereco;
import br.edu.fatecpg.service.ApiEndereco;

import java.util.Scanner;

public class Main {
    private static HistoricoEndereco hist = new HistoricoEndereco();
    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        var api = new ApiEndereco();

        try {
            while (true) {
                System.out.print("""
                Selecione o que deseja fazer:
                1 - Consultar Endereço
                2 - Listar endereços consultados
                3 - Limpar endereços
                0 - Sair
                >
                """);
                int option = Integer.parseInt(s.nextLine());

                switch (option) {
                    case 1:
                        System.out.print("Digite o cep que deseja consultar\n> ");
                        Endereco endereco = api.obterEndereco(s.nextLine());
                        hist.addEndereco(endereco);

                        System.out.println(endereco);
                        break;
                    case 2:
                        hist.exibirHistorico();
                        break;
                    case 3:
                        hist.limpar();
                        System.out.println("Histórico limpo");
                        break;
                    case 0:
                        return;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}