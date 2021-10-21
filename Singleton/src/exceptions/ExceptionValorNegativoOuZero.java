package exceptions;

public class ExceptionValorNegativoOuZero extends Exception {
    public ExceptionValorNegativoOuZero() {
        super("Valor invalido", new Throwable("valor < 0 ou valor = 0"));
    }
}
