package br.edu.fatecpg.revisaoTP1.model;

public class TreinamentoOnline extends Treinamento {
	private String linkAcesso;

	public TreinamentoOnline(int id, String nomeInstrutor, String linguagemEnsinada, String linkAcesso) {
		super(id, nomeInstrutor, linguagemEnsinada);
		this.linkAcesso = linkAcesso;
	}

	public String getLinkAcesso() {
		return linkAcesso;
	}

	public void enviarLinkAcesso(Aluno aluno) {
		System.out.println("Link enviado para " + aluno.getNome() + ": " + linkAcesso);
	}

	@Override
	public String toString() {
		return super.toString() + " | Online - Link: " + linkAcesso;
	}
}
