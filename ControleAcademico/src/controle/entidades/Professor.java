package controle.entidades;
import controle.auxiliares.Pessoa;

public class Professor extends Pessoa{


    public Professor(String nome, int id) {
        super(nome, id);
    }

    @Override
    public String toString() {
        return "Professor: " + getNome();
    }
}
