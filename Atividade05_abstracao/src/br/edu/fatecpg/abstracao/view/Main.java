package br.edu.fatecpg.abstracao.view;
import br.edu.fatecpg.abstracao.model.*;

public class Main {

	public static void main(String[] args) {
		exemploAdvogado();
		exemploArquiteto();
		exemploAtleta();
        exemploAtor();
        exemploBombeiro();
        exemploCantor();
        exemploCientista();
        exemploEngenheiro();
        exemploEstudante();
        exemploFotografo();
        exemploJornalista();
        exemploJuiz();
        exemploMedico();
        exemploMotorista();
        exemploPiloto();
        exemploPintor();
        exemploPolicial();
        exemploPolitico();
        exemploProfessor();
        exemploProgramador();
    }

	public static void exemploAdvogado() {
		
		Advogado advogado = new Advogado();
		advogado.casos_ativos = new String[]{"Processo contra Google Monopólio"};
		advogado.escritorio = "Avenida ABC, 32";
		advogado.especialidade = "Advogado do estado";
		advogado.idade = 32;
		advogado.nome = "Clóvis";
		advogado.numero_oab = "OAB/SP 123456";

		Advogado advogado2 = new Advogado();
		advogado2.casos_ativos = new String[]{"Defesa Google Monopólio"};
		advogado2.escritorio = "Avenida DEF, 64";
		advogado2.especialidade = "Advogado Particular Google";
		advogado2.idade = 50;
		advogado2.nome = "Antônio";
		advogado2.numero_oab = "OAB/SP 987654";

		System.out.println("[Advogado] " + advogado.nome);
		System.out.println("[Advogado2] " + advogado2.especialidade);

		System.out.print("[Advogado] ");
		advogado.analisarProcesso();
		System.out.print("[Advogado2] ");
		advogado2.defenderCliente();
	}

	public static void exemploArquiteto() {
		
		Arquiteto arquiteto = new Arquiteto();
		arquiteto.nome = "Carlos Eduardo Martins";
		arquiteto.rnp = "1234567890";
		arquiteto.cau = "A12345-6";
		arquiteto.especialidade = "Arquitetura Sustentável";
		arquiteto.historico_projetos = new String[]{
		    "Projeto Residencial EcoVila - 2022",
		    "Centro Cultural Verde Urbano - 2023"
		};

		Arquiteto arquiteto2 = new Arquiteto();
		arquiteto2.nome = "Fernanda Alves Rocha";
		arquiteto2.rnp = "0987654321";
		arquiteto2.cau = "A54321-0";
		arquiteto2.especialidade = "Urbanismo e Planejamento";
		arquiteto2.historico_projetos = new String[]{
		    "Plano Diretor Bairro Nova Esperança - 2021",
		    "Requalificação da Praça Central - 2024"
		};

		System.out.println("[Arquiteto] " + arquiteto.nome);
		System.out.println("[Arquiteto2] " + arquiteto2.especialidade);

		System.out.print("[Arquiteto] ");
		arquiteto.desenharPlanos();
		System.out.print("[Arquiteto2] ");
		arquiteto2.definirMateriais();
	}

	public static void exemploAtleta() {
		Atleta atleta = new Atleta();
		atleta.nome = "Rafael Costa";
		atleta.idade = 27;
		atleta.esporte = "Futebol";
		atleta.clube = "Santos FC";
		atleta.categoria = "Profissional";
		atleta.altura = 1.82;
		atleta.peso = 78.5;
		atleta.salario = 350000.00;

		Atleta atleta2 = new Atleta();
		atleta2.nome = "Mariana Lopes";
		atleta2.idade = 24;
		atleta2.esporte = "Vôlei";
		atleta2.clube = "Osasco Vôlei Clube";
		atleta2.categoria = "Profissional";
		atleta2.altura = 1.88;
		atleta2.peso = 72.0;
		atleta2.salario = 120000.00;

		System.out.println("[Atleta] " + atleta.nome);
		System.out.println("[Atleta2] " + atleta2.esporte);

		System.out.print("[Atleta] ");
		atleta.cumprirContrato();
		System.out.print("[Atleta2] ");
		atleta2.cuidarSaude();
	}

