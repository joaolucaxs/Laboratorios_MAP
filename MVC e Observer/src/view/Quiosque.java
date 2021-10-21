package src.view;

import src.model.listener.CadeiraListener;
import src.model.source.CadeiraEvent;
import src.model.source.Cadeira;
import src.model.source.Onibus;
import src.controller.SistemaRodoviaria;

public class Quiosque implements CadeiraListener {
    private static int numero;
    private int id;
    
    public Quiosque() {
        this.id = numero++;;
    }

    public int getId() {
        return id;
    }

    @Override
    public void mudancaNasCadeiras(CadeiraEvent event) {
        atualizarPainelQuiosque();
    }

    private void atualizarPainelQuiosque() {
        System.out.printf("\u001B[34m==================== Quiosque - %d ======================\u001B[0m\n", id);
        for (Onibus onibus : SistemaRodoviaria.getFrota()) {
            System.out.printf("Onibus: %d, Destino: %s\n", onibus.getNumero(), onibus.getRota());
            System.out.print("[ ");
            int numeroCadeira = 1;
            for (Cadeira cadeira : onibus.getCadeiras()) {
                if (cadeira.getAcento() == Cadeira.Disponivel) 
                    System.out.printf("\u001B[32m%d-Disponível\u001B[0m, ", numeroCadeira++);
                if (cadeira.getAcento() == Cadeira.Reservado)
                    System.out.printf("\u001B[33m%d-Reservado\u001B[0m, ", numeroCadeira++);
                if (cadeira.getAcento() == Cadeira.Indisponivel)
                    System.out.printf("\u001B[31m%d-Indisponível\u001B[0m, ", numeroCadeira++);
            }
            System.out.println("]");
        }
        System.out.printf("\u001B[34m========================================================\u001B[0m\n");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quiosque quiosque = (Quiosque) o;
        return this.id == quiosque.getId();
    }
}
