package main;
import java.time.LocalDateTime;

import controleAcademico.exceptions.AlunoException;
import controleAcademico.exceptions.ProfessorException;
import controleAcademico.exceptions.TurmaException;
import sig.SIG;

public class Main {

    public static void main(String[] args) throws TurmaException, AlunoException, ProfessorException {
        // teste github
        SIG sig = new SIG();
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" +"\nSUBSISTEMA ADMINISTRATIVO\n");
        System.out.println("Agenda das reuniões da diretoria");
        sig.getAdministrativo().agendarReuniaoDaDiretoria(LocalDateTime.of(2021, 8, 27, 11, 0, 0));
        sig.getAdministrativo().agendarReuniaoDaDiretoria(LocalDateTime.of(2021, 8, 27, 11, 15, 0));

        System.out.println(sig.getAdministrativo().reunioesAgendadasDiretoria());

        System.out.println("Agenda das entrevitas da diretoria");
        sig.getAdministrativo().agendarEntrevistaDaDiretoria(LocalDateTime.of(2021, 12, 25, 12, 0, 0));
        sig.getAdministrativo().agendarEntrevistaDaDiretoria(LocalDateTime.of(2021, 12, 10, 18, 30, 0));
        System.out.println(sig.getAdministrativo().entrevistasAgendadasDiretoria());

        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" +"SUBSISTEMA FINANCEIRO\n");
        System.out.println("Balanço das Contas");
        sig.getFinanceiro().cadastrarDivida("Bolsas", 4000.00, 0.00);
        sig.getFinanceiro().cadastrarDivida("Contas à pagar", 0.00, 10000.00);

        System.out.println(sig.getFinanceiro().mostrarBalanco());

        System.out.println("Folha de Pagamentos");
        sig.getFinanceiro().cadastrarFuncionario("Paulo Silva", 3000.00);
        sig.getFinanceiro().cadastrarFuncionario("Maria Gomes", 5000.00);

        System.out.println(sig.getFinanceiro().mostrarFolhaDePagamentos());


        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" +"SUBSISTEMA PROFESSORES\n");
        System.out.println("Professores");

        sig.getControleAcademico().cadastrarTurma("Metodos Avançados de Programação", "Segunda", "9:00");
        sig.getControleAcademico().cadastrarTurma("Banco de Dados", "Segunda", "7:00");
        sig.getControleAcademico().cadastrarTurma("Redes", "Terça", "11:00");

        sig.getControleAcademico().cadastrarProfessores("Sabrina", 123, 40.0);
		sig.getControleAcademico().cadastrarProfessores("Fabio", 456, 35.0);
		sig.getControleAcademico().cadastrarProfessores("Janderson", 789, 20.0);

        System.out.println(sig.getControleAcademico().getListaProfessores());

        System.out.println("\nTempo de casa dos professores: ");
        System.out.println("Sabrina: "+ sig.getControleAcademico().getProfessor("Sabrina").getTempoDeCasa());
        System.out.println("Fabio: " + sig.getControleAcademico().getProfessor("Fabio").getTempoDeCasa());
        System.out.println("Janderson: "+ sig.getControleAcademico().getProfessor("Janderson").getTempoDeCasa());

        sig.getControleAcademico().definirProfessorNaDisciplina("Fabio", "Banco de Dados");
		sig.getControleAcademico().definirProfessorNaDisciplina("Sabrina", "Metodos Avançados de Programação");
		sig.getControleAcademico().definirProfessorNaDisciplina("Janderson", "Redes");

        System.out.println("");
        System.out.println("\nRDM dos Professores: ");
        System.out.println(sig.getControleAcademico().getProfessor("Fabio").toString());
		System.out.println(sig.getControleAcademico().getProfessor("Fabio").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(sig.getControleAcademico().getProfessor("Sabrina").toString());
		System.out.println(sig.getControleAcademico().getProfessor("Sabrina").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(sig.getControleAcademico().getProfessor("Janderson").toString());
		System.out.println(sig.getControleAcademico().getProfessor("Janderson").getRdm().mostrarDisciplinas() + "\n");

        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" +"SUBSISTEMA ALUNOS\n");
        System.out.println("Alunos");

        sig.getControleAcademico().adicionarAlunos("João", 111, "Computação");
		sig.getControleAcademico().adicionarAlunos("Josenelle", 222, "Computação");
		sig.getControleAcademico().adicionarAlunos("Gabriel", 333, "Computação");

        sig.getControleAcademico().cadastrarAlunosNaDisciplina("João", "Banco de Dados");
		sig.getControleAcademico().cadastrarAlunosNaDisciplina("João", "Metodos Avançados de Programação");
		sig.getControleAcademico().cadastrarAlunosNaDisciplina("Josenelle", "Banco de Dados");
		sig.getControleAcademico().cadastrarAlunosNaDisciplina("Gabriel", "Redes");
		sig.getControleAcademico().cadastrarAlunosNaDisciplina("Gabriel", "Metodos Avançados de Programação");

        System.out.println(sig.getControleAcademico().getAluno("João").toString());
		System.out.println(sig.getControleAcademico().getAluno("João").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(sig.getControleAcademico().getAluno("Josenelle").toString());
		System.out.println(sig.getControleAcademico().getAluno("Josenelle").getRdm().mostrarDisciplinas() + "\n");
		System.out.println(sig.getControleAcademico().getAluno("Gabriel").toString());
		System.out.println(sig.getControleAcademico().getAluno("Gabriel").getRdm().mostrarDisciplinas() + "\n");

        System.out.println("-------------------------------------------------------------------------------------------------");
       System.out.println("\033[0;1m" +"SUBSISTEMA ALMOXARIFADO\n");
       System.out.println("Materiais");

       sig.getAlmoxarifado().cadastrarMaterial("Cadeira", 300.00);
       sig.getAlmoxarifado().cadastrarMaterial("Apagador", 33.95);
       sig.getAlmoxarifado().comprarMaterial("Computador", 1785.00);

       System.out.println(sig.getAlmoxarifado().mostrarEstoque());
        
       System.out.println("-------------------------------------------------------------------------------------------------");
       System.out.println("\033[0;1m" +"SUBSISTEMA INFRAESTRUTURA\n");
       System.out.println("Salas");
        
       sig.getInfraEstrutura().cadastrarSala(201, "A", true);
       sig.getInfraEstrutura().cadastrarSala(103, "C", true);
       sig.getInfraEstrutura().cadastrarSala(104, "B", true);

       System.out.println(sig.getInfraEstrutura().mostrarSalas());

       sig.getInfraEstrutura().reservarSala(sig.getControleAcademico().buscaTurmaPeloNome("Banco de Dados"), 103, "C");

       System.out.println("Salas disponíveis");
       System.out.println(sig.getInfraEstrutura().mostrarSalasDisponiveis());

    }
}
