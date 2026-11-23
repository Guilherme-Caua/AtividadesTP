package com.example.consulta;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * Consome a API aberta Rick and Morty (https://rickandmortyapi.com).
 */
public class ConsumoApi {

    private static final String ENDERECO = "https://rickandmortyapi.com/api/character/?name=";

    private final HttpClient client = HttpClient.newHttpClient();

    /**
     * Busca personagens pelo nome. Retorna o JSON da resposta,
     * ou vazio quando nenhum personagem for encontrado (HTTP 404).
     */
    public Optional<String> buscarPorNome(String nome) throws IOException, InterruptedException {
        String url = ENDERECO + URLEncoder.encode(nome.trim(), StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 404) {
            return Optional.empty();
        }
        if (response.statusCode() != 200) {
            throw new IOException("A API respondeu com status " + response.statusCode());
        }
        return Optional.of(response.body());
    }
}
