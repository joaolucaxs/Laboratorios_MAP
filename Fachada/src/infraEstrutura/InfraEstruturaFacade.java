package infraEstrutura;
import controleAcademico.auxiliares.*;
import infraEstrutura.exceptions.SalaException;

import java.util.ArrayList;

public class InfraEstruturaFacade {
    public ArrayList<Sala> salas;

    public InfraEstruturaFacade() {
        this.salas = new ArrayList<>();
    }

    public boolean cadastrarSala(int numero, String bloco, boolean disponivel) {
        Sala novaSala = new Sala(numero, bloco, disponivel);
        if (salas.contains(novaSala)) {
            return false;
        }
        this.salas.add(novaSala);
        return true;
    }

    public String mostrarSalasDisponiveis() {

        StringBuilder salasTrue = new StringBuilder();

        for (Sala sala : salas) {
            if (sala.getDisponivel()) {
                salasTrue.append(sala.toString()).append("\n");
            }
        }

        return salasTrue.toString();
    }

    public String mostrarSalas() {

        StringBuilder salasAll = new StringBuilder();
        for (Sala sala : salas) {
            salasAll.append(sala.toString()).append("\n");
        }
        return salasAll.toString();
    }

    public boolean reservarSala(Turma turma, int numero, String bloco) {
        for (Sala sala : salas) {
            if (sala.getNumero() == numero && sala.getBloco().equals(bloco)) {
                if(sala.getDisponivel()){
                    sala.setDisponivel(false);
                    return true;
                }
            }
        }
        return false;
    }

    public Sala getSala(int numero, String bloco) throws SalaException{

        for (Sala sala : salas) {
            if (sala.getNumero()==numero && sala.getBloco().equals(bloco)) {
                return sala;
            }
        }
        throw new SalaException();
    }
    
}
