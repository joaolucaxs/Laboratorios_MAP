package src.controller;

import java.util.List;
import java.util.ArrayList;

import src.model.source.Onibus;
import src.model.source.Cadeira;
import src.view.PainelCentral;
import src.view.Quiosque;
import src.view.Guiche;

public class SistemaRodoviaria {
    private static List<Onibus> frota;
    private static List<Quiosque> quiosques;
    private PainelCentral painelCentral;
    private Guiche guiche;

    public SistemaRodoviaria() {
        SistemaRodoviaria.frota = new ArrayList<Onibus>();
        SistemaRodoviaria.quiosques = new ArrayList<Quiosque>();
        painelCentral = new PainelCentral();
        guiche = new Guiche();

        for (int i = 0; i < 3; i++) {
            SistemaRodoviaria.quiosques.add(new Quiosque());
        }
    }

    public static List<Onibus> getFrota() {
        return frota;
    }

    public static List<Quiosque> getQuiosques() {
        return quiosques;
    }
    
    public Guiche getGuiche() {
        System.out.println();
        return this.guiche;
    }

    public boolean adicionarOnibus(String rota, int numeroCadeiras) {
        Onibus novoOnibus = new Onibus(SistemaRodoviaria.frota.size() + 1, rota, numeroCadeiras);
        for (Cadeira cadeira : novoOnibus.getCadeiras()) {
            for (Quiosque quiosque : SistemaRodoviaria.quiosques) {
                cadeira.addCadeiraListener(quiosque);
            }
            cadeira.addCadeiraListener(painelCentral);
        }
        SistemaRodoviaria.frota.add(novoOnibus);
        return true;
    }

    public static boolean aCadeiraDisponivel(String rota) {
        for (Onibus onibus : frota) {
            if (onibus.getRota().equals(rota)) {
                for (Cadeira cadeira : onibus.getCadeiras()) {
                    if (cadeira.getAcento() == Cadeira.Disponivel) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void alterarEstadoCadeiraPrimeiroDisponivel(int estado, String rota) {
        for (Onibus onibus : frota) {
            if (onibus.getRota().equals(rota)) {
                for (Cadeira cadeira : onibus.getCadeiras()) {
                    if (cadeira.getAcento() == Cadeira.Disponivel) {
                        cadeira.setAcento(estado);
                        return;
                    }
                }
            }
        }
    }
    
}
