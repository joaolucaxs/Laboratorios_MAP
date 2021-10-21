package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Before;
import org.junit.Test;

import controle.entidades.*;

public class AlunoTeste {
    static ControleAcademico ca;

    @Before
    public void setUp() {

        ca = new ControleAcademico();

		ca.cadastrarTurma("Metodos Avançados de Programação", "Segunda", "9:00");
		ca.cadastrarTurma("Banco de Dados", "Segunda", "7:00");
		ca.cadastrarTurma("APS", "Quarta", "7:00");
		ca.cadastrarTurma("Calculo 3", "Sexta", "7:00");
		ca.cadastrarTurma("Redes", "Terça", "11:00");

		ca.adicionarAlunos("João", 111, "Computação");
		ca.adicionarAlunos("Josenelle", 222, "Computação");
		ca.adicionarAlunos("Gabriel", 333, "Computação");
		ca.adicionarAlunos("Evan", 444, "Química");
		ca.adicionarAlunos("Pedro", 555, "Matemática");
		ca.adicionarAlunos("Henrique", 666, "Física");
        ca.adicionarAlunos("Igor", 777, "Filosofia");

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

    }

    @Test
    public void testeAlunoAddDisciplina(){

        assertTrue(ca.cadastrarAlunosNaDisciplina("João", "Redes"));
        assertFalse(ca.cadastrarAlunosNaDisciplina("João", "Redes"));// false quando tento colocar de novo!
        assertFalse(ca.cadastrarAlunosNaDisciplina("João", "APS")); // false quando tento colocar de novo!

    }
    @Test
    public void testNumDisciplinas(){
        assertEquals(4, ca.getAluno("João").getRdm().getListaTurmas().size());
        assertTrue(ca.cadastrarAlunosNaDisciplina("João", "Redes"));
        assertEquals(5, ca.getAluno("João").getRdm().getListaTurmas().size());
    }

    @Test
    public void testAlunoDados(){

        Aluno alunoTeste = new Aluno("João", 111, "Computação");
        assertEquals(alunoTeste.getCurso(), ca.getAluno("João").getCurso());
        assertEquals(alunoTeste.getId(), ca.getAluno("João").getId());
        assertEquals(alunoTeste.getNome(), ca.getAluno("João").getNome());
        assertEquals(alunoTeste.getRdm().getClass(), ca.getAluno("João").getRdm().getClass());
    }

    @Test
    public void testDisciplinasIguais(){

        ca.adicionarAlunos("Aluno Teste", 111, "Computação");
        ca.cadastrarAlunosNaDisciplina("Aluno Teste", "Banco de Dados");
		ca.cadastrarAlunosNaDisciplina("Aluno Teste", "Metodos Avançados de Programação");
		ca.cadastrarAlunosNaDisciplina("Aluno Teste", "APS");
		ca.cadastrarAlunosNaDisciplina("Aluno Teste", "Calculo 3");
        assertEquals(ca.getAluno("Aluno Teste").getRdm().getListaTurmas(), ca.getAluno("João").getRdm().getListaTurmas());

    }

    @Test
    public void testeAlunosDiferentes(){
        assertNotEquals(ca.getAluno("Pedro"), ca.getAluno("João"));
    }

    @Test
    public void alunosListaVazia(){
        assertNull(ca.getAluno("Igor").getRdm().mostrarDisciplinas());
    }

    @Test
    public void contaisAll(){
        assertFalse(ca.getAluno("João").getRdm().mostrarDisciplinas().containsAll(ca.getListaTurmas()));
        ca.cadastrarAlunosNaDisciplina("João", "Redes");
        assertTrue(ca.getAluno("João").getRdm().mostrarDisciplinas().containsAll(ca.getListaTurmas()));
    }



}