import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Exercício 1 - Streams e Lambdas com Produto.
 */
public class ExercicioProdutos {

    public static void main(String[] args) {

        // B. População da lista com exemplos de diferentes categorias
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Notebook", "Eletrônicos", 4500.00));
        produtos.add(new Produto("Smartphone", "Eletrônicos", 2800.00));
        produtos.add(new Produto("Fone de Ouvido", "Eletrônicos", 350.00));
        produtos.add(new Produto("Monitor", "Eletrônicos", 1200.00));
        produtos.add(new Produto("Java: Como Programar", "Livros", 180.00));
        produtos.add(new Produto("Clean Code", "Livros", 95.00));
        produtos.add(new Produto("Camiseta", "Roupas", 59.90));
        produtos.add(new Produto("Calça Jeans", "Roupas", 149.90));
        produtos.add(new Produto("Jaqueta", "Roupas", 289.90));

        System.out.println("=== Lista original ===");
        produtos.forEach(System.out::println);

        // C. Filtragem (Filter): apenas produtos da categoria "Eletrônicos"
        List<Produto> eletronicos = produtos.stream()
                .filter(p -> p.getCategoria().equals("Eletrônicos"))
                .collect(Collectors.toList());

        System.out.println("\n=== Filter: somente Eletrônicos ===");
        eletronicos.forEach(System.out::println);

        // D. Transformação (Map) e Ordenação (Sorted):
        // desconto de 10% em cada eletrônico (novos objetos), em ordem crescente de preço
        List<Produto> comDesconto = eletronicos.stream()
                .map(p -> new Produto(p.getNome(), p.getCategoria(), p.getPreco() * 0.90))
                .sorted((a, b) -> Double.compare(a.getPreco(), b.getPreco()))
                .collect(Collectors.toList());

        System.out.println("\n=== Map + Sorted: eletrônicos com 10% de desconto (preço crescente) ===");
        comDesconto.forEach(System.out::println);

        // E. Redução (Reduce): total gasto em produtos da categoria "Roupas"
        double totalRoupas = produtos.stream()
                .filter(p -> p.getCategoria().equals("Roupas"))
                .map(Produto::getPreco)
                .reduce(0.0, Double::sum);

        System.out.printf("%n=== Reduce: total gasto em Roupas ===%nR$ %.2f%n", totalRoupas);

        // F. Agrupamento (GroupingBy): média de preço por categoria
        Map<String, Double> mediaPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(
                        Produto::getCategoria,
                        Collectors.averagingDouble(Produto::getPreco)));

        System.out.println("\n=== GroupingBy: média de preço por categoria ===");
        mediaPorCategoria.forEach((categoria, media) ->
                System.out.printf("%s: R$ %.2f%n", categoria, media));
    }
}
