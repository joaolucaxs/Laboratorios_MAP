package src.view;

import src.model.listener.CadeiraListener;
import src.model.source.CadeiraEvent;
import src.model.source.Cadeira;
import src.model.source.Onibus;
import src.controller.SistemaRodoviaria;

/*public static final String ANSI_RESET = "\u001B[0m";
BLACK = "\u001B[30m";
RED = "\u001B[31m";
GREEN = "\u001B[32m";
YELLOW = "\u001B[33m";
BLUE = "\u001B[34m";
PURPLE = "\u001B[35m";
CYAN = "\u001B[36m";
WHITE = "\u001B[37m";
*/

public class PainelCentral implements CadeiraListener {
    @Override
    public void mudancaNasCadeiras(CadeiraEvent event) {
        atualizarPainelCentral();
    }

    private void atualizarPainelCentral() {
        
        System.out.printf("\u001B[35m==================== Painel Central ====================\u001B[0m\n");
        for (Onibus onibus : SistemaRodoviaria.getFrota()) {
            System.out.printf("Onibus: %d, Destino: %s\n", onibus.getNumero(), onibus.getRota());
            System.out.print("[ ");
            for (Cadeira cadeira : onibus.getCadeiras()) {
                if (cadeira.getAcento() == Cadeira.Disponivel) 
                    System.out.print("\u001B[32mDisponível\u001B[0m, ");
                if (cadeira.getAcento() == Cadeira.Reservado)
                    System.out.print("\u001B[33mReservado\u001B[0m, ");
                if (cadeira.getAcento() == Cadeira.Indisponivel)
                    System.out.print("\u001B[31mIndisponível\u001B[0m, ");
            }
            System.out.println("]");
        }
        System.out.printf("\u001B[35m========================================================\u001B[0m\n");
    }

}
