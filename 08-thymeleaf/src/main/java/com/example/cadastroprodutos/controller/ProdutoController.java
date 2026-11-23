package com.example.cadastroprodutos.controller;

import com.example.cadastroprodutos.model.Produto;
import com.example.cadastroprodutos.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProdutoController {

    // Exercício 13: opções fixas do dropdown
    private static final List<String> CATEGORIAS =
            List.of("Eletrônico", "Vestuário", "Alimento", "Outros");

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    // GET / -> redireciona para /cadastrar
    @GetMapping("/")
    public String index() {
        return "redirect:/cadastrar";
    }

    // GET /cadastrar -> formulário vazio
    @GetMapping("/cadastrar")
    public String exibirFormulario(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("categorias", CATEGORIAS);
        return "cadastrar";
    }

    // POST /cadastrar -> valida, salva e redireciona (padrão PRG)
    @PostMapping("/cadastrar")
    public String cadastrarProduto(@Valid @ModelAttribute("produto") Produto produto,
                                   BindingResult resultado,
                                   Model model,
                                   RedirectAttributes redirect) {
        // Exercício 14: se houver erro (ex.: preço negativo), volta ao formulário
        // com as mensagens e não cadastra.
        if (resultado.hasErrors()) {
            model.addAttribute("categorias", CATEGORIAS);
            return "cadastrar";
        }

        service.salvar(produto);
        redirect.addFlashAttribute("mensagem", "Produto \"" + produto.getNome() + "\" cadastrado com sucesso!");
        return "redirect:/lista";
    }

    // GET /lista?busca=...&categoria=... -> tabela com os produtos (filtro opcional)
    @GetMapping("/lista")
    public String exibirLista(@RequestParam(required = false) String busca,
                              @RequestParam(required = false) String categoria,
                              Model model) {
        model.addAttribute("produtos", service.buscar(busca, categoria));
        model.addAttribute("categorias", CATEGORIAS);
        model.addAttribute("busca", busca);
        model.addAttribute("categoriaSelecionada", categoria);
        return "lista";
    }

    // Exercício 15: POST /remover/{id}
    @PostMapping("/remover/{id}")
    public String remover(@PathVariable Long id, RedirectAttributes redirect) {
        service.remover(id);
        redirect.addFlashAttribute("mensagem", "Produto removido.");
        return "redirect:/lista";
    }
}
