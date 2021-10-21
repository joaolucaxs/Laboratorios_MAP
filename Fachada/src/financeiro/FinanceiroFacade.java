package financeiro;

import java.util.ArrayList;

public class FinanceiroFacade {
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Divida> dividasEmGeral;
    
    public FinanceiroFacade() {
        this.funcionarios = new ArrayList<>();
        this.dividasEmGeral = new ArrayList<>();
    }

    public ArrayList<Divida> getDividas() {
        return this.dividasEmGeral;
    }
    public ArrayList<Funcionario> getFuncionarios() {
        return this.funcionarios;
    }

    public boolean cadastrarDivida(String nome, double debito, double credito) {
        
        Divida novaDivida = new Divida(nome, debito, credito);

        if (dividasEmGeral.contains(novaDivida)) {
            return false;
        }
        dividasEmGeral.add(novaDivida);
        return true;
    }
 
    public boolean cadastrarFuncionario(String nome, double salario) {
        Funcionario novoFuncionario = new Funcionario(nome, salario);

        if (funcionarios.contains(novoFuncionario)) {
            return false;
        }
        this.funcionarios.add(novoFuncionario);
        return true;
    }

    public String mostrarBalanco() {

        StringBuilder balanco = new StringBuilder();

        for (Divida divida : dividasEmGeral) {
            balanco.append(divida.toString()).append("\n");
        }
        return balanco.toString();
    }

    public String mostrarFolhaDePagamentos() {

        StringBuilder folhaPagamento = new StringBuilder();

        for (Funcionario funcionario : funcionarios) {
            folhaPagamento.append("Funcionario:").append(funcionario.getNome()).append(", Salário à pagar: ").append(funcionario.getSalario()).append("\n");
        }

        return folhaPagamento.toString();
    }

}
