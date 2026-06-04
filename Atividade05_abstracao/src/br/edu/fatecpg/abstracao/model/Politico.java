package br.edu.fatecpg.abstracao.model;

public class Politico {
   
    public String nome;
    public String cargo;
    public String partido;
    public String esfera;
    public String mandato_inicio; // yyyy-mm-dd
    public String mandato_fim; // yyyy-mm-dd
    public String status_mandato;
    public String cidade_estado;

    public void proporProjetos(String[] projetos) {
        System.out.println("Propondo projetos");
        for (String projeto : projetos) {
            System.out.println("- "+projeto+"...");
        }
        System.out.println("Projetos propostos com êxito.");
    }
    public void votarProposicao(String proposicao) {
        System.out.println("Votando na proposicao '"+proposicao+"'...");
        System.out.println("Proposicao '"+proposicao+"' votada com êxito.");
    }
    public void participarSessao() {
        System.out.println("Participando da sessão atual...");
        System.out.println("Sessão finalizada com êxito.");

    }
    public void atenderCidadao(String nome_cidadao)  {
        System.out.println("Atendendo cidadão '"+nome_cidadao+"'");
        System.out.println("Cidadão atendido com êxito.");
    }
    public void prestarContas() {
        System.out.println("Prestando todas as contas...");
        System.out.println("Todas as contas fora prestadas com êxito.");
    }
}
