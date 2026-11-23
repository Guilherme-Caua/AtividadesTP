package com.example.consulta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Registra cada entidade consultada em um arquivo .log, junto com a data, a hora
 * e o fuso horário (America/Sao_Paulo) em que a consulta foi feita.
 */
public class RegistroLog {

    private static final String ARQUIVO = "consultas.log";
    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss XXX '['VV']'");

    public void registrar(DadosPersonagem personagem) {
        ZonedDateTime agora = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        String linha = agora.format(FORMATO) + " | " + personagem;

        // true = acrescenta no fim do arquivo, sem apagar o que já foi gravado
        try (FileWriter escrita = new FileWriter(ARQUIVO, true)) {
            escrita.write(linha + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Não foi possível gravar no log: " + e.getMessage());
        }
    }

    /** Lê todas as linhas já registradas no arquivo de log. */
    public List<String> lerTudo() {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            // Arquivo ainda não existe: nenhuma consulta foi feita.
        }
        return linhas;
    }
}