	public static void exemploAtor() {
		
		Ator ator = new Ator();
		ator.nome = "Leonardo DiCaprio";
		ator.drt = "93212367312";
		ator.idade = 26;
		ator.idiomas_fluentes = new String[]{"Inglês", "Francês"};
		ator.papeis_previos = new String[] {"Hamlet", "O selvagem"};

		Ator ator2 = new Ator();
		ator2.nome = "Johnny Depp";
		ator2.drt = "82101256201";
		ator2.idade = 60;
		ator2.idiomas_fluentes = new String[]{"Inglês", "Português"};
		ator2.papeis_previos = new String[] {"Platão", "Socrates"};

        System.out.println("[Ator] " + ator.drt);
        System.out.println("[Ator2] " + ator2.idade);

        System.out.print("[Ator] ");
		ator.chorar();
        System.out.print("[Ator2] ");
		ator2.falar("Do not go gentle into that good night.");
	}

	public static void exemploBombeiro() {
		
		Bombeiro bombeiro = new Bombeiro();
		bombeiro.nome = "Ricardo Azevedo";
		bombeiro.idade = 41;
		bombeiro.especialidade = "Combate a incêndios urbanos";
		bombeiro.anos_de_servico = 17;
		bombeiro.quartel_bombeiros = "Corpo de Bombeiros - Unidade Central";

		Bombeiro bombeiro2 = new Bombeiro();
		bombeiro2.nome = "Leandro Batista";
		bombeiro2.idade = 35;
		bombeiro2.especialidade = "Resgate e salvamento";
		bombeiro2.anos_de_servico = 11;
		bombeiro2.quartel_bombeiros = "Corpo de Bombeiros - Unidade Zona Sul";

        System.out.println("[Bombeiro] " + bombeiro.nome);
        System.out.println("[Bombeiro2] " + bombeiro2.especialidade);

        System.out.print("[Bombeiro] ");
		bombeiro.apagarIncendio();
        System.out.print("[Bombeiro2] ");
		bombeiro2.dirigirCaminhao();
	}

	public static void exemploCantor() {
		
		Cantor cantor = new Cantor();
		cantor.nome = "Lucas Freitas";
		cantor.generos = new String[]{"Pop", "MPB"};
		cantor.discografia = "Vozes da Cidade (2020)";
		cantor.instrumentos = new String[]{"Violão", "Piano"};
		cantor.em_banda = false;

		Cantor cantor2 = new Cantor();
		cantor2.nome = "Marina Duarte";
		cantor2.generos = new String[]{"Rock", "Indie"};
		cantor2.discografia = "Horizonte Elétrico (2022)";
		cantor2.instrumentos = new String[]{"Guitarra", "Teclado"};
		cantor2.em_banda = true;

        System.out.println("[Cantor] " + cantor.nome);
        System.out.println("[Cantor2] " + cantor2.generos[0]);

        System.out.print("[Cantor] ");
		cantor.darAutografo();
        System.out.print("[Cantor2] ");
		cantor2.fazerShow();
	}

	public static void exemploCientista() {
		
		Cientista cientista = new Cientista();
		cientista.nome = "Dr. Roberto Almeida";
		cientista.cpf = "123.456.789-00";
		cientista.especialidade = "Biotecnologia";
		cientista.patentes = new String[]{
		    "Método de cultivo celular otimizado",
		    "Dispositivo de análise genética portátil"
		};
		cientista.manuscritos = new String[]{
		    "Aplicações da engenharia genética na medicina",
		    "Estudos sobre regeneração celular"
		};

		Cientista cientista2 = new Cientista();
		cientista2.nome = "Dra. Juliana Costa";
		cientista2.cpf = "987.654.321-00";
		cientista2.especialidade = "Física Quântica";
		cientista2.patentes = new String[]{
		    "Sensor quântico de alta precisão"
		};
		cientista2.manuscritos = new String[]{
		    "Introdução à computação quântica",
		    "Modelos matemáticos de partículas subatômicas"
		};

        System.out.println("[Cientista] " + cientista.nome);
        System.out.println("[Cientista2] " + cientista2.especialidade);

        System.out.print("[Cientista] ");
		cientista.coletarAmostras();
        System.out.print("[Cientista2] ");
		cientista2.realizarPesquisar();
	}

