package administrativo;
import java.time.LocalDateTime;


public class AdministrativoFacade {
    private Agenda agenda;

    public AdministrativoFacade() {
        this.agenda = new Agenda();
    }

    public Agenda getAgenda(){
        return this.agenda;
    }
    
    public void setAgenda(Agenda agenda){
        this.agenda = agenda;
    }

    public boolean agendarReuniaoDaDiretoria(LocalDateTime dataDaReuniao) {
        return this.agenda.agendarReuniao(dataDaReuniao);
    }

    public boolean agendarEntrevistaDaDiretoria(LocalDateTime dataDaEntrevista) {
        return this.agenda.agendarEntrevista(dataDaEntrevista);
    }

    public String reunioesAgendadasDiretoria(){
        return this.agenda.mostrarReunioesDiretoria();
    }

    public String entrevistasAgendadasDiretoria() {
        return this.agenda.mostrarEntrevistasDiretoria();
    }
}
