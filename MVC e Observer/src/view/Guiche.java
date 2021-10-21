package src.view;

import src.controller.SistemaRodoviaria;
import src.exceptions.ExceptionLugarIndisponivel;
import src.model.source.Cadeira;

public class Guiche {
    
    public void comprarPassagem(String rota) throws ExceptionLugarIndisponivel {
        if (!SistemaRodoviaria.aCadeiraDisponivel(rota)) {
            throw  new ExceptionLugarIndisponivel();
        }
        SistemaRodoviaria.alterarEstadoCadeiraPrimeiroDisponivel(Cadeira.Indisponivel, rota);
    }

    public void reservarPassagem(String rota) throws ExceptionLugarIndisponivel {
        if (!SistemaRodoviaria.aCadeiraDisponivel(rota)) {
            throw  new ExceptionLugarIndisponivel();
        }
        SistemaRodoviaria.alterarEstadoCadeiraPrimeiroDisponivel(Cadeira.Reservado, rota);
    }

}