	public static void exemploEngenheiro() {
		
		Engenheiro engenheiro = new Engenheiro();
		engenheiro.nome = "Marcos Vinicius";
		engenheiro.especialidade = "Engenharia Civil";
		engenheiro.rnp = "1122334455";
		engenheiro.projetos_previos = new String[]{
		    "Ponte sobre o Rio Azul",
		    "Viaduto Central da Cidade"
		};
		engenheiro.nivel_de_graduacao = "Mestrado";

		Engenheiro engenheiro2 = new Engenheiro();
		engenheiro2.nome = "Patricia Menezes";
		engenheiro2.especialidade = "Engenharia de Software";
		engenheiro2.rnp = "9988776655";
		engenheiro2.projetos_previos = new String[]{
		    "Sistema de gestão hospitalar",
		    "Plataforma de pagamentos digitais"
		};
		engenheiro2.nivel_de_graduacao = "Doutorado";

        System.out.println("[Engenheiro] " + engenheiro.nome);
        System.out.println("[Engenheiro2] " + engenheiro2.especialidade);

        System.out.print("[Engenheiro] ");
		engenheiro.fiscalizarProjeto();
        System.out.print("[Engenheiro2] ");
		engenheiro2.emitirLaudoTecnico();
	}

	public static void exemploEstudante() {
		
		Estudante estudante = new Estudante();
		estudante.nome = "Lucas Andrade";
		estudante.instituicao_ensino = "FATEC";
		estudante.turma = "ADS 3º semestre";
		estudante.materia_preferida = "Técnicas de Programação";
		estudante.data_nascimento = "2004-08-15";

		Estudante estudante2 = new Estudante();
		estudante2.nome = "Beatriz Lima";
		estudante2.instituicao_ensino = "FATEC";
		estudante2.turma = "ADS 2º semestre";
		estudante2.materia_preferida = "Banco de Dados";
		estudante2.data_nascimento = "2005-03-02";

        System.out.println("[Estudante] " + estudante.instituicao_ensino);
        System.out.println("[Estudante2] " + estudante2.materia_preferida);

        System.out.print("[Estudante] ");
		estudante.escrever("Classe: modelo lógico conceitual que representa uma entidade do mundo real.");
        System.out.print("[Estudante2] ");
		estudante2.conversar();
	}

	public static void exemploFotografo() {
		
		Fotografo fotografo = new Fotografo();
		fotografo.nome = "Renato Oliveira";
		fotografo.idade = 34;
		fotografo.especialidade = "Fotografia de Casamento";
		fotografo.equipamentos = new String[]{
		    "Canon EOS R5",
		    "Lente 50mm",
		    "Drone DJI Mini"
		};
		fotografo.localizacao = "São Paulo";
		fotografo.contato = "renato.fotos@email.com";

		Fotografo fotografo2 = new Fotografo();
		fotografo2.nome = "Ana Paula Santos";
		fotografo2.idade = 29;
		fotografo2.especialidade = "Fotografia de Natureza";
		fotografo2.equipamentos = new String[]{
		    "Nikon D850",
		    "Lente 70-200mm"
		};
		fotografo2.localizacao = "Curitiba";
		fotografo2.contato = "ana.nature@email.com";

        System.out.println("[Fotografo] " + fotografo.idade);
        System.out.println("[Fotografo2] " + fotografo2.equipamentos[0]);

        System.out.print("[Fotografo] ");
		fotografo.calcularOrcamento();
        System.out.print("[Fotografo2] ");
		fotografo2.editarFotos();
	}

	public static void exemploJornalista() {
		
		Jornalista jornalista = new Jornalista();
		jornalista.nome = "Ricardo Matos";
		jornalista.idade = 41;
		jornalista.area_atuacao = "Política";
		jornalista.anos_experiencia = 18;
		jornalista.veiculo = "Jornal Nacional";
		jornalista.cargo = "Repórter";
		jornalista.email = "ricardo.matos@jornal.com";
		jornalista.telefone = "11999999999";

		Jornalista jornalista2 = new Jornalista();
		jornalista2.nome = "Larissa Farias";
		jornalista2.idade = 33;
		jornalista2.area_atuacao = "Tecnologia";
		jornalista2.anos_experiencia = 10;
		jornalista2.veiculo = "Tech News";
		jornalista2.cargo = "Editora";
		jornalista2.email = "larissa@technews.com";
		jornalista2.telefone = "11888888888";

        System.out.println("[Jornalista] " + jornalista.area_atuacao);
        System.out.println("[Jornalista2] " + jornalista2.cargo);

        System.out.print("[Jornalista] ");
		jornalista.apurarNoticias();
        System.out.print("[Jornalista2] ");
		jornalista2.entrevistarFontes();
	}

