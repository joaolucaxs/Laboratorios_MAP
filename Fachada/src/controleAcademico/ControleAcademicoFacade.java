package controleAcademico;

import java.util.ArrayList;
import java.util.List;

import controleAcademico.auxiliares.Turma;
import controleAcademico.exceptions.AlunoException;
import controleAcademico.exceptions.ProfessorException;
import controleAcademico.exceptions.TurmaException;
import controleAcademico.models.Aluno;
import controleAcademico.models.Professor;

public class ControleAcademicoFacade {

    private List<Aluno> listaAlunos;
    private List<Professor> professoresCadastrados;
    private List<Turma> listaTurmas;
    
    public ControleAcademicoFacade() {
        listaTurmas = new ArrayList<>();
        listaAlunos = new ArrayList<>();
        professoresCadastrados = new ArrayList<>();
    }

    public List<Professor> getListaProfessores(){
        return professoresCadastrados;
    }

    public List<Aluno> getListaAlunos(){
        return listaAlunos;
    }

    public List<Turma> getListaTurmas(){
        return listaTurmas;
    }

    public Professor getProfessor(String nome) throws ProfessorException {

        for (Professor professor : professoresCadastrados) {
            if (professor.getNome().equals(nome)) {
                return professor;
            }
        }
        throw new ProfessorException(); // ADICIONAR UMA EXCEPTION

    }

    public Aluno getAluno(String nome) throws AlunoException {

        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equals(nome)) {
                return aluno;
            }
        }
        throw new AlunoException();

    }

    public boolean cadastrarTurma(String nome, String dia, String hora) {

        Turma turma = new Turma(nome, dia, hora);

        if (listaTurmas.contains(turma)) {
            return false;
        }
        listaTurmas.add(turma);
        return true;

    }

    public boolean cadastrarProfessores(String nome, int id, double tempoDeCasa) {
        Professor professor = new Professor(nome, id, tempoDeCasa);

        if (professoresCadastrados.contains(professor)) {
            return false;
        }
        professoresCadastrados.add(professor);
        return true;
    }

    public boolean adicionarAlunos(String nome, int matricula, String curso) {
        Aluno aluno = new Aluno(nome, matricula, curso);

        if (listaAlunos.contains(aluno)) {
            return false;
        }
        listaAlunos.add(aluno);
        return true;
    }

    public boolean cadastrarAlunosNaDisciplina(String nomeAluno, String nomeDisciplina) throws TurmaException {

        Turma turma = buscaTurmaPeloNome(nomeDisciplina);
        for (Aluno alunofor : listaAlunos) {
            if (alunofor.getNome().equals(nomeAluno)) {
                if(alunofor.adicionarDisciplina(turma)){
                    if(turma.adicionarAlunoNaLista(alunofor)){
                        return true;

                    }

                }
            }
        }
        return false;

    }

    public Turma buscaTurmaPeloNome(String nome) throws TurmaException {

        for (Turma turma : listaTurmas) {
            if (turma.getDisciplina().getNome().equals(nome)) {
                return turma;
            }
        }
        throw new TurmaException(); 
    }

    public boolean definirProfessorNaDisciplina(String nomeProfessor, String nomeDisciplina) throws TurmaException {

        Turma disciplina = buscaTurmaPeloNome(nomeDisciplina);
        if (buscaTurmaPeloNome(nomeDisciplina) != null) {
            if(disciplina.getProfessor()!=null){
                return false;
            }
            for (Professor professor : professoresCadastrados) {
                if (professor.getNome().equals(nomeProfessor)) {
                    if(professor.adicionarDisciplina(disciplina)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

}
