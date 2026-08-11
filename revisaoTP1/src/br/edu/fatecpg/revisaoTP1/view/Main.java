package br.edu.fatecpg.revisaoTP1.view;

import br.edu.fatecpg.revisaoTP1.model.*;

public class Main {
	public static void main(String[] args) {
		testarSistemaRestaurante();
		testarSistemaVoos();
		testarSistemaTreinamento();
	}

	private static void testarSistemaRestaurante() {
		System.out.println("############################################");
		System.out.println("# SISTEMA DE PEDIDOS EM RESTAURANTE");
		System.out.println("############################################");

		Restaurante restaurante = new Restaurante();

		Pedido pedido1 = new Pedido(1, 5.0);
		pedido1.adicionarItem(new ItemPedido("Feijoada", 2, 35.0));
		pedido1.adicionarItem(new ItemPedido("Refrigerante", 2, 6.5));
		pedido1.reservarMesa(4);

		Pedido pedido2 = new Pedido(2, 8.0);
		pedido2.adicionarItem(new ItemPedido("Pizza Marguerita", 1, 48.0));
		ItemPedido sobremesa = new ItemPedido("Pudim", 1, 12.0);
		pedido2.adicionarItem(sobremesa);
		pedido2.removerItem(sobremesa);

		restaurante.adicionarPedido(pedido1);
		restaurante.adicionarPedido(pedido2);

		System.out.println("== Todos os pedidos ==");
		restaurante.exibirPedidos();

		System.out.println("== Busca pelo pedido 1 ==");
		Pedido encontrado = restaurante.buscarPedido(1);
		System.out.println(encontrado);

		System.out.println("\n== Total do pedido 1: R$ " + String.format("%.2f", pedido1.calcularTotalPedido()));

		restaurante.removerPedido(pedido2);
		System.out.println("\n== Pedidos após remoção do pedido 2 ==");
		restaurante.exibirPedidos();
		System.out.println();
	}

	private static void testarSistemaVoos() {
		System.out.println("############################################");
		System.out.println("# SISTEMA DE RESERVAS DE PASSAGENS AÉREAS");
		System.out.println("############################################");

		Aeroporto aeroporto = new Aeroporto();

		Voo voo1 = new Voo("LA3456", "São Paulo", "Rio de Janeiro", 4, 350.0);
		Voo voo2 = new Voo("G31234", "Curitiba", "Salvador", 2, 520.0);

		aeroporto.adicionarVoo(voo1);
		aeroporto.adicionarVoo(voo2);

		System.out.println("== Todos os voos ==");
		aeroporto.exibirVoos();

		System.out.println("\n== Reserva no voo LA3456 ==");
		voo1.realizarReserva(3);
		voo1.imprimirPassagem();

		System.out.println("\n== Tentativa de reserva acima da disponibilidade no voo G31234 ==");
		voo2.realizarReserva(5);

		System.out.println("\n== Pagamento do voo LA3456 (ida e volta, com pontos turísticos) ==");
		voo1.realizarPagamento("ida e volta", true);

		System.out.println("\n== Busca pelo voo G31234 ==");
		Voo encontrado = aeroporto.buscarVoo("G31234");
		if (encontrado != null) {
			encontrado.imprimirPassagem();
		}

		aeroporto.removerVoo(voo2);
		System.out.println("\n== Voos após remoção do G31234 ==");
		aeroporto.exibirVoos();
		System.out.println();
	}

	private static void testarSistemaTreinamento() {
		System.out.println("############################################");
		System.out.println("# SISTEMA DE TREINAMENTO EM TECNOLOGIA");
		System.out.println("############################################");

		TreinamentoPresencial presencial = new TreinamentoPresencial(1, "Carlos Souza", "Java", "Sala 302");
		presencial.definirCargaHoraria(40);
		presencial.reservarSala("Sala 305");

		TreinamentoOnline online = new TreinamentoOnline(2, "Marina Lima", "Python", "https://treino.com/python");
		online.definirCargaHoraria(50);

		Aluno ana = new Aluno("Ana Ferreira");
		Aluno bruno = new Aluno("Bruno Alves");

		System.out.println("== Disponibilidade dos instrutores ==");
		System.out.println("Presencial disponível: " + presencial.verificarDisponibilidade());
		System.out.println("Online disponível: " + online.verificarDisponibilidade());

		System.out.println("\n== Matrículas no treinamento presencial (Java) ==");
		presencial.matricularAluno(ana);
		presencial.matricularAluno(bruno);

		System.out.println("\n== Matrículas no treinamento online (Python) ==");
		online.matricularAluno(ana);
		online.enviarLinkAcesso(ana);

		System.out.println("\n== Tentativa de nova matrícula da Ana, excedendo limite de 80h ==");
		TreinamentoOnline online2 = new TreinamentoOnline(3, "Marina Lima", "JavaScript", "https://treino.com/js");
		online2.definirCargaHoraria(30);
		online2.matricularAluno(ana);

		ana.setNotaFinal(9.0);
		bruno.setNotaFinal(7.5);

		System.out.println("\n== Média dos alunos do treinamento presencial ==");
		System.out.println("Média: " + presencial.calcularMediaAlunos());

		System.out.println("\n== Detalhes dos treinamentos ==");
		System.out.println(presencial);
		System.out.println(online);
	}
}