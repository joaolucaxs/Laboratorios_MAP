package exceptions;
public class ListaVaziaException extends Exception{

    public ListaVaziaException() {
        super("Lista Vazia", new Throwable("lista -1"));
    }
}
