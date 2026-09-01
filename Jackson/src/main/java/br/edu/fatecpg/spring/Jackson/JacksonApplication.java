package br.edu.fatecpg.spring.Jackson;

import br.edu.fatecpg.spring.Jackson.model.Endereco;
import br.edu.fatecpg.spring.Jackson.service.ConsomeApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tools.jackson.databind.ObjectMapper;

@SpringBootApplication
public class JacksonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JacksonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--começo");

		ObjectMapper mapper = new ObjectMapper();

		String endereco = ConsomeApi.consultaEndereco("11712560");
		System.out.println(endereco);

		var end = mapper.readValue(endereco, Endereco.class);
		System.out.println(end.rua());
	}
}
