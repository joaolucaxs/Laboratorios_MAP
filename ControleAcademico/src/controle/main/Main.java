package controle.main;

import controle.entidades.ControleAcademico;

public class Main {
	public static void main(String[] args) throws Exception {

		// CRIAÇÃO CONTROLE ACADEMICO !

		ControleAcademico ca = new ControleAcademico();

		ca.cadastrarTurma("Metodos Avançados de Programação", "Segunda", "9:00");
		ca.cadastrarTurma("Banco de Dados", "Segunda", "7:00");
		ca.cadastrarTurma("Redes", "Terça", "11:00");
		ca.cadastrarTurma("APS", "Quarta", "7:00");
		ca.cadastrarTurma("Calculo 3", "Sexta", "7:00");

		ca.cadastrarProfessores("Sabrina", 123);
		ca.cadastrarProfessores("Fabio", 456);
		ca.cadastrarProfessores("Janderson", 789);
		ca.cadastrarProfessores("Luciana", 1011);
		ca.cadastrarProfessores("Maxuel", 1314);

		ca.adicionarAlunos("João", 111, "Computação");
		ca.adicionarAlunos("Josenelle", 222, "Computação");
		ca.adicionarAlunos("Gabriel", 333, "Computação");
		ca.adicionarAlunos("Evan", 444, "Química");
		ca.adicionarAlunos("Pedro", 555, "Matemática");
		ca.adicionarAlunos("Henrique", 666, "Física");

		ca.definirProfessorNaDisciplina("Sabrina", "Banco de Dados");
		ca.definirProfessorNaDisciplina("Sabrina", "Metodos Avançados de Programação");
		ca.definirProfessorNaDisciplina("Fabio", "Redes");
		ca.definirProfessorNaDisciplina("Janderson", "APS");
		ca.definirProfessorNaDisciplina("Maxuel", "Calculo 3");

		ca.cadastrarAlunosNaDisciplina("João", "Banco de Dados");
		ca.cadastrarAlunosNaDisciplina("João", "Metodos Avançados de Programação");
		ca.cadastrarAlunosNaDisciplina("João", "APS");
		ca.cadastrarAlunosNaDisciplina("João", "Calculo 3");
		ca.cadastrarAlunosNaDisciplina("Josenelle", "Banco de Dados");
		ca.cadastrarAlunosNaDisciplina("Josenelle", "APS");
		ca.cadastrarAlunosNaDisciplina("Josenelle", "Calculo 3");
		ca.cadastrarAlunosNaDisciplina("Gabriel", "Redes");
		ca.cadastrarAlunosNaDisciplina("Gabriel", "Metodos Avançados de Programação");
		ca.cadastrarAlunosNaDisciplina("Evan", "Calculo 3");
		ca.cadastrarAlunosNaDisciplina("Pedro", "Calculo 3");
		ca.cadastrarAlunosNaDisciplina("Henrique", "Calculo 3");

		System.out.println(ca.getProfessor("Fabio").toString());
		System.out.println(ca.getProfessor("Fabio").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(ca.getProfessor("Sabrina").toString());
		System.out.println(ca.getProfessor("Sabrina").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(ca.getProfessor("Janderson").toString());
		System.out.println(ca.getProfessor("Janderson").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(ca.getProfessor("Luciana").toString());
		System.out.println(ca.getProfessor("Luciana").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(ca.getProfessor("Maxuel").toString());
		System.out.println(ca.getProfessor("Maxuel").getRdm().mostrarDisciplinas() + "\n");

		System.out.println(
				"------------------------------------------------------------------------------------------------------------");

		System.out.println(ca.getAluno("João").toString());
		System.out.println(ca.getAluno("João").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(ca.getAluno("Josenelle").toString());
		System.out.println(ca.getAluno("Josenelle").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(ca.getAluno("Gabriel").toString());
		System.out.println(ca.getAluno("Gabriel").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(ca.getAluno("Evan").toString());
		System.out.println(ca.getAluno("Evan").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(ca.getAluno("Pedro").toString());
		System.out.println(ca.getAluno("Pedro").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(ca.getAluno("Henrique").toString());
		System.out.println(ca.getAluno("Henrique").getRdm().mostrarDisciplinas() + "\n");

		System.out.println(
				"------------------------------------------------------------------------------------------------------------");

		System.out.println(ca.buscaTurmaPeloNome("Metodos Avançados de Programação").toString());
		System.out.println("Quantidade de Alunos: "
				+ ca.buscaTurmaPeloNome("Metodos Avançados de Programação").quantidadeAlunos());
		System.out.println(ca.buscaTurmaPeloNome("Metodos Avançados de Programação").mostrarAlunos() + "\n");
		System.out.println(ca.buscaTurmaPeloNome("Banco de Dados").toString());
		System.out.println("Quantidade de Alunos: " + ca.buscaTurmaPeloNome("Banco de Dados").quantidadeAlunos());
		System.out.println(ca.buscaTurmaPeloNome("Banco de Dados").mostrarAlunos() + "\n");
		System.out.println(ca.buscaTurmaPeloNome("Redes").toString());
		System.out.println("Quantidade de Alunos: " + ca.buscaTurmaPeloNome("Redes").quantidadeAlunos());
		System.out.println(ca.buscaTurmaPeloNome("Redes").mostrarAlunos() + "\n");
		System.out.println(ca.buscaTurmaPeloNome("APS").toString());
		System.out.println("Quantidade de Alunos: " + ca.buscaTurmaPeloNome("APS").quantidadeAlunos());
		System.out.println(ca.buscaTurmaPeloNome("APS").mostrarAlunos() + "\n");
		System.out.println(ca.buscaTurmaPeloNome("Calculo 3").toString());
		System.out.println("Quantidade de Alunos: " + ca.buscaTurmaPeloNome("Calculo 3").quantidadeAlunos());
		System.out.println(ca.buscaTurmaPeloNome("Calculo 3").mostrarAlunos() + "\n");

	}
}
