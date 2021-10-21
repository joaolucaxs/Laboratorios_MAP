package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDateTime;

import sig.SIG;
import administrativo.Agenda;
import controleAcademico.exceptions.AlunoException;
import controleAcademico.exceptions.ProfessorException;
import controleAcademico.exceptions.TurmaException;
import infraEstrutura.exceptions.SalaException;

public class Teste {
    private static SIG sig;
    private static Agenda agenda;

    @BeforeAll
    public static void startUp() {
        sig = new SIG();
        agenda = new Agenda();
    }

    @Test
    public void testAgendarReuniaoDaDiretoria() {
        assertTrue(agenda.agendarReuniao(LocalDateTime.of(2021, 8, 27, 11, 0, 0)));
        assertFalse(agenda.agendarReuniao(LocalDateTime.of(2021, 8, 27, 11, 0, 0)));
        assertTrue(agenda.getReunioes().contains(LocalDateTime.of(2021, 8, 27, 11, 0, 0)));
    }

    @Test
    public void testAgendarEntrevistaDaDiretoria() {
        assertTrue(agenda.agendarEntrevista(LocalDateTime.of(2021, 12, 25, 12, 0, 0)));
        assertFalse(agenda.agendarEntrevista(LocalDateTime.of(2021, 12, 25, 12, 0, 0)));
        assertTrue(agenda.getEntrevistas().contains(LocalDateTime.of(2021, 12, 25, 12, 0, 0)));
    }

    @Test
    public void testCadastrarDivida() {
        assertTrue(sig.getFinanceiro().cadastrarDivida("Bolsas", 4000.00, 0.00));
        assertTrue(sig.getFinanceiro().cadastrarDivida("Contas à pagar", 0.00, 10000.00));
    }

    @Test
    public void testCadastrarFuncionario() {
        assertTrue(sig.getFinanceiro().cadastrarFuncionario("Paulo Silva", 3000.00));
        assertTrue(sig.getFinanceiro().cadastrarFuncionario("Maria Gomes", 5000.00));
        assertFalse(sig.getFinanceiro().cadastrarFuncionario("Paulo Silva", 3000.00));
    }

    @Test
    public void testCadastrarProfessor() throws ProfessorException {
        assertTrue(sig.getControleAcademico().cadastrarProfessores("Sabrina", 123, 40.0));
        assertTrue(sig.getControleAcademico().cadastrarProfessores("Fabio", 456, 35.0));
        assertTrue(sig.getControleAcademico().cadastrarProfessores("Janderson", 789, 20.0));
        assertEquals(sig.getControleAcademico().getProfessor("Janderson").getNome(), "Janderson");
    }

    @Test
    public void testProfessorException(){
        assertThrows(ProfessorException.class, () -> {
            sig.getControleAcademico().getProfessor("Professor não existe");
        });
    }

    @Test
    public void testCadastrarTurmas() throws TurmaException {
        assertTrue(sig.getControleAcademico().cadastrarTurma("Metodos Avançados de Programação", "Segunda", "9:00"));
        assertTrue(sig.getControleAcademico().cadastrarTurma("Banco de Dados", "Segunda", "7:00"));
        assertTrue(sig.getControleAcademico().cadastrarTurma("Redes", "Terça", "11:00"));
        assertEquals(sig.getControleAcademico().buscaTurmaPeloNome("Redes").getDisciplina().getNome(), "Redes");
    }

    @Test
    public void testCadastrarAluno() throws AlunoException {
        assertTrue(sig.getControleAcademico().adicionarAlunos("João", 111, "Computação"));
		assertTrue(sig.getControleAcademico().adicionarAlunos("Josenelle", 222, "Computação"));
		assertTrue(sig.getControleAcademico().adicionarAlunos("Gabriel", 333, "Computação"));
        assertEquals(sig.getControleAcademico().getAluno("João").getNome(), "João");
    }

    @Test
    public void testAlunoException(){
        assertThrows(AlunoException.class, () -> {
            sig.getControleAcademico().getAluno("Aluno não existe");
        });
    }

    @Test
    public void testTurmaException() {
        assertThrows(TurmaException.class, () -> {
            sig.getControleAcademico().definirProfessorNaDisciplina("Fabio", "Turma não existe");
        });

        assertThrows(TurmaException.class, () -> {
            sig.getControleAcademico().buscaTurmaPeloNome("Teste turma não existe");
        });

        assertThrows(TurmaException.class, () -> {
            sig.getControleAcademico().cadastrarAlunosNaDisciplina("Josenelle", "Turma não existe");

        });
    }

    @Test
    public void testMateriaisCadastro(){
        assertTrue(sig.getAlmoxarifado().cadastrarMaterial("Cadeira", 300.00));
        assertTrue(sig.getAlmoxarifado().cadastrarMaterial("Apagador", 33.95));
        assertTrue(sig.getAlmoxarifado().comprarMaterial("Computador", 1785.00));        
    }

    @Test
    public void testSalas() throws TurmaException, SalaException{
        assertTrue(sig.getInfraEstrutura().cadastrarSala(201, "A", true));
        assertTrue(sig.getInfraEstrutura().cadastrarSala(103, "C", true));
        assertTrue(sig.getInfraEstrutura().cadastrarSala(104, "B", true));


        sig.getControleAcademico().cadastrarTurma("Banco de Dados", "Segunda", "7:00");


        assertTrue(sig.getInfraEstrutura().reservarSala(sig.getControleAcademico().buscaTurmaPeloNome("Banco de Dados"), 103, "C"));
        assertFalse(sig.getInfraEstrutura().reservarSala(sig.getControleAcademico().buscaTurmaPeloNome("Banco de Dados"), 103, "C"));
        assertTrue(sig.getInfraEstrutura().getSala(201, "A").getDisponivel());
        assertFalse(sig.getInfraEstrutura().getSala(103, "C").getDisponivel());
        assertTrue(sig.getInfraEstrutura().getSala(104, "B").getDisponivel());
    }

}
