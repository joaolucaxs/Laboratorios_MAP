package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Before;
import org.junit.Test;

import controle.entidades.*;

public class ProfessorTeste {
    static ControleAcademico ca;

    @Before
    public void setUp() {

        ca = new ControleAcademico();

		ca.cadastrarTurma("Metodos Avançados de Programação", "Segunda", "9:00");
		ca.cadastrarTurma("Banco de Dados", "Segunda", "7:00");
		ca.cadastrarTurma("Redes", "Terça", "11:00");
		ca.cadastrarTurma("APS", "Quarta", "7:00");
		ca.cadastrarTurma("Calculo 3", "Sexta", "7:00");
        ca.cadastrarTurma("Calculo 1", "Sexta", "15:00");


		ca.cadastrarProfessores("Sabrina", 123);
		ca.cadastrarProfessores("Fabio", 456);
		ca.cadastrarProfessores("Janderson", 789);
		ca.cadastrarProfessores("Luciana", 1011);
		ca.cadastrarProfessores("Maxuel", 1314);

        ca.definirProfessorNaDisciplina("Sabrina", "Banco de Dados");
		ca.definirProfessorNaDisciplina("Sabrina", "Metodos Avançados de Programação");
		ca.definirProfessorNaDisciplina("Fabio", "Redes");
		ca.definirProfessorNaDisciplina("Janderson", "APS");
		ca.definirProfessorNaDisciplina("Maxuel", "Calculo 3");
    }

    @Test
    public void testeAlunoAddDisciplina(){

        assertTrue(ca.definirProfessorNaDisciplina("Sabrina", "Calculo 1"));
        assertFalse(ca.definirProfessorNaDisciplina("Sabrina", "Calculo 1"));// false quando tento colocar de novo!
        assertFalse(ca.cadastrarAlunosNaDisciplina("Sabrina", "Banco de Dados")); // false quando tento colocar de novo!

    }
    @Test
    public void testNumDisciplinas(){
        assertEquals(2, ca.getProfessor("Sabrina").getRdm().getListaTurmas().size());
        assertTrue(ca.definirProfessorNaDisciplina("Sabrina", "Calculo 1"));
        assertEquals(3, ca.getProfessor("Sabrina").getRdm().getListaTurmas().size());
    }

    @Test
    public void testAlunoDados(){

        Professor professorTeste = new Professor("Fabio", 456);
        assertEquals(professorTeste.getNome(), ca.getProfessor("Fabio").getNome());
        assertEquals(professorTeste.getId(), ca.getProfessor("Fabio").getId());
        assertEquals(professorTeste.getRdm().getClass(), ca.getProfessor("Fabio").getRdm().getClass());
    }

    @Test
    public void testeProfessoresDiferentes(){
        assertNotEquals(ca.getProfessor("Fabio"), ca.getProfessor("Sabrina"));
    }

    @Test
    public void professorListaVazia(){
        assertNull(ca.getProfessor("Luciana").getRdm().mostrarDisciplinas());
    }

}