	public static void exemploJuiz() {
		
		Juiz juiz = new Juiz();
		juiz.nome = "Paulo Henrique";
		juiz.idade = 55;
		juiz.comarca = "São Paulo";
		juiz.anos_de_magistratura = 25;
		juiz.status_tribunal = "Ativo";

		Juiz juiz2 = new Juiz();
		juiz2.nome = "Claudia Ribeiro";
		juiz2.idade = 48;
		juiz2.comarca = "Campinas";
		juiz2.anos_de_magistratura = 20;
		juiz2.status_tribunal = "Ativo";

        System.out.println("[Juiz] " + juiz.nome);
        System.out.println("[Juiz2] " + juiz2.anos_de_magistratura);

        System.out.print("[Juiz] ");
		juiz.presidirJulgamento();
        System.out.print("[Juiz2] ");
		juiz2.analisarProvas();
	}

	public static void exemploMedico() {
		
		Medico medico = new Medico();
		medico.nome = "Dr. Felipe Cardoso";
		medico.crm = "CRM/SP 456789";
		medico.especialidade = "Cardiologia";
		medico.hospital_atual = "Hospital São Lucas";

		Medico medico2 = new Medico();
		medico2.nome = "Dra. Mariana Lopes";
		medico2.crm = "CRM/SP 654321";
		medico2.especialidade = "Neurologia";
		medico2.hospital_atual = "Hospital Albert Einstein";

        System.out.println("[Medico] " + medico.nome);
        System.out.println("[Medico2] " + medico2.crm);

        System.out.print("[Medico] ");
		medico.diagnosticar();
        System.out.print("[Medico2] ");
		medico2.requisitarExame();
	}

	public static void exemploMotorista() {
		
		Motorista motorista = new Motorista();
		motorista.nome = "João Batista";
		motorista.idade = 45;
		motorista.tipo_carteira = "D";
		motorista.veiculo = "Ônibus";
		motorista.anos_experiencia = 20;

		Motorista motorista2 = new Motorista();
		motorista2.nome = "Carlos Mendes";
		motorista2.idade = 38;
		motorista2.tipo_carteira = "B";
		motorista2.veiculo = "Carro particular";
		motorista2.anos_experiencia = 15;

        System.out.println("[Motorista] " + motorista.veiculo);
        System.out.println("[Motorista2] " + motorista2.veiculo);

        System.out.print("[Motorista] ");
		motorista.abastecer(16);
        System.out.print("[Motorista2] ");
		motorista2.estacionar();
	}

	public static void exemploPiloto() {
		
		Piloto piloto = new Piloto();
		piloto.nome = "Fernando Costa";
		piloto.idade = 44;
		piloto.licenca_voo = "PLA12345";
		piloto.horas_de_voo = 6500;
		piloto.companhia_aerea = "LATAM";
		piloto.aeronave_atual = "Airbus A320";

		Piloto piloto2 = new Piloto();
		piloto2.nome = "Renata Figueiredo";
		piloto2.idade = 39;
		piloto2.licenca_voo = "PLA67890";
		piloto2.horas_de_voo = 5200;
		piloto2.companhia_aerea = "Azul";
		piloto2.aeronave_atual = "Embraer E195";

        System.out.println("[Piloto] " + piloto.idade);
        System.out.println("[Piloto2] " + piloto2.horas_de_voo);

        System.out.print("[Piloto] ");
		piloto.ajustarRota();
        System.out.print("[Piloto2] ");
		piloto2.comunicarTorre();
	}

