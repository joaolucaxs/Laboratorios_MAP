package src.exceptions;
public class ExceptionLugarIndisponivel extends Exception {
    public ExceptionLugarIndisponivel() {
        super("Sem lugares disponíveis para esse destino", new Throwable("lugar indisponivel!"));
    }
}
