package br.edu.fatecpg.polimorfismo.view;

import br.edu.fatecpg.polimorfismo.model.*;

public class Main {

    public static void main(String[] args) {

        // -------------------------------------------------------
        // Exercício 1 - Sobrescrita de métodos: Veículos
        // -------------------------------------------------------
        System.out.println("=== Exercício 1: Veículos ===");
        Veiculo veiculo = new Veiculo();
        Veiculo carro = new Carro();
        Veiculo bicicleta = new Bicicleta();

        veiculo.mover();
        carro.mover();
        bicicleta.mover();

        // -------------------------------------------------------
        // Exercício 2 - Sobrecarga de métodos: Calculadora
        // -------------------------------------------------------
        System.out.println("\n=== Exercício 2: Calculadora ===");
        Calculadora calc = new Calculadora();

        System.out.println("somar(2, 3)        = " + calc.somar(2, 3));
        System.out.println("somar(2, 3, 4)     = " + calc.somar(2, 3, 4));
        System.out.println("somar(2.5, 3.7)    = " + calc.somar(2.5, 3.7));

        // -------------------------------------------------------
        // Exercício 3 - Sobrecarga de construtores: Produto
        // -------------------------------------------------------
        System.out.println("\n=== Exercício 3: Produto ===");
        Produto p1 = new Produto("Caderno");
        Produto p2 = new Produto("Caneta", 2.50);
        Produto p3 = new Produto("Mochila", 150.00, 10);

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // -------------------------------------------------------
        // Exercício 4 - Sobrescrita de métodos: Pagamento
        // -------------------------------------------------------
        System.out.println("\n=== Exercício 4: Pagamento ===");
        Pagamento[] pagamentos = {
            new Pagamento(),
            new PagamentoCartao(),
            new PagamentoBoleto()
        };

        for (Pagamento p : pagamentos) {
            p.processarPagamento();
        }

        // -------------------------------------------------------
        // Exercício 5 - Sobrecarga de métodos: Conversor
        // -------------------------------------------------------
        System.out.println("\n=== Exercício 5: Conversor ===");
        Conversor conversor = new Conversor();

        System.out.println("100°C em Fahrenheit  = " + conversor.converter(100.0) + "°F");
        System.out.println("10 km em milhas      = " + conversor.converter(10.0, true) + " mi");
        System.out.println("\"hello world\" em maiúsculas = " + conversor.converter("hello world"));
    }
}
