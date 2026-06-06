package br.edu.fatecpg.polimorfismo.model;

public class PagamentoBoleto extends Pagamento {

    @Override
    public void processarPagamento() {
        System.out.println("Processando pagamento via boleto bancário");
    }
}
