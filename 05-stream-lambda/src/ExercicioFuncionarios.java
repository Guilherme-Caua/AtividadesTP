import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Exercício 2 - Manipulação de dados de funcionários com Streams e Lambdas.
 */
public class ExercicioFuncionarios {

    public static void main(String[] args) {

        // 2. População da lista: 8 funcionários, 4 departamentos, valores variados
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Carlos Silva", "TI", 6500.00, 12));
        funcionarios.add(new Funcionario("Ana Souza", "TI", 4200.00, 3));
        funcionarios.add(new Funcionario("Bruno Lima", "RH", 2800.00, 11));
        funcionarios.add(new Funcionario("Daniela Rocha", "RH", 3500.00, 6));
        funcionarios.add(new Funcionario("Eduardo Alves", "Financeiro", 5200.00, 15));
        funcionarios.add(new Funcionario("Fernanda Costa", "Financeiro", 2500.00, 2));
        funcionarios.add(new Funcionario("Gustavo Pereira", "Vendas", 3100.00, 10));
        funcionarios.add(new Funcionario("Helena Martins", "Vendas", 3900.00, 8));

        System.out.println("=== Lista original ===");
        funcionarios.forEach(System.out::println);

        // 3. Filtragem: salário superior a R$ 3000
        double salarioMinimo = 3000.00;
        List<Funcionario> salarioAlto = funcionarios.stream()
                .filter(f -> f.getSalario() > salarioMinimo)
                .collect(Collectors.toList());

        System.out.println("\n=== Filter: salário superior a R$ 3000,00 ===");
        salarioAlto.forEach(System.out::println);

        // Mapeamento: aumento de 5% para quem tem mais de 10 anos de serviço
        // (cria novos objetos; os demais permanecem iguais)
        List<Funcionario> comAumento = funcionarios.stream()
                .map(f -> f.getAnosDeServico() > 10
                        ? new Funcionario(f.getNome(), f.getDepartamento(),
                                f.getSalario() * 1.05, f.getAnosDeServico())
                        : f)
                .collect(Collectors.toList());

        System.out.println("\n=== Map: aumento de 5% para quem tem mais de 10 anos de serviço ===");
        comAumento.forEach(System.out::println);

        // Ordenação: por nome, em ordem alfabética
        List<Funcionario> ordenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());

        System.out.println("\n=== Sorted: ordem alfabética por nome ===");
        ordenados.forEach(System.out::println);

        // Redução: total gasto com salários
        double totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(0.0, Double::sum);

        // Agrupamento: média salarial por departamento
        Map<String, Double> mediaPorDepartamento = funcionarios.stream()
                .collect(Collectors.groupingBy(
                        Funcionario::getDepartamento,
                        Collectors.averagingDouble(Funcionario::getSalario)));

        // 4. Exibição separada do total e das médias
        System.out.printf("%n=== Reduce: total gasto com salários ===%nR$ %.2f%n", totalSalarios);

        System.out.println("\n=== GroupingBy: média salarial por departamento ===");
        mediaPorDepartamento.forEach((depto, media) ->
                System.out.printf("%s: R$ %.2f%n", depto, media));
    }
}
