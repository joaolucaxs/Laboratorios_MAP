package test;

import org.junit.jupiter.api.Test;

import entidades.Filme;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;

public class TesteFilme {

    @Test
    public void testeCadastrarFuncionario(){

        Filme filme = new Filme("Rocky", 1976);
        assertTrue(filme.cadastrarFuncionario("Paulo", new ArrayList<>(List.of("Diretor", "Roteirista", "Ator"))));
        assertFalse(filme.cadastrarFuncionario("Paulo", new ArrayList<>(List.of("Diretor", "Roteirista", "Ator"))));
    }
}
