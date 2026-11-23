# 08 - Thymeleaf: Cadastro de Produtos

Aplicação web em **Spring Boot + Thymeleaf** para cadastrar, listar, filtrar e remover produtos.
Segue o tutorial "Cadastro de Produtos com Thymeleaf" e inclui todos os exercícios do final do arquivo.

## O que a aplicação faz

| Rota | Tela / ação |
|------|-------------|
| `GET /` | Redireciona para `/cadastrar` |
| `GET /cadastrar` | Formulário de cadastro (nome, descrição, preço, estoque, categoria) |
| `POST /cadastrar` | Valida, grava o produto e redireciona para `/lista` |
| `GET /lista` | Tabela de produtos, com busca por nome e filtro por categoria (`?busca=...&categoria=...`) |
| `POST /remover/{id}` | Remove o produto e volta para `/lista` |

## Exercícios do final do arquivo

| Nº | Exercício | Onde está |
|----|-----------|-----------|
| 10 | Novos atributos `estoque` e `descricao` | `Produto.java`, formulário e tabela |
| 11 | CSS próprio | `static/css/style.css` |
| 12 | Total de produtos abaixo da tabela | `lista.html` |
| 13 | Dropdown de categoria (Eletrônico, Vestuário, Alimento, Outros) | `cadastrar.html`, lista fixa no controller |
| 14 | Validação: preço negativo não cadastra e mostra erro | `@PositiveOrZero` no model + `BindingResult` no controller |
| 15 | Coluna "Ações" com botão Remover | `lista.html` + `POST /remover/{id}` |
| 16 | Lógica fora do Controller, em um `@Service` | `ProdutoService.java` |
| 17 | Busca/filtro por nome ou categoria | formulário de `lista.html` + `ProdutoService.buscar` |
| 18 | Banco H2 embarcado com Spring Data JPA | `Produto` como `@Entity`, `ProdutoRepository`, `application.properties` |

O preço usa `BigDecimal` em vez de `double`, como o próprio tutorial recomenda para sistemas reais.

## Como a página Thymeleaf funciona

O Thymeleaf é um motor de templates: os arquivos em `templates/` são HTML comum com atributos
`th:*`. O servidor lê o template, preenche com os dados que o Controller mandou e devolve HTML
pronto ao navegador. A aplicação não expõe uma API REST em JSON; o próprio servidor monta as páginas.

### Como a página recupera dados (listar)

1. O navegador faz `GET /lista`.
2. O `ProdutoController.exibirLista` chama `ProdutoService.buscar(...)`, que consulta o banco
   pelo `ProdutoRepository`.
3. O controller coloca o resultado no `Model` (`model.addAttribute("produtos", ...)`) e devolve o
   nome do template, `"lista"`.
4. Em `lista.html`, `th:each="produto : ${produtos}"` gera uma linha `<tr>` por produto,
   `th:text="${produto.nome}"` escreve cada valor, e `th:if` / `th:unless` mostram a tabela
   ou a mensagem de lista vazia.

### Como a página insere dados (cadastrar)

1. `GET /cadastrar`: o controller envia um `Produto` vazio ao template. `th:object="${produto}"`
   liga o formulário a esse objeto, e `th:field="*{nome}"` gera `id`, `name` e `value` de cada campo.
2. O usuário preenche e envia: o navegador faz `POST /cadastrar` com os campos no corpo da requisição.
3. `@ModelAttribute Produto produto` faz o Spring preencher um novo `Produto` com esses campos
   (usando o construtor vazio e os setters). `@Valid` aplica as regras de validação.
4. Se houver erro, o controller volta para `cadastrar` e o `th:errors` mostra a mensagem junto ao
   campo. Se estiver tudo certo, `ProdutoService.salvar` chama `repository.save(...)`, que
   executa o `INSERT` no banco.
5. O controller responde `redirect:/lista` (padrão Post/Redirect/Get), então recarregar a página
   não reenvia o formulário e o produto não é cadastrado em duplicidade.

## Estrutura

```
src/main/java/com/example/cadastroprodutos/
├── CadastroProdutosApplication.java
├── model/Produto.java                 entidade JPA com validações
├── repository/ProdutoRepository.java  consultas derivadas (Spring Data JPA)
├── service/ProdutoService.java        regras de armazenamento e busca
└── controller/ProdutoController.java  rotas e fluxo entre as telas
src/main/resources/
├── application.properties             configuração do H2
├── static/css/style.css
└── templates/cadastrar.html, lista.html
```

## Executar

Requisitos: Java 17+ e Maven.

```bash
mvn spring-boot:run
```

Acesse http://localhost:8080. Os dados ficam no arquivo `./data/produtos.mv.db`,
e o console do banco em http://localhost:8080/h2-console
(JDBC URL `jdbc:h2:file:./data/produtos`, usuário `sa`, senha vazia).
Se a porta 8080 estiver ocupada, ajuste `server.port` em `application.properties`.
