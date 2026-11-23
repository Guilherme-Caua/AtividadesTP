package com.example.pokemon;

/**
 * Dados de um Pokémon. Usado tanto para o que vem da API quanto para o que é
 * gravado no banco de dados.
 */
public class Pokemon {
    private final int id;
    private final String nome;
    private final int altura;        // em decímetros (como a PokeAPI entrega)
    private final int peso;          // em hectogramas (como a PokeAPI entrega)
    private final String tipos;      // ex.: "grass, poison"
    private final String habilidades; // ex.: "overgrow, chlorophyll"
    private final int experienciaBase;

    public Pokemon(int id, String nome, int altura, int peso, String tipos,
                   String habilidades, int experienciaBase) {
        this.id = id;
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.tipos = tipos;
        this.habilidades = habilidades;
        this.experienciaBase = experienciaBase;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getAltura() { return altura; }
    public int getPeso() { return peso; }
    public String getTipos() { return tipos; }
    public String getHabilidades() { return habilidades; }
    public int getExperienciaBase() { return experienciaBase; }

    @Override
    public String toString() {
        return String.format("#%d %s", id, nome);
    }
}
