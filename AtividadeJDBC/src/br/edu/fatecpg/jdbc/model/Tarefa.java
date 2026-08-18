package br.edu.fatecpg.jdbc.model;

public class Tarefa {

    private int id;
    private String titulo;
    private String descricao;
    private String categoria;
    private StatusTarefa status;

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, String categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = StatusTarefa.PENDENTE;
    }

    public Tarefa(int id, String titulo, String descricao, String categoria, StatusTarefa status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public StatusTarefa getStatus() {
        return status;
    }

    public void setStatus(StatusTarefa status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Descrição: " + descricao +
                " | Categoria: " + categoria +
                " | Status: " + status;
    }
}
