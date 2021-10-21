package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import controle.auxiliares.*;
import controle.entidades.*;

public class ControleTeste {
    static ControleAcademico ca;

    @Before
    public void setUp() {

        ca = new ControleAcademico();

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
		ca.cadastrarAlunosNaDisciplina("Gabriedl", "Metodos Avançados de Programação");
		ca.cadastrarAlunosNaDisciplina("Evan", "Calculo 3");
		ca.cadastrarAlunosNaDisciplina("Pedro", "Calculo 3");
		ca.cadastrarAlunosNaDisciplina("Henrique", "Calculo 3");
    }

    @Test
    public void testGetAllTurmas() {
        List<Turma> caTurmas = new ArrayList<>();

        caTurmas.add(new Turma("Metodos Avançados de Programação", "Segunda", "9:00"));
        caTurmas.add(new Turma("Banco de Dados", "Segunda", "7:00"));
        caTurmas.add(new Turma("Redes", "Terça", "11:00"));
        caTurmas.add(new Turma("APS", "Quarta", "7:00"));
        caTurmas.add(new Turma("Calculo 3", "Sexta", "7:00"));

        assertEquals(caTurmas.getClass(), ca.getListaTurmas().getClass());
    }

    @Test
    public void testGetTotalTurmas() {
        assertEquals(5, ca.getListaTurmas().size());
    }

    @Test
    public void testGetTurmaPeloNome() {
        assertEquals("Metodos Avançados de Programação", ca.buscaTurmaPeloNome("Metodos Avançados de Programação").getDisciplina().getNome());
    }

    @Test
    public void testGetTurmaPorId() {
        assertEquals("Banco de Dados", ca.getListaTurmas().get(1).getDisciplina().getNome());
    }


    @Test
    public void testAddTurma() {
        ca.cadastrarTurma("Paradigmas de Programação", "Quinta", "18:00");
        assertEquals("Paradigmas de Programação", ca.buscaTurmaPeloNome("Paradigmas de Programação").getDisciplina().getNome());               
    }


    @Test
    public void testGetAlunoPorNome() {
        assertEquals("João", ca.getAluno("João").getNome());
    }

    @Test
    public void testGetAlunoPorId() {
        assertEquals(333, ca.getAluno("Gabriel").getId());
    }

    @Test
    public void testGetAlunoPorIndex() {
        assertEquals("Josenelle", ca.getListaAlunos().get(1).getNome());
    }

    @Test
    public void testTotalAlunosTurmas() {
        assertEquals(5, ca.buscaTurmaPeloNome("Calculo 3").quantidadeAlunos());
    }

    @Test
    public void testGetAllAlunos() {

        List<Aluno> caAlunos = new ArrayList<>();

        caAlunos.add(new Aluno("João", 111, "Computação"));
        caAlunos.add(new Aluno("Josenelle", 222, "Computação"));
        caAlunos.add(new Aluno("Gabriel", 333, "Computação"));
        caAlunos.add(new Aluno("Evan", 444, "Química"));
        caAlunos.add(new Aluno("Pedro", 555, "Matemática"));
        caAlunos.add(new Aluno("Henrique", 666, "Física"));

        assertEquals(caAlunos.getClass(), ca.getListaAlunos().getClass());
    }

    @Test
    public void testAddAluno() {
        ca.adicionarAlunos("Novo Aluno", 900 , "Filosofia");
        assertEquals("Novo Aluno", ca.getAluno("Novo Aluno").getNome());
    }

     @Test
    public void testGetProfessorPorNome() {
        assertEquals("Sabrina", ca.getProfessor("Sabrina").getNome());
    }

    @Test
    public void testGetProfessorPorId() {
        assertEquals(456, ca.getProfessor("Fabio").getId());
    }

    @Test
    public void testGetProfessorPorIndex() {
        assertEquals("Janderson", ca.getListaProfessores().get(2).getNome());
    }

    @Test
    public void testGetAllProfessor() {

        List<Professor> caProfessores = new ArrayList<>();

        caProfessores.add(new Professor("Sabrina", 123));
        caProfessores.add(new Professor("Fabio", 456));
        caProfessores.add(new Professor("Janderson", 789));
        caProfessores.add(new Professor("Luciana", 1011));
        caProfessores.add(new Professor("Maxuel", 1314));

        assertEquals(caProfessores.getClass(), ca.getListaProfessores().getClass());
    }

    @Test
    public void testAddProfessor() {
        ca.cadastrarProfessores("Novo Professor", 1516);
        assertEquals("Novo Professor", ca.getProfessor("Novo Professor").getNome());
    }

}