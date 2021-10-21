package main;

import java.util.List; // retorna uma lista que não pode ser modificada
import java.util.ArrayList;
import java.util.Map;

import entidades.GloboFilmes;
import exceptions.FilmeNotExistException;

public class Main {
    public static void main(String[] args) throws FilmeNotExistException {
        GloboFilmes  globoFilmes = new GloboFilmes();
        
        //Não modificável! Map<K,V>
        globoFilmes.cadastrarFilme("Rocky II", 1979, Map.ofEntries(
                Map.entry("Sylvester Stallone", new ArrayList<>(List.of("Diretor", "Roteirista", "Ator"))),
                Map.entry("Talia Shire", new ArrayList<>(List.of("Ator"))),
                Map.entry("Carl Weathers", new ArrayList<>(List.of("Ator"))),
                Map.entry("Martin G. Beazell", new ArrayList<>(List.of("Cinegrafista")))),
                new ArrayList<>(List.of("Street Scat", "Two Kinds of Love", "Gonna Fly Now")));


        globoFilmes.cadastrarFilme("Rocky", 1976, Map.ofEntries(
                    Map.entry("John G. Avildsen", new ArrayList<>(List.of("Diretor"))),
                    Map.entry("Sylvester Stallone", new ArrayList<>(List.of("Roteirista", "Ator"))),
                    Map.entry("Talia Shire", new ArrayList<>(List.of("Ator"))),
                    Map.entry("Carl Weathers", new ArrayList<>(List.of("Ator"))),
                    Map.entry("Garrett Brown", new ArrayList<>(List.of("Cinegrafista")))),
                    new ArrayList<>(List.of("Take Me Back", "Gonna Fly Now", "Summer Madness")));

        System.out.println(globoFilmes.mostrarInformacoesFilme("Rocky II"));
        System.out.println(globoFilmes.mostrarInformacoesFilme("Rocky"));
        System.out.println(globoFilmes.mostrarFilmografia("Sylvester Stallone", "Diretor"));
        System.out.println(globoFilmes.mostrarFilmografia("Talia Shire", "Ator"));
    }
}
