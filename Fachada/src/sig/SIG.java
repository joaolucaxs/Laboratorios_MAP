package sig;

import administrativo.AdministrativoFacade;
import financeiro.FinanceiroFacade;
import controleAcademico.ControleAcademicoFacade;
import almoxarifado.AlmoxarifadoFacade;
import infraEstrutura.InfraEstruturaFacade;


public class SIG {

    final private FinanceiroFacade financeiro;
    final private AdministrativoFacade administrativo;
    final private ControleAcademicoFacade controleAcademico;
    final private AlmoxarifadoFacade almoxarifado;
    final private InfraEstruturaFacade infraEstrutura;

    public SIG() {
        this.financeiro = new FinanceiroFacade();
        this.administrativo = new AdministrativoFacade();
        this.controleAcademico = new ControleAcademicoFacade();
        this.almoxarifado = new AlmoxarifadoFacade();
        this.infraEstrutura = new InfraEstruturaFacade();
    }

    public FinanceiroFacade getFinanceiro() {
        return this.financeiro;
    }

    public AdministrativoFacade getAdministrativo() {
        return this.administrativo;
    }

    public ControleAcademicoFacade getControleAcademico() {
        return this.controleAcademico;
    }

    public AlmoxarifadoFacade getAlmoxarifado() {
        return this.almoxarifado;
    }

    public InfraEstruturaFacade getInfraEstrutura() {
        return this.infraEstrutura;
    }
}
