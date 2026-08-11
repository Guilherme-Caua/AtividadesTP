package br.edu.fatecpg.revisaoTP1.model;

public class Voo {
	private static final double TAXA_PONTOS_TURISTICOS = 150.0;

	private String numeroVoo;
	private String origem;
	private String destino;
	private int assentosDisponiveis;
	private double valorPassagem;

	public Voo(String numeroVoo, String origem, String destino, int assentosDisponiveis, double valorPassagem) {
		this.numeroVoo = numeroVoo;
		this.origem = origem;
		this.destino = destino;
		this.assentosDisponiveis = assentosDisponiveis;
		this.valorPassagem = valorPassagem;
	}

	public String getNumeroVoo() {
		return numeroVoo;
	}

	public String getOrigem() {
		return origem;
	}

	public String getDestino() {
		return destino;
	}

	public int getAssentosDisponiveis() {
		return assentosDisponiveis;
	}

	public double getValorPassagem() {
		return valorPassagem;
	}

	public boolean verificarDisponibilidade(int quantidadeAssentos) {
		return quantidadeAssentos <= assentosDisponiveis;
	}

	public void realizarReserva(int quantidadeAssentos) {
		if (verificarDisponibilidade(quantidadeAssentos)) {
			this.assentosDisponiveis -= quantidadeAssentos;
		} else {
			System.out.println("sem assentos disponíveis o bastante");
		}
	}

	public double realizarPagamento(String tipoViagem, boolean pontosTuristicos) {
		double total = valorPassagem;

		if ("ida e volta".equalsIgnoreCase(tipoViagem)) {
			total *= 2;
		} else if (!"somente ida".equalsIgnoreCase(tipoViagem)) {
			System.out.println("Tipo de viagem inválido, considerando somente ida.");
		}

		if (pontosTuristicos) {
			total += TAXA_PONTOS_TURISTICOS;
		}

		System.out.println("Pagamento realizado: R$ " + String.format("%.2f", total)
				+ " (" + tipoViagem + (pontosTuristicos ? " + pontos turísticos" : "") + ")");

		return total;
	}

	public void imprimirPassagem() {
		System.out.println("========= PASSAGEM AÉREA =========");
		System.out.println("Voo: " + numeroVoo);
		System.out.println("Origem: " + origem);
		System.out.println("Destino: " + destino);
		System.out.println("Assentos disponíveis: " + assentosDisponiveis);
		System.out.println("Valor da passagem: R$ " + String.format("%.2f", valorPassagem));
		System.out.println("===================================");
	}
}
