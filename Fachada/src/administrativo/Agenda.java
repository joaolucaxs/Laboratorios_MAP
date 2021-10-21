package administrativo;

import java.util.ArrayList;


import java.time.LocalDateTime;

public class Agenda {
    private ArrayList<LocalDateTime> reunioes;
    private ArrayList<LocalDateTime> entrevistas;

    public Agenda() {
        this.reunioes = new ArrayList<>();
        this.entrevistas = new ArrayList<>();
    }

    public ArrayList<LocalDateTime> getReunioes() {
        return this.reunioes;
    }

    public ArrayList<LocalDateTime> getEntrevistas() {
        return this.entrevistas;
    }

    public void setReunioes(ArrayList<LocalDateTime> reunioes){
        this.reunioes = reunioes;
    }

    public void setEntrevistas(ArrayList<LocalDateTime> entrevistas){
        this.entrevistas = entrevistas;
    }

    public boolean agendarReuniao(LocalDateTime dataDaReuniao) {
        for (LocalDateTime date : reunioes) {
            if(date.isEqual(dataDaReuniao)){
                return false;
            }
        }
        this.reunioes.add(dataDaReuniao);
        return true;
    }

    public boolean agendarEntrevista(LocalDateTime dataDaEntrevista) {
        for (LocalDateTime date : entrevistas) {
            if(date.isEqual(dataDaEntrevista)){
                return false;
            }
        }
        this.entrevistas.add(dataDaEntrevista);
        return true;
    }

    public String mostrarReunioesDiretoria(){

        StringBuilder reunioesDiretoria = new StringBuilder();

        for (LocalDateTime date : reunioes) {
            reunioesDiretoria.append("Data:" +date.getDayOfMonth() +"/"+ date.getMonthValue()+"/"+ date.getYear() + " - Hora: "+ date.getHour()+":"+ date.getMinute()+":"+ date.getSecond()).append("\n");
        }
        return reunioesDiretoria.toString();
    }

    
    public String mostrarEntrevistasDiretoria() {

        StringBuilder entrevistasDiretoria = new StringBuilder();

        for (LocalDateTime date : entrevistas) {
            entrevistasDiretoria.append("Data:" +date.getDayOfMonth() +"/"+ date.getMonthValue()+"/"+ date.getYear() + " - Hora: "+ date.getHour()+":"+ date.getMinute()+":"+ date.getSecond()).append("\n");
        }
        return entrevistasDiretoria.toString();

    }
}