	public static void exemploPintor() {
		
		Pintor pintor = new Pintor();
		pintor.nome = "Eduardo Martins";
		pintor.cpf = "111.222.333-44";
		pintor.especialidade = "Pintura abstrata";
		pintor.projetos = new String[]{
		    "Exposição Cores Urbanas",
		    "Painel artístico do Centro Cultural"
		};
		pintor.formacao = "Belas Artes";

		Pintor pintor2 = new Pintor();
		pintor2.nome = "Luciana Prado";
		pintor2.cpf = "555.666.777-88";
		pintor2.especialidade = "Realismo";
		pintor2.projetos = new String[]{
		    "Retratos históricos",
		    "Exposição Memórias"
		};
		pintor2.formacao = "Artes Visuais";

        System.out.println("[Pintor] " + pintor.nome);
        System.out.println("[Pintor2] " + pintor2.formacao);

        System.out.print("[Pintor] ");
		pintor.pintar();
        System.out.print("[Pintor2] ");
		pintor2.publicarArte();
	}

	public static void exemploPolicial() {
		
		Policial policial = new Policial();
		policial.nome = "Roberto Silva";
		policial.idade = 37;
		policial.patente = "Sargento";
		policial.arma = "Pistola";
		policial.anos_de_servico = 15;

		Policial policial2 = new Policial();
		policial2.nome = "André Carvalho";
		policial2.idade = 29;
		policial2.patente = "Cabo";
		policial2.arma = "Fuzil";
		policial2.anos_de_servico = 7;

        System.out.println("[Policial] " + policial.arma);
        System.out.println("[Policial2] " + policial2.nome);


        System.out.print("[Policial] ");
		policial.prenderSuspeito();
        System.out.print("[Policial2] ");
		policial2.patrulhar();
	}

	public static void exemploPolitico() {
		
		Politico politico = new Politico();
		politico.nome = "João Pereira";
		politico.cargo = "Vereador";
		politico.partido = "ABC";
		politico.esfera = "Municipal";
		politico.mandato_inicio = "2021-01-01";
		politico.mandato_fim = "2024-12-31";
		politico.status_mandato = "Ativo";
		politico.cidade_estado = "São Paulo/SP";

		Politico politico2 = new Politico();
		politico2.nome = "Mariana Souza";
		politico2.cargo = "Deputada Estadual";
		politico2.partido = "XYZ";
		politico2.esfera = "Estadual";
		politico2.mandato_inicio = "2023-01-01";
		politico2.mandato_fim = "2026-12-31";
		politico2.status_mandato = "Ativo";
		politico2.cidade_estado = "São Paulo/SP";

        System.out.println("[Politico] " + politico.cargo);
        System.out.println("[Politico2] " + politico2.status_mandato);

        System.out.print("[Politico] ");
		politico.atenderCidadao("Eduardo Soares e Araújo");
        System.out.print("[Politico2] ");
		politico2.participarSessao();
	}

	public static void exemploProfessor() {
		// Professor
		Professor professor = new Professor();
		professor.nome = "Helena Duarte";
		professor.salario = 7500.00;
		professor.especialidade = "Matemática";
		professor.situacao_trabalho = "Efetivo";
		professor.tempo_de_carreira = 18;

		Professor professor2 = new Professor();
		professor2.nome = "Ricardo Tavares";
		professor2.salario = 6800.00;
		professor2.especialidade = "História";
		professor2.situacao_trabalho = "Efetivo";
		professor2.tempo_de_carreira = 12;

        System.out.println("[Professor] " + professor.salario);
        System.out.println("[Professor2] " + professor2.situacao_trabalho);

        System.out.print("[Professor] ");
		professor.prepararAula();
        System.out.print("[Professor2] ");
		professor2.prepararProva();
	}

	public static void exemploProgramador() {
		
		Programador programador = new Programador();
		programador.nome = "Gabriel Souza";
		programador.area_atuacao = "Backend";
		programador.especialidades = "Java, Spring Boot, SQL";
		programador.paradigma_favorito = "Orientado a Objetos";
		programador.cargo = "Desenvolvedor Backend";

		Programador programador2 = new Programador();
		programador2.nome = "Camila Ferreira";
		programador2.area_atuacao = "Frontend";
		programador2.especialidades = "React, TypeScript, CSS";
		programador2.paradigma_favorito = "Funcional";
		programador2.cargo = "Desenvolvedora Frontend";

        System.out.println("[Programador] " + programador.area_atuacao);
        System.out.println("[Programador2] " + programador2.especialidades);

        System.out.print("[Programador] ");
		programador.escreverCodigo();
        System.out.print("[Programador2] ");
		programador2.completarTask();
	}

}
