package com.example.consulta;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Envelope da resposta da busca: a API devolve a lista dentro do campo "results".
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosBusca(List<DadosPersonagem> results) {
}
