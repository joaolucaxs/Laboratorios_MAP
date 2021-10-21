package test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import src.controller.SistemaRodoviaria;
import src.exceptions.ExceptionLugarIndisponivel;
import src.model.source.Cadeira;
import src.view.Quiosque;

public class Tests {

    private static SistemaRodoviaria sistemaRodoviaria;
    @Test
    public void testAdicionarOnibus() {
        sistemaRodoviaria = new SistemaRodoviaria();
        sistemaRodoviaria.adicionarOnibus("Campina Grande - João Pessoa", 5);
        sistemaRodoviaria.adicionarOnibus("Campina Grande - Recife", 5);
        sistemaRodoviaria.adicionarOnibus("Campina Grande - Salvador", 5);
        assertEquals(3, SistemaRodoviaria.getFrota().size());
    }

    @Test
    public void testLugarDisponivel() throws ExceptionLugarIndisponivel{
        sistemaRodoviaria = new SistemaRodoviaria();
        sistemaRodoviaria.adicionarOnibus("Campina Grande - Recife", 5);
        assertThrows(ExceptionLugarIndisponivel.class, () -> {
            sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
            sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
            sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
            sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
            sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
            sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
        });
    }
    

    @Test
    public void testACadeiraDisponivel() {
        SistemaRodoviaria sistemaRodoviaria = new SistemaRodoviaria();
        sistemaRodoviaria.adicionarOnibus("Campina Grande - Recife", 9);
        assertTrue(SistemaRodoviaria.aCadeiraDisponivel("Campina Grande - Recife"));
    }

    @Test
    public void testAlterarEstadoCadeiraPrimeiroDisponivel() {
        sistemaRodoviaria = new SistemaRodoviaria();
        sistemaRodoviaria.adicionarOnibus("Campina Grande - Recife", 9);
        SistemaRodoviaria.alterarEstadoCadeiraPrimeiroDisponivel(Cadeira.Reservado, "Campina Grande - Recife");
        assertEquals(Cadeira.Reservado, SistemaRodoviaria.getFrota().get(0).getCadeiras()[0].getAcento());
    }

    @Test
    public void testAddCadeiraListener() {
        Cadeira cadeira = new Cadeira();
        cadeira.addCadeiraListener(new Quiosque());
        assertEquals(1, cadeira.getCadeiraListeners().size());
        cadeira.addCadeiraListener(new Quiosque());
        assertEquals(2, cadeira.getCadeiraListeners().size());

    }

    @Test
    public void testRemoveCadeiraListener() {
        Cadeira cadeira = new Cadeira();
        Quiosque quiosque = new Quiosque();
        cadeira.addCadeiraListener(quiosque);
        cadeira.removeCadeiraListener(quiosque);
        assertEquals(0, cadeira.getCadeiraListeners().size());
    }
}
