package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import entidades.GloboFilmes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exceptions.FilmeNotExistException;

public class TesteGloboFilmes {

    static GloboFilmes globoFilmes;
    static GloboFilmes filmeteste;

    @BeforeAll
    public static void setUp() {
        globoFilmes = new GloboFilmes();
        globoFilmes.cadastrarFilme("Rocky", 1976, Map.ofEntries(
                    Map.entry("John G. Avildsen", new ArrayList<>(List.of("Diretor"))),
                    Map.entry("Sylvester Stallone", new ArrayList<>(List.of("Roteirista", "Ator"))),
                    Map.entry("Talia Shire", new ArrayList<>(List.of("Ator"))),
                    Map.entry("Carl Weathers", new ArrayList<>(List.of("Ator"))),
                    Map.entry("Garrett Brown", new ArrayList<>(List.of("Cinegrafista")))),
                    new ArrayList<>(List.of("Take Me Back", "Gonna Fly Now", "Summer Madness")));

        filmeteste = new GloboFilmes();
        filmeteste.cadastrarFilme("Rocky", 1976, Map.ofEntries(
                    Map.entry("John G. Avildsen", new ArrayList<>(List.of("Diretor"))),
                    Map.entry("Sylvester Stallone", new ArrayList<>(List.of("Roteirista", "Ator"))),
                    Map.entry("Talia Shire", new ArrayList<>(List.of("Ator"))),
                    Map.entry("Carl Weathers", new ArrayList<>(List.of("Ator"))),
                    Map.entry("Garrett Brown", new ArrayList<>(List.of("Cinegrafista")))),
                    new ArrayList<>(List.of("Take Me Back", "Gonna Fly Now", "Summer Madness")));
    }
    @Test
    public void testeCadastrarFilmeFail() {

        assertFalse(globoFilmes.cadastrarFilme("Rocky", 1976, Map.ofEntries(
            Map.entry("John G. Avildsen", new ArrayList<>(List.of("Diretor"))),
            Map.entry("Sylvester Stallone", new ArrayList<>(List.of("Roteirista", "Ator"))),
            Map.entry("Talia Shire", new ArrayList<>(List.of("Ator"))),
            Map.entry("Carl Weathers", new ArrayList<>(List.of("Ator"))),
            Map.entry("Garrett Brown", new ArrayList<>(List.of("Cinegrafista")))),
            new ArrayList<>(List.of("Take Me Back", "Gonna Fly Now", "Summer Madness"))));
        
    }

    @Test
    public void testeCadastrarFilmeSucess() {

        assertTrue(globoFilmes.cadastrarFilme("Rocky II", 1979, Map.ofEntries(
            Map.entry("Sylvester Stallone", new ArrayList<>(List.of("Diretor", "Roteirista", "Ator"))),
            Map.entry("Talia Shire", new ArrayList<>(List.of("Ator"))),
            Map.entry("Carl Weathers", new ArrayList<>(List.of("Ator"))),
            Map.entry("Martin G. Beazell", new ArrayList<>(List.of("Cinegrafista")))),
            new ArrayList<>(List.of("Street Scat", "Two Kinds of Love", "Gonna Fly Now"))));
    }

    @Test 
    public void testeMostrarFilmeEquals() throws FilmeNotExistException{
        assertEquals(globoFilmes.mostrarInformacoesFilme("Rocky"), filmeteste.mostrarInformacoesFilme("Rocky"));
    }

    @Test
    public void mostrarFilmografia(){
        assertEquals(filmeteste.mostrarFilmografia("Carl Weathers", "Ator"), globoFilmes.mostrarFilmografia("Carl Weathers", "Ator"));
    }

    @Test
    public void lancarExceptionFilme(){
        assertThrows(FilmeNotExistException.class, () -> {
            globoFilmes.mostrarInformacoesFilme("Rambo: First Blood");
        });
    }

}


