package com.example.pokemon;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Cliente da PokeAPI (https://pokeapi.co/api/v2/pokemon).
 */
public class PokeApiClient {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon";

    private final HttpClient http = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    /** Retorna os nomes de todos os pokémons disponíveis na API. */
    public List<String> listarTodos() throws IOException, InterruptedException {
        // A API é paginada; pedir um limite grande devolve tudo de uma vez.
        JsonNode raiz = get(BASE_URL + "?limit=100000&offset=0")
                .orElseThrow(() -> new IOException("Não foi possível listar os pokémons."));

        List<String> nomes = new ArrayList<>();
        for (JsonNode item : raiz.get("results")) {
            nomes.add(item.get("name").asText());
        }
        return nomes;
    }

    /** Busca um pokémon pelo nome ou pelo número. Vazio se não existir. */
    public Optional<Pokemon> buscar(String nomeOuId) throws IOException, InterruptedException {
        String chave = nomeOuId.trim().toLowerCase();
        return get(BASE_URL + "/" + chave).map(this::converter);
    }

    private Pokemon converter(JsonNode json) {
        String tipos = nomes(json.get("types"), "type");
        String habilidades = nomes(json.get("abilities"), "ability");
        int xp = json.get("base_experience").isNull() ? 0 : json.get("base_experience").asInt();

        return new Pokemon(
                json.get("id").asInt(),
                json.get("name").asText(),
                json.get("height").asInt(),
                json.get("weight").asInt(),
                tipos,
                habilidades,
                xp);
    }

    /** Extrai "name" de cada elemento: [{"type": {"name": "grass"}}] -> "grass". */
    private String nomes(JsonNode array, String campo) {
        return StreamSupport.stream(array.spliterator(), false)
                .map(n -> n.get(campo).get("name").asText())
                .collect(Collectors.joining(", "));
    }

    private Optional<JsonNode> get(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = http.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404) {
            return Optional.empty();
        }
        if (response.statusCode() != 200) {
            throw new IOException("A API respondeu com status " + response.statusCode());
        }
        return Optional.of(mapper.readTree(response.body()));
    }
}
