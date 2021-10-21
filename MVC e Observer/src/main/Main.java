package src.main;

import src.controller.SistemaRodoviaria;
import src.exceptions.ExceptionLugarIndisponivel;

public class Main {
    public static void main(String[] args) throws ExceptionLugarIndisponivel {

        SistemaRodoviaria sistemaRodoviaria = new SistemaRodoviaria();
    
        sistemaRodoviaria.adicionarOnibus("Campina Grande - João Pessoa", 5);
        sistemaRodoviaria.adicionarOnibus("Campina Grande - Recife", 5);
        sistemaRodoviaria.adicionarOnibus("Campina Grande - Salvador", 5);

        sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
        sistemaRodoviaria.getGuiche().reservarPassagem("Campina Grande - Salvador");
        sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Salvador");
        sistemaRodoviaria.getGuiche().reservarPassagem("Campina Grande - João Pessoa");
        sistemaRodoviaria.getGuiche().reservarPassagem("Campina Grande - João Pessoa");

        /*sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
        sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
        sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
        sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");
        sistemaRodoviaria.getGuiche().comprarPassagem("Campina Grande - Recife");*/
        // SÓ PRA LANÇAR EXCEPTION

    }
}